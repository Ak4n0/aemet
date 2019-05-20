package aemet.modelo;

import aemet.modelo.entidades.*;
import aemet.modelo.persistencia.*;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase estática que controla las diferentes partes del backend.
 * @author Miquel A. Fuster
 */
public class Control {
    
    /**
     * Obtiene un objeto Provincia desde la BBDD a partir de su nombre.
     * @param nombre Nombre de la provincia.
     * @return Objeto Provincia que representa la provincia buscada.
     */
    public static Provincia obtenerProvincia(String nombre) {
        // Se registra la provincia en la base de datos a partir de su nombre.
        registrarProvincia(nombre);
        // Se saca de la BBDD el objeto completo que representa la noticia.
        return ProvinciaCRUD.obtener(nombre);
    }
    
    /**
     * Se obtienen todas las provincias que hay guardadas en la BBDD.
     * @return Una lista con todas las provincias.
     */
    public static Collection<Provincia> obtenerListaProvincias() {
        return ProvinciaCRUD.obtenerTodas();
    }

    /**
     * Registra una nueva provincia en la BBDD. Se inserta con sólo el nombre
     * y la BBDD se encarga de completar el objeto.
     * @param nombre Nombre de la provincia a insertar en la BBDD.
     */
    private static void registrarProvincia(String nombre) {
        Provincia provincia = new Provincia(nombre);
        ProvinciaCRUD.guardar(provincia);
    }

    /**
     * Consigue las estaciones desde internet y las guarda en la BBDD.
     * @throws Exception 
     */
    public static void actualizarEstaciones() throws Exception {
        Collection<Estacion> lista = Integracion.obtenerEstaciones();
        for (Estacion estacion : lista) {
            EstacionCRUD.guardar(estacion);
        }
    }

    /**
     * Obtiene todas las estaciones de una provincia dada desde la BBDD.
     * @param provincia Provincia de la cual se desean obtener las estaciones.
     * @return Lista de estaciones.
     */
    public static Collection<Estacion> obtenerListaEstaciones(Provincia provincia) {
        return EstacionCRUD.obtenerLista(provincia);
    }

    /**
     * Actualiza las mediciones, conseguidas desde internet, de todas las estaciones
     * que hay en la BBDD.
     * @throws Exception Lanza la excepción si no ha conseguido conectar con AEMET
     */
    public static void actualizarMediciones() throws Exception {
        Collection<Estacion> listaEstaciones = EstacionCRUD.obtenerEstacionesConMediciones();
        Collection<Medicion> listaMediciones = null;
        // Intentos de reconexión a la AEMET
        int intentos = 0;
        for (Estacion estacion : listaEstaciones) {
            try {
                listaMediciones = Integracion.obtenerMedicion(estacion);
            } catch (Exception ex) {
                // Si se superan los 3 intentos se lanzará una exceptción que informará de que
                // no se ha podido conectar a la vase de datos.
                if(++intentos == 3)
                    throw new Exception("No se pudieron descargar datos desde la AEMET");
            }
            
            for (Medicion medicion : listaMediciones) {
                MedicionCRUD.guardar(medicion);
            }
        }
    }

    /**
     * Obtiene una lista de todas las mediciones desde la BBDD de una
     * estación dada.Si la lista está vacía intentará conseguir nuevos
     * datos desde la AEMET.
     * @param estacion Estación de la que se quieren recuperar las mediciones
     * @return Lista de mediciones.
     */
    public static Collection<Medicion> obtenerMedicionesDeEstacion(Estacion estacion) {
        Collection<Medicion> lista = MedicionCRUD.obtenerListaDeEstacion(estacion);
        if(lista.isEmpty()) {
            try {
                // Si la lista está vacía busca si hay datos en la AEMET
                for(Medicion m: Integracion.obtenerMedicion(estacion))
                    MedicionCRUD.guardar(m);
            } catch (Exception ex) {
                // Si no puede conectar con internet lanza una excepción
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        lista = MedicionCRUD.obtenerListaDeEstacion(estacion);
        return lista;
    }
}
