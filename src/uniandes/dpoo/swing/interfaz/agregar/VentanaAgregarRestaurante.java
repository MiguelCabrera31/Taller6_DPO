package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
    	this.ventanaPrincipal = principal;
        setTitle("Nuevo restaurante");
        setLayout(new BorderLayout(5, 5));

        // Centro: mapa
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Sur: detalles + botones
        panelDetalles = new PanelEditarRestaurante();
        panelBotones  = new PanelBotonesAgregar(this);

        JPanel contenedorSur = new JPanel(new BorderLayout());
        contenedorSur.add(panelDetalles, BorderLayout.CENTER);
        contenedorSur.add(panelBotones,  BorderLayout.SOUTH);
        add(contenedorSur, BorderLayout.SOUTH);

        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
    	String nombre = panelDetalles.getNombre();
        if (nombre.isBlank())
        {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.",
                                          "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.getVisitado();
        int[] coords      = panelMapa.getCoordenadas();

        if (coords[0] == 0 && coords[1] == 0)
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la ubicación en el mapa.",
                                          "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Delegar a la ventana principal y cerrar
        ventanaPrincipal.agregarRestaurante(nombre, calificacion, coords[0], coords[1], visitado);
        dispose();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
