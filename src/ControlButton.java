import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class ControlButton extends Control implements MouseListener
{
    private JLabel event;
    private ArrayList<JLabel> poolCarteA = vue.getPoolCarteA();
    private ArrayList<JLabel> poolCarteB = vue.getPoolCarteB();

    public ControlButton(Model model, Vue vue)
    {
        super(model, vue);
        vue.setMouseButton(this);
    }
     @Override
    public void mouseClicked(MouseEvent e)
    {
        event = (JLabel) e.getSource();
        if (model.getJoueur() && poolCarteA.contains(event))
        {
            model.setCarteMemoire(poolCarteA.get(poolCarteA.indexOf(event)));
            model.setPlateauPret(true);
        }
        else if (!model.getJoueur() && poolCarteB.contains(event))
        {
            model.setCarteMemoire(poolCarteB.get(poolCarteB.indexOf(event)));
            model.setPlateauPret(true);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        event = (JLabel) e.getSource();
        event.setOpaque(true);
        event.updateUI();
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        event = (JLabel) e.getSource();
        event.setOpaque(false);
        event.updateUI();
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
}
