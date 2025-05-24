package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    /**
     * El comando utilizado para el botón que sirve para crear un nuevo restaurante
     */
    private static final String CREAR = "nuevo";

    /**
     * El comando utilizado para el botón que sirve para cerrar la ventana sin crear un restaurante
     */
    private static final String CERRAR = "ver";

    private JButton butNuevo;
    private JButton butCerrar;

    /**
     * La ventana en la que se encuentra este panel (ventana para agregar restaurante)
     */
    private VentanaAgregarRestaurante ventanaPrincipal;

    public PanelBotonesAgregar(VentanaAgregarRestaurante ventanaPrincipal)
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout(new FlowLayout());

        // Botón "Crear" (aceptar)
        butNuevo = new JButton("Crear");
        butNuevo.setActionCommand(CREAR);
        butNuevo.addActionListener(this);
        add(butNuevo);

        // Botón "Cancelar" (cerrar)
        butCerrar = new JButton("Cancelar");
        butCerrar.setActionCommand(CERRAR);
        butCerrar.addActionListener(this);
        add(butCerrar);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if (CREAR.equals(comando))
        {
            ventanaPrincipal.agregarRestaurante();
        }
        else if (CERRAR.equals(comando))
        {
            ventanaPrincipal.cerrarVentana();
        }
    }
}
