package aemet.modelo;

import aemet.api.APIUtils;
import aemet.api.ObservacionEstacion;
import aemet.modelo.entidades.Estacion;
import aemet.modelo.entidades.Medicion;
import aemet.modelo.entidades.Provincia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Se encarga de pedir y recibir datos al servidor de AEMET.
 * @author Miquel A. Fuster
 */
public class Integracion {
    
    /**
     * Obtiene una lista con todas las estaciones de las que la AEMET proporciona
     * datos.
     * @return Una lista con las estaciones obtenidas.
     * @throws Exception Lanza una excepción si no puede conectarse a la AEMET.
     */
    public static Collection<Estacion> obtenerEstaciones() throws Exception {
        Provincia provincia;
        Collection<Estacion> listaEstaciones = new ArrayList<>();
        ArrayList<aemet.api.Estacion> aemetEstaciones = APIUtils.getStations();
        // Esta LUT como buffer para, al crear las estaciones, no tener que conseguir el objeto
        // Provincia necesario cada vez desde la BBDD.
        Map<String, Provincia> lookUpTable = new HashMap<>();
        
        for(aemet.api.Estacion estacion: aemetEstaciones) {
            // Obtiene la provincia de la estación conseguida desde la AEMET
            String aemetProvincia = estacion.getProvincia();
            // Si existe la provincia en la LUT obtiene el objeto que la representa
            if(lookUpTable.containsKey(aemetProvincia)) {
                provincia = lookUpTable.get(aemetProvincia);
            }
            else {
                // Si no está en la LUT se carga desde la BBDD
                provincia = Control.obtenerProvincia(aemetProvincia);
                // y se inserta en la LUT para posteriores búsquedas mas rápidas
                lookUpTable.put(aemetProvincia, provincia);
            }
            // Se inserta la estación nueva en la lista
            listaEstaciones.add(new Estacion(estacion.getIndicativo(),
                                             provincia,
                                             estacion.getNombre(),
                                             estacion.getLatitud(),
                                             estacion.getLongitud(),
                                             Integer.parseInt(estacion.getAltitud())));
        }
        return listaEstaciones;
    }
    
    /**
     * Obtiene datos de mediciones de la AEMET de una estación dada.
     * @param estacion Estación para la que se solicitan las mediciones.
     * @return Una lista de mediciones de la una estación.
     * @throws Exception Lanza una excepción si no consigue conectarse a la AEMET
     */
    public static Collection<Medicion> obtenerMedicion(Estacion estacion) throws Exception {
        Collection<Medicion> listaMediciones = new ArrayList<>();
        ArrayList<ObservacionEstacion> observaciones = APIUtils.getObservacionEstacion(estacion.getIdEstacion());
        
        for(ObservacionEstacion observacion: observaciones) {
            listaMediciones.add(new Medicion(estacion,
                                             observacion.getFint(),
                                             observacion.getVmax(),
                                             observacion.getVv(),
                                             observacion.getDv(),
                                             observacion.getPrec(),
                                             observacion.getHr(),
                                             observacion.getPres(),
                                             observacion.getInso(),
                                             observacion.getTamax(),
                                             observacion.getTa(),
                                             observacion.getTamin(),
                                             observacion.getNieve()));
        }
        
        return listaMediciones;
    }
    
}
