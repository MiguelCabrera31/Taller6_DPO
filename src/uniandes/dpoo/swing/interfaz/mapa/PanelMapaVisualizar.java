package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
    	setLayout(new BorderLayout());

        labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        add(labMapa, BorderLayout.CENTER);
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        
        if (restaurantes == null || restaurantes.isEmpty())
        {
            return;
        }
        
        Graphics2D g2d = ( Graphics2D ) g;

        g2d.setFont(new Font("SansSerif", Font.PLAIN, 11));

        // Coordenadas del label respecto al panel (por si tuviera margen)
        int offsetX = labMapa.getX();
        int offsetY = labMapa.getY();

        for (Restaurante r : restaurantes)
        {
            // Puntos: verde = visitado, gris = pendiente
            g2d.setColor(r.isVisitado() ? Color.GREEN : Color.GRAY);

            int cx = offsetX + r.getX();
            int cy = offsetY + r.getY();

            g2d.fillOval(cx - 3, cy - 3, 7, 7);              // círculo
            g2d.setColor(Color.BLACK);                       // texto en negro
            g2d.drawString(r.getNombre(), cx + 6, cy - 4);   // nombre a la derecha-arriba
        }
        
    }

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}
