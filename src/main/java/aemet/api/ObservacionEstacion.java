package aemet.api;

/**
 *
 * @author david
 * 
 * AEMET MetaData
 * 
 * {
	"unidad_generadora": "Servicio de Observación",
	"periodicidad": "continuamente",
	"formato": "application/json",
	"copyright": "© AEMET. Autorizado el uso de la información y su reproducción citando a AEMET como autora de la misma.",
	"notaLegal": "http://www.aemet.es/es/nota_legal",
	"campos": [{
			"id": "idema",
			"descripcion": "Indicativo climatógico de la estación meteorológia automática",
			"tipo_datos": "string",
			"requerido": true
		},
		{
			"id": "lon",
			"descripcion": "Longitud de la estación meteorológica (grados)",
			"tipo_datos": "float",
			"requerido": true
		},
		{
			"id": "lat",
			"descripcion": "Latitud de la estación meteorológica (grados)",
			"tipo_datos": "float",
			"requerido": true
		},
		{
			"id": "alt",
			"descripcion": "Altitud de la estación en metros",
			"tipo_datos": "float",
			"requerido": true
		},
		{
			"id": "ubi",
			"descripcion": "Ubicación de la estación. Nombre de la estación",
			"tipo_datos": "string",
			"requerido": true
		},
		{
			"id": "fint",
			"descripcion": "Fecha hora final del período de observación, se trata de datos del periodo de la hora anterior a la indicada por este campo (hora UTC)",
			"tipo_datos": "string (AAAA-MM-DDTHH:MM:SS)",
			"requerido": false
		},
		{
			"id": "prec",
			"descripcion": "Precipitación acumulada, medida por el pluviómetro, durante los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (mm, equivalente a l/m2)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "pacutp",
			"descripcion": "Precipitación acumulada, medida por el disdrómetro, durante los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (mm, equivalente a l/m2)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "pliqtp",
			"descripcion": "Precipitación líquida acumulada durante los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (mm, equivalente a l/m2)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "psolt",
			"descripcion": "Precipitación sólida acumulada durante los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (mm, equivalente a l/m2)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "vmax",
			"descripcion": "Velocidad máxima del viento, valor máximo del viento mantenido 3 segundos y registrado en los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (m/s)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "vv",
			"descripcion": "Velocidad media del viento, media escalar de las muestras adquiridas cada 0,25 ó 1 segundo en el período de 10 minutos anterior al indicado por 'fint' (m/s)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "vmaxu",
			"descripcion": "Velocidad máxima del viento (sensor ultrasónico), valor máximo del viento mantenido 3 segundos y registrado en los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (m/s)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "vvu",
			"descripcion": "Velocidad media del viento (sensor ultrasónico), media escalar en el periódo de 10 minutos anterior al indicado por 'fint' de las muestras adquiridas cada 0,25 ó 1 segundo (m/s)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "dv",
			"descripcion": "Dirección media del viento, en el período de 10 minutos anteriores a la fecha indicada por 'fint' (grados)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "dvu",
			"descripcion": "Dirección media del viento (sensor ultrasónico), en el período de 10 minutos anteriores a la fecha indicada por 'fint' (grados)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "dmax",
			"descripcion": "Dirección del viento máximo registrado en los 60 minutos anteriores a la hora indicada por 'fint' (grados)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "dmaxu",
			"descripcion": "Dirección del viento máximo registrado en los 60 minutos anteriores a la hora indicada por 'fint' por el sensor ultrasónico (grados)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "stdvv",
			"descripcion": "Desviación estándar de las muestras adquiridas de velocidad del viento durante los 10 minutos anteriores a la fecha dada por 'fint' (m/s)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "stddv",
			"descripcion": "Desviación estándar de las muestras adquiridas de la dirección del viento durante los 10 minutos anteriores a la fecha dada por 'fint' (grados)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "stdvvu",
			"descripcion": "Desviación estándar de las muestras adquiridas de velocidad del viento durante los 10 minutos anteriores a la fecha dada por 'fint' obtenido del sensor ultrasónico de viento instalado junto al convencional (m/s)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "stddvu",
			"descripcion": "Desviación estándar de las muestras adquiridas de la dirección del viento durante los 10 minutos anteriores a la fecha dada por 'fint' obtenido del sensor ultrasónico de viento instalado junto al convencional (grados)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "hr",
			"descripcion": "Humedad relativa instantánea del aire correspondiente a la fecha dada por 'fint' (%)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "inso",
			"descripcion": "Duración de la insolación durante los 60 minutos anteriores a la hora indicada por el período de observación 'fint' (horas)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "pres",
			"descripcion": "Presión instantánea al nivel en el que se encuentra instalado el barómetro y correspondiente a la fecha dada por 'fint' (hPa)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "pres_nmar",
			"descripcion": "Valor de la presión reducido al nivel del mar para aquellas estaciones cuya altitud es igual o menor a 750 metros y correspondiente a la fecha indicada por 'fint' (hPa)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "ts",
			"descripcion": "Temperatura suelo, temperatura instantánea junto al suelo y correspondiente a los 10 minutos anteriores a la fecha dada por 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "tss20cm",
			"descripcion": "Temperatura subsuelo 20 cm, temperatura del subsuelo a una profundidad de 20 cm y correspondiente a los 10 minutos anteriores a la fecha dada por 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "tss5cm",
			"descripcion": "Temperatura subsuelo 5 cm, temperatura del subsuelo a una profundidad de 5 cm y correspondiente a los 10 minutos anteriores a la fecha dada por 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "ta",
			"descripcion": "Temperatura instantánea del aire correspondiente a la fecha dada por 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "tpr",
			"descripcion": "Temperatura del punto de rocío calculado correspondiente a la fecha 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "tamin",
			"descripcion": "Temperatura mínima del aire, valor mínimo de los 60 valores instantáneos de 'ta' medidos en el período de 60 minutos anteriores a la hora indicada por el período de observación 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "tamax",
			"descripcion": "Temperatura máxima del aire, valor máximo de los 60 valores instantáneos de 'ta' medidos en el período de 60 minutos anteriores a la hora indicada por el período de observación 'fint' (grados Celsius)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "vis",
			"descripcion": "Visibilidad, promedio de la medida de la visibilidad correspondiente a los 10 minutos anteriores a la fecha dada por 'fint' (Km)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "geo700",
			"descripcion": "Altura del nivel de la superficie de referencia barométrica de 700 hPa calculado para las estaciones con altitud mayor de 2300 metros y correspondiente a la fecha indicada por 'fint' (m geopotenciales)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "geo850",
			"descripcion": "Altura del nivel de la superficie de referencia barométrica de 850 hPa calculado para las estaciones con altitud mayor de 1000 metros y menor o igual a 2300 metros y correspondiente a la fecha indicada por 'fint' (m geopotenciales)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "geo925",
			"descripcion": "Altura del nivel de la superficie barométrica de 925 hPa calculado para las estaciones con altitud mayor de 750 metros y y menor o igual a 1000 metros correspondiente a la fecha indicada por 'fint' (m geopotenciales)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "rviento",
			"descripcion": "Recorrido del viento durante los 60 minutos anteriores a la fecha indicada por 'fint' (Hm)",
			"tipo_datos": "float",
			"requerido": false
		},
		{
			"id": "nieve",
			"descripcion": "Espesor de la capa de nieve medid en los 10 minutos anteriores a la a la fecha indicada por 'fint' (cm)",
			"tipo_datos": "float",
			"requerido": false
		}
	]
}
 */
