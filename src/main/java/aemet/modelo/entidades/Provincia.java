package aemet.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Guarda el modelo de una provincia española
 * @author Miquel A. Fuster
 */
@Entity
@Table(name = "PROVINCIA")
@NamedQueries({
    @NamedQuery(name = "Provincia.obtenerTodas", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.obtenerPorNombre", query = "SELECT p FROM Provincia p WHERE p.nombre = :nombreProvincia")
})
public class Provincia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProvincia")
    private Integer idProvincia;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Estacion> listaEstaciones;
    
    public Provincia() {}
    
    public Provincia(Integer idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }
    
    public Provincia(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Collection<Estacion> getListaEstaciones() {
        return listaEstaciones;
    }
    
    public void setListaEstaciones(Collection<Estacion> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        return !((this.idProvincia == null && other.idProvincia != null)
                || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia)));
    }
    
}
