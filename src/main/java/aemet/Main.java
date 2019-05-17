package aemet;

import aemet.vista.VentanaDeCarga;
import aemet.vista.VentanaPrincipal;

/**
 * Ejecuta el programa para ser gobernado por la terminal
 * @author Miquel A. Fuster
 */
public class Main {
    
    public static void main(String[] args) {
    
        VentanaDeCarga.inicializar();
        VentanaPrincipal.inicializar();
    }
}
