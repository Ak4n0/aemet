package aemet.modelo.persistencia;

import aemet.modelo.HibernateUtil;
import aemet.modelo.entidades.Provincia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Actualiza la tabla Provincia en la BBDD
 * @author Miquel A. Fuster
 */
public class ProvinciaCRUD {
    public static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    /**
     * Obtiene una provincia guardada en la BBDD a partir de su nombre.
     * @param nombre Nombre de la provincia a obtener.
     * @return Devuelve un objeto Provincia de la provincia buscada o NULL si no se encontró.
     */
    public static Provincia obtener(String nombre) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Provincia.obtenerPorNombre")
                .setString("nombreProvincia", nombre);
        List<Provincia> lista = (ArrayList<Provincia>) query.list();
        session.close();
        
        if(lista.isEmpty())
            return null;
        
        return lista.get(0);
    }
    
    /**
     * Obtiene una lista con todas las provincias guardadas en la BBDD.
     * @return Devuelve una lista con las provincias guaradas.
     */
    public static Collection<Provincia> obtenerTodas() {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery("Provincia.obtenerTodas");
        Collection<Provincia> lista = (ArrayList<Provincia>) query.list();
        session.close();
        return lista;
    }
    
    /**
     * Guarda una provincia en la BBDD.
     * @param provincia La provincia a guardar.
     */
    public static void guardar(Provincia provincia) {
        // Si la provincia ya existe no se guarda
        if(obtener(provincia.getNombre()) != null)
            return;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(provincia);
        session.getTransaction().commit();
        session.close();
    }
}
