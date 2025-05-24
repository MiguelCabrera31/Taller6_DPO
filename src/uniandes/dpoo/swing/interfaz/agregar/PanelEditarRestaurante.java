package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
    	// Disposición: 3 filas, 2 columnas (etiqueta + componente)
    	
        setLayout(new GridLayout(3, 2, 5, 5));

        // Nombre
        
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        add(txtNombre);

        // Calificación
        
        add(new JLabel("Calificación (1-5):"));
        cbbCalificacion = new JComboBox<>();
        for (int i = 1; i <= 5; i++)
        {
            cbbCalificacion.addItem(String.valueOf(i));
        }
        add(cbbCalificacion);

        // Visitado
        
        add(new JLabel("¿Visitado?:"));
        cbbVisitado = new JComboBox<>(new String[] { "No", "Sí" });
        add(cbbVisitado);

    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return true si fue visitado; false en caso contrario
     */
    public boolean getVisitado( )
    {
        return cbbVisitado.getSelectedIndex() == 1;
    }

    /**
     * Indica la calificación marcada en el selector
     * @return la calificación (1-5)
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return el nombre digitado para el restaurante
     */
    public String getNombre( )
    {
        return  txtNombre.getText().trim();
    }
}