public class ObservacionEstacion {
    private String idema;
    private Float lon;
    private Float lat;
    private Float alt;
    private String ubi;
    private String fint;
    private Float prec;
    private Float pacutp;
    private Float pliqtp;
    private Float psolt;
    private Float vmax;
    private Float vv;
    private Float vmaxu;
    private Float vvu;
    private Float dv;
    private Float dvu;
    private Float dmax;
    private Float dmaxu;
    private Float stdvv;
    private Float stddv;
    private Float stdvvu;
    private Float stddvu;
    private Float hr;
    private Float inso;
    private Float pres;
    private Float pres_nmar;
    private Float ts;
    private Float tss20cm;
    private Float tss5cm;
    private Float ta;
    private Float tpr;
    private Float tamin;
    private Float tamax;
    private Float vis;
    private Float geo700;
    private Float geo850;
    private Float geo925;
    private Float rviento;
    private Float nieve;

    public ObservacionEstacion() {
    }

    @Override
    public String toString() {
        return "ObservacionEstacion{" + "idema=" + idema + ", lon=" + lon + ", lat=" + lat + ", alt=" + alt + ", ubi=" + ubi + ", fint=" + fint + ", prec=" + prec + ", pacutp=" + pacutp + ", pliqtp=" + pliqtp + ", psolt=" + psolt + ", vmax=" + vmax + ", vv=" + vv + ", vmaxu=" + vmaxu + ", vvu=" + vvu + ", dv=" + dv + ", dvu=" + dvu + ", dmax=" + dmax + ", dmaxu=" + dmaxu + ", stdvv=" + stdvv + ", stddv=" + stddv + ", stdvvu=" + stdvvu + ", stddvu=" + stddvu + ", hr=" + hr + ", inso=" + inso + ", pres=" + pres + ", pres_nmar=" + pres_nmar + ", ts=" + ts + ", tss20cm=" + tss20cm + ", tss5cm=" + tss5cm + ", ta=" + ta + ", tpr=" + tpr + ", tamin=" + tamin + ", tamax=" + tamax + ", vis=" + vis + ", geo700=" + geo700 + ", geo850=" + geo850 + ", geo925=" + geo925 + ", rviento=" + rviento + ", nieve=" + nieve + '}';
    }

