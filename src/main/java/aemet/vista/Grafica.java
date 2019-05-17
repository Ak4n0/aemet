package aemet.vista;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Miquel A. Fuster
 */
public class Grafica {
    private DefaultCategoryDataset datos;
    private String titulo;
    private String tituloEjeX;
    private String tituloEjeY;
    private ChartPanel panel;
    private JFreeChart grafica;
    final String FORMATO = "dd/MM/yy HH:mm";
    
    public Grafica() {
        datos = new DefaultCategoryDataset();
        titulo = "Visualización de medidas";
        tituloEjeX = "Fecha/hora";
        tituloEjeY = "Unidades";
        grafica = ChartFactory.createBarChart(titulo, tituloEjeX, tituloEjeY, null, PlotOrientation.VERTICAL, false, false, false);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloEjeY() {
        return tituloEjeY;
    }

    public void setTituloEjeY(String tituloEjeY) {
        this.tituloEjeY = tituloEjeY;
    }

    public String getTituloEjeX() {
        return tituloEjeX;
    }
    
    /**
     * Inserta un nuevo dato en la gráfica.
     * @param valor Valor a guardar.
     * @param fechaHora Momento en que se generó el dato a guardar.
     */
    public void insertarDato(Float valor, LocalDateTime fechaHora) {
        // Si el dato es null se convertirá en 0 para ser representado por la gráfica
        if(valor == null)
            valor = new Float(0);
        
        datos.addValue(valor, tituloEjeY, fechaHora.format(DateTimeFormatter.ofPattern(FORMATO)));
    }
    
    /**
     * Regresa una panel con la gráfica dibujada.
     * @return Devuelve un panel contieniendo la gráfica.
     */
    public JPanel getPanel() {
        grafica = ChartFactory.createBarChart(titulo, tituloEjeX, tituloEjeY, datos, PlotOrientation.VERTICAL, true, true, false);
        panel = new ChartPanel(grafica);
        return panel;
    }
    
}
