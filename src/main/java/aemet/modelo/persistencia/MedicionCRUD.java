package aemet.modelo.persistencia;

import aemet.modelo.HibernateUtil;
import aemet.modelo.entidades.Estacion;
import aemet.modelo.entidades.Medicion;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Actualiza la tabla Medicion en la BBDD
 * @author Miquel A. Fuster
 */
public class MedicionCRUD {
    public static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    /**
     * Obtiene una medición realizada por una estación dada a una hora determinada.
     * @param estacion Estación que realiza la medición.
     * @param fechaHora Momento en que la medición se realiza.
     * @return Devuelve un objeto Medicion con todos los datos de ésta. Si no existe devuelve NULL.
     */
    public static Medicion obtenerMedicion(Estacion estacion, Timestamp fechaHora) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Medicion.obtener")
                .setEntity("idEstacion", estacion)
                .setTimestamp("fechaHora", fechaHora);
        List<Medicion> lista = (ArrayList<Medicion>) query.list();
        session.close();
        
        if(lista.isEmpty())
            return null;
        
        return lista.get(0);
    }
    
    /**
     * Obtiene una lista con todas las mediciones realizadas por una estación dada.
     * @param estacion La estación que realiza las mediciones.
     * @return Devuelve una lista con las mediciones.
     */
    public static Collection<Medicion> obtenerListaDeEstacion(Estacion estacion) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Medicion.obtenerDeEstacion")
                .setEntity("idEstacion", estacion);
        Collection<Medicion> lista = (ArrayList<Medicion>) query.list();
        session.close();
        return lista;
    }
    
    /**
     * Guarda una medición en la BBDD.
     * @param medicion Medición a guardar.
     */
    public static void guardar(Medicion medicion) {
        // Si la medición ya existe no se guarda
        if(obtenerMedicion(medicion.getIdEstacion(), medicion.getFechaHora()) != null)
            return;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(medicion);
        session.getTransaction().commit();
        session.close();
    }
}
