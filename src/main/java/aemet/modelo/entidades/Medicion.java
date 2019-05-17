package aemet.modelo.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Representa el modelo interno de la base de datos de una medición de una estación
 * @author Miquel A. Fuster
 */

@Entity
@Table(name = "MEDICION")
@NamedQueries({
    @NamedQuery(name = "Medicion.obtener", query = "SELECT m FROM Medicion m WHERE m.idEstacion = :idEstacion AND m.fechaHora = :fechaHora"),
    @NamedQuery(name = "Medicion.obtenerDeEstacion", query = "SELECT m FROM Medicion m WHERE m.idEstacion = :idEstacion")
})
public class Medicion implements Serializable {
    
    @Id
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "idEstacion")
    private Estacion idEstacion;
    
    @Id
    @Basic(optional = false)
    @Column(name = "fechaHora")
    private Timestamp fechaHora;
    
    @Basic(optional = true)
    @Column(name = "vientoVelocidadMaxima")
    private Float vientoVelocidadMaxima;
    
    @Basic(optional = true)
    @Column(name = "vientoVelocidadMedia")
    private Float vientoVelocidadMedia;
    
    @Basic(optional = true)
    @Column(name = "vientoDireccion")
    private Float vientoDireccion;
    
    @Basic(optional = true)
    @Column(name = "precipitacion")
    private Float precipitacion;
    
    @Basic(optional = true)
    @Column(name = "humedadRelativa")
    private Float humedadRelativa;
    
    @Basic(optional = true)
    @Column(name = "presionBarometrica")
    private Float presionBarometrica;
    
    @Basic(optional = true)
    @Column(name = "insolacion")
    private Float insolacion;
    
    @Basic(optional = true)
    @Column(name = "temperaturaMaxima")
    private Float temperaturaMaxima;
    
    @Basic(optional = true)
    @Column(name = "temperaturaMedia")
    private Float temperaturaMedia;
    
    @Basic(optional = true)
    @Column(name = "temperaturaMinima")
    private Float temperaturaMinima;
    
    @Basic(optional = true)
    @Column(name = "nieveGrosor")
    private Float nieveGrosor;
    
    public Medicion() {}
    
    private Medicion(Estacion idEstacion, Float vientoVelMax, Float vientoVelMed, 
                    Float vientoDireccion, Float precipitacion, Float humedadRelativa, Float presionBarometrica,
                    Float insolacion, Float temperaturaMax, Float temperaturaMed, Float temperaturaMin,
                    Float nieveGrosor) {
        this.idEstacion = idEstacion;
        this.vientoVelocidadMaxima = vientoVelMax;
        this.vientoVelocidadMedia = vientoVelMed;
        this.vientoDireccion = vientoDireccion;
        this.precipitacion = precipitacion;
        this.humedadRelativa = humedadRelativa;
        this.presionBarometrica = presionBarometrica;
        this.insolacion = insolacion;
        this.temperaturaMaxima = temperaturaMax;
        this.temperaturaMedia = temperaturaMed;
        this.temperaturaMinima = temperaturaMin;
        this.nieveGrosor = nieveGrosor;
    }
    
    public Medicion(Estacion idEstacion, Timestamp fecha, Float vientoVelMax, Float vientoVelMed, 
                    Float vientoDireccion, Float precipitacion, Float humedadRelativa, Float presionBarometrica,
                    Float insolacion, Float temperaturaMax, Float temperaturaMed, Float temperaturaMin,
                    Float nieveGrosor) {
        this(idEstacion, vientoVelMax, vientoVelMed, vientoDireccion, precipitacion, humedadRelativa, presionBarometrica,
                insolacion, temperaturaMax, temperaturaMed, temperaturaMin, nieveGrosor);
        this.fechaHora = fecha;
    }
    
    public Medicion(Estacion idEstacion, String fecha, Float vientoVelMax, Float vientoVelMed, 
                    Float vientoDireccion, Float precipitacion, Float humedadRelativa, Float presionBarometrica,
                    Float insolacion, Float temperaturaMax, Float temperaturaMed, Float temperaturaMin,
                    Float nieveGrosor) throws ParseException {
        this(idEstacion, vientoVelMax, vientoVelMed, vientoDireccion, precipitacion, humedadRelativa, presionBarometrica,
                insolacion, temperaturaMax, temperaturaMed, temperaturaMin, nieveGrosor);
        Timestamp ts = new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fecha).getTime());
        this.fechaHora = ts;
    }
    
    

    public Estacion getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(Estacion idEstacion) {
        this.idEstacion = idEstacion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public LocalDate getLocalDate() {
        return fechaHora.toLocalDateTime().toLocalDate();
    }
    
    public LocalDateTime getLocalDateTime() {
        return fechaHora.toLocalDateTime();
    }

    public Float getVientoVelocidadMaxima() {
        return vientoVelocidadMaxima;
    }

    public void setVientoVelocidadMaxima(Float vientoVelocidadMaxima) {
        this.vientoVelocidadMaxima = vientoVelocidadMaxima;
    }

    public Float getVientoVelocidadMedia() {
        return vientoVelocidadMedia;
    }

    public void setVientoVelocidadMedia(Float vientoVelocidadMedia) {
        this.vientoVelocidadMedia = vientoVelocidadMedia;
    }

    public Float getVientoDireccion() {
        return vientoDireccion;
    }

    public void setVientoDireccion(Float vientoDireccion) {
        this.vientoDireccion = vientoDireccion;
    }

    public Float getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(Float precipitacion) {
        this.precipitacion = precipitacion;
    }

    public Float getHumedadRelativa() {
        return humedadRelativa;
    }

    public void setHumedadRelativa(Float humedadRelativa) {
        this.humedadRelativa = humedadRelativa;
    }

    public Float getPresionBarometrica() {
        return presionBarometrica;
    }

    public void setPresionBarometrica(Float presionBarometrica) {
        this.presionBarometrica = presionBarometrica;
    }

    public Float getInsolacion() {
        return insolacion;
    }

    public void setInsolacion(Float insolacion) {
        this.insolacion = insolacion;
    }

    public Float getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Float temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Float getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Float temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public Float getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Float temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Float getNieveGrosor() {
        return nieveGrosor;
    }

    public void setNieveGrosor(Float nieveGrosor) {
        this.nieveGrosor = nieveGrosor;
    }
    
    @Override
    public int hashCode() {
        return (idEstacion != null && fechaHora != null?
                (String.valueOf(idEstacion.getIdEstacion()) + String.valueOf(fechaHora.getTime())).hashCode()
                : 0);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicion)) {
            return false;
        }
        Medicion other = (Medicion) object;
        return !((this.idEstacion == null && other.idEstacion != null)
                || (this.idEstacion != null && !this.idEstacion.equals(other.idEstacion))
                || (this.fechaHora == null && other.idEstacion != null)
                || (this.fechaHora != null && !this.fechaHora.equals(other.fechaHora)));
    }
}