package aemet.modelo.persistencia;

import aemet.modelo.HibernateUtil;
import aemet.modelo.entidades.Estacion;
import aemet.modelo.entidades.Provincia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Actualiza la tabla Estacion en la BBDD
 * @author Miquel A. Fuster
 */
public class EstacionCRUD {
    public static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    /**
     * Obtiene una estación de la BBDD a partir de su nombre.
     * @param idEstacion Nombre de la estación.
     * @return Objeto Estacion que representa a la estación buscada. NULL si no existe.
     */
    public static Estacion obtener(String idEstacion) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Estacion.obtenerPorId")
                .setString("idEstacion", idEstacion);
        List<Estacion> lista = (ArrayList<Estacion>) query.list();
        session.close();
        
        if(lista.isEmpty())
            return null;
        
        return lista.get(0);
    }
    
    /**
     * Obtiene una lista de estaciones únicas de las cuales ya se han obtenido mediciones con anterioridad.
     * @return Lista de estaciones con mediciones.
     */
    public static Collection<Estacion> obtenerEstacionesConMediciones() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT DISTINCT(m.idEstacion) FROM Medicion m");
        Collection<Estacion> listaEstaciones = query.list();
        session.close();
        return listaEstaciones;
    }
    
    /**
     * Obtiene una lista de todas las estaciones pertenecientes a una provincia dada.
     * @param provincia Provincia de la que se van a obtener las estaciones.
     * @return Lista de estaciones de una provincia.
     */
    public static Collection<Estacion> obtenerLista(Provincia provincia) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Estacion.obtenerPorProvincia")
                .setEntity("provincia", provincia);
        Collection<Estacion> lista = (ArrayList<Estacion>) query.list();
        session.close();
        return lista;
    }
    
    /**
     * Guarda una estación en la BBDD.
     * @param estacion Estación a guardar.
     */
    public static void guardar(Estacion estacion) {
        // Si la estación ya existe en la BBDD no se debe guardar de nuevo
        if(obtener(estacion.getIdEstacion()) != null)
            return;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(estacion);
        session.getTransaction().commit();
        session.close();
    }
}