    public String getIdema() {
        return idema;
    }

    public void setIdema(String idema) {
        this.idema = idema;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getAlt() {
        return alt;
    }

    public void setAlt(Float alt) {
        this.alt = alt;
    }

    public String getUbi() {
        return ubi;
    }

    public void setUbi(String ubi) {
        this.ubi = ubi;
    }

    public String getFint() {
        return fint;
    }

    public void setFint(String fint) {
        this.fint = fint;
    }

    public Float getPrec() {
        return prec;
    }

    public void setPrec(Float prec) {
        this.prec = prec;
    }

    public Float getPacutp() {
        return pacutp;
    }

    public void setPacutp(Float pacutp) {
        this.pacutp = pacutp;
    }

    public Float getPliqtp() {
        return pliqtp;
    }

    public void setPliqtp(Float pliqtp) {
        this.pliqtp = pliqtp;
    }

    public Float getPsolt() {
        return psolt;
    }

    public void setPsolt(Float psolt) {
        this.psolt = psolt;
    }

    public Float getVmax() {
        return vmax;
    }

    public void setVmax(Float vmax) {
        this.vmax = vmax;
    }

    public Float getVv() {
        return vv;
    }

    public void setVv(Float vv) {
        this.vv = vv;
    }

    public Float getVmaxu() {
        return vmaxu;
    }

    public void setVmaxu(Float vmaxu) {
        this.vmaxu = vmaxu;
    }

    public Float getVvu() {
        return vvu;
    }

    public void setVvu(Float vvu) {
        this.vvu = vvu;
    }

    public Float getDv() {
        return dv;
    }

    public void setDv(Float dv) {
        this.dv = dv;
    }

    public Float getDvu() {
        return dvu;
    }

    public void setDvu(Float dvu) {
        this.dvu = dvu;
    }

    public Float getDmax() {
        return dmax;
    }

    public void setDmax(Float dmax) {
        this.dmax = dmax;
    }

    public Float getDmaxu() {
        return dmaxu;
    }

    public void setDmaxu(Float dmaxu) {
        this.dmaxu = dmaxu;
    }

    public Float getStdvv() {
        return stdvv;
    }

    public void setStdvv(Float stdvv) {
        this.stdvv = stdvv;
    }

    public Float getStddv() {
        return stddv;
    }

    public void setStddv(Float stddv) {
        this.stddv = stddv;
    }

    public Float getStdvvu() {
        return stdvvu;
    }

    public void setStdvvu(Float stdvvu) {
        this.stdvvu = stdvvu;
    }

    public Float getStddvu() {
        return stddvu;
    }

    public void setStddvu(Float stddvu) {
        this.stddvu = stddvu;
    }

    public Float getHr() {
        return hr;
    }

    public void setHr(Float hr) {
        this.hr = hr;
    }

    public Float getInso() {
        return inso;
    }

    public void setInso(Float inso) {
        this.inso = inso;
    }

    public Float getPres() {
        return pres;
    }

    public void setPres(Float pres) {
        this.pres = pres;
    }

    public Float getPres_nmar() {
        return pres_nmar;
    }

    public void setPres_nmar(Float pres_nmar) {
        this.pres_nmar = pres_nmar;
    }

    public Float getTs() {
        return ts;
    }

    public void setTs(Float ts) {
        this.ts = ts;
    }

    public Float getTss20cm() {
        return tss20cm;
    }

    public void setTss20cm(Float tss20cm) {
        this.tss20cm = tss20cm;
    }

    public Float getTss5cm() {
        return tss5cm;
    }

    public void setTss5cm(Float tss5cm) {
        this.tss5cm = tss5cm;
    }

    public Float getTa() {
        return ta;
    }

    public void setTa(Float ta) {
        this.ta = ta;
    }

    public Float getTpr() {
        return tpr;
    }

    public void setTpr(Float tpr) {
        this.tpr = tpr;
    }

    public Float getTamin() {
        return tamin;
    }

    public void setTamin(Float tamin) {
        this.tamin = tamin;
    }

    public Float getTamax() {
        return tamax;
    }

    public void setTamax(Float tamax) {
        this.tamax = tamax;
    }

    public Float getVis() {
        return vis;
    }

    public void setVis(Float vis) {
        this.vis = vis;
    }

    public Float getGeo700() {
        return geo700;
    }

    public void setGeo700(Float geo700) {
        this.geo700 = geo700;
    }

    public Float getGeo850() {
        return geo850;
    }

    public void setGeo850(Float geo850) {
        this.geo850 = geo850;
    }

    public Float getGeo925() {
        return geo925;
    }

    public void setGeo925(Float geo925) {
        this.geo925 = geo925;
    }

    public Float getRviento() {
        return rviento;
    }

    public void setRviento(Float rviento) {
        this.rviento = rviento;
    }

    public Float getNieve() {
        return nieve;
    }

    public void setNieve(Float nieve) {
        this.nieve = nieve;
    }
    
}
