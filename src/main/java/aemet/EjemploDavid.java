package aemet;

import aemet.api.APIUtils;
import aemet.api.Estacion;
import aemet.api.ObservacionEstacion;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class EjemploDavid {

    public static void main(String[] args) throws Exception {

        ArrayList<Estacion> stations = APIUtils.getStations();
        for (Estacion e : stations) {
            System.out.println(e.toString());
            if ("ILLES BALEARS".equals(e.getProvincia())) {
                try {
                    ArrayList<ObservacionEstacion> observaciones = APIUtils.getObservacionEstacion(e.getIndicativo());
                    for (ObservacionEstacion o : observaciones) {
                        System.out.println("\t" + o.toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
