import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControlPlateau extends Control implements MouseListener
{

    private boolean endgame = true ;
    private final JLabel[] SCORESBLEUS = vue.getSCORESBLEUS();
    private final JLabel[] SCORESROUGES = vue.getSCORESROUGES();
    private JLabel[][] plateau = vue.getPlateau();
    private int i, j;
    ArrayList<JLabel> poolCarteA = vue.getPoolCarteA();
    ArrayList<JLabel> poolCarteB = vue.getPoolCarteB();

    public ControlPlateau(Model model, Vue vue)
    {
        super(model, vue);
        vue.setPlateauButton(this);
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        for(i=0; i<plateau.length; i++)
        {
            for(j=0; j<plateau[i].length; j++)
            {
                if (e.getSource()==plateau[i][j] && model.getPlateauPret())
                {
                    plateau[i][j]=new JLabel(model.getCarteMemoire().getIcon());
                    if (model.getJoueur())
                        poolCarteA.remove(model.getCarteMemoire());
                    else
                        poolCarteB.remove(model.getCarteMemoire());
                    model.normal(vue.getCarteJ1(), vue.getCarteJ2(), plateau, i, j);


                }
            }
        }

        for(i=0; i<plateau.length; i++)
        {
            for(j=0; j<plateau[i].length; j++)
            {
                if (plateau[i][j].getIcon() == vue.getEMPTY())
                    endgame = false;
            }
        }

        finTour();
        endgame = true;
    }
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
public void finTour()
{
    if (endgame && model.getiBleu() > model.getiRouge())
        System.out.println("les bleus gagnent !");
    else if (endgame && model.getiBleu() < model.getiRouge())
        System.out.println("Les rouges gagnent");
    else if (endgame && model.getiBleu() == model.getiRouge())
        System.out.println("egalité");

    model.setPlateauPret(false);
    model.setJoueur(!model.getJoueur());
    vue.setScoreBleu(SCORESBLEUS[model.getiBleu()]);
    vue.setScoreRouge(SCORESROUGES[model.getiRouge()]);
    vue.repaint();
    vue.creerWidget();
    vue.setVisible(true);
}
}