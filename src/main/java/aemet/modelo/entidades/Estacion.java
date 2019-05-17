package aemet.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa el modelo interno de la base de datos de una estación
 * @author Miquel A. Fuster
 */
@Entity
@Table(name = "ESTACION")
@NamedQueries({
    @NamedQuery(name = "Estacion.obtenerTodas", query = "SELECT e FROM Estacion e"),
    @NamedQuery(name = "Estacion.obtenerPorId", query = "SELECT e FROM Estacion e WHERE e.idEstacion = :idEstacion"),
    @NamedQuery(name = "Estacion.obtenerPorProvincia", query = "SELECT e FROM Estacion e WHERE e.provincia = :provincia")
})
public class Estacion implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "idEstacion")
    private String idEstacion;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "latitud")
    private String latitud;
    
    @Basic(optional = false)
    @Column(name = "longitud")
    private String longitud;
    
    @Basic(optional = false)
    @Column(name = "altitud")
    private Integer altitud;
    
    @OneToMany(mappedBy = "idEstacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Medicion> listaMediciones;
    
    public Estacion() {}
    
    public Estacion(String idEstacion, Provincia provincia, String nombre, String latitud, String longitud, Integer altitud) {
        this.idEstacion = idEstacion;
        this.provincia = provincia;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
    }

    public String getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(String idEstacion) {
        this.idEstacion = idEstacion;
    }
    
    public Provincia getProvincia() {
        return provincia;
    }

    public void setIdProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Integer getAltitud() {
        return altitud;
    }

    public void setAltitud(Integer altitud) {
        this.altitud = altitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Collection<Medicion> getListaMediciones() {
        return listaMediciones;
    }
    
    public void setListaMediciones(Collection<Medicion> listaMediciones) {
        this.listaMediciones = listaMediciones;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstacion != null ? idEstacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacion)) {
            return false;
        }
        Estacion other = (Estacion) object;
        return !((this.idEstacion == null && other.idEstacion != null)
                || (this.idEstacion != null && !this.idEstacion.equals(other.idEstacion)));
    }
    
}
