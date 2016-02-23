import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class Vue extends JFrame
{
    private int i, j;
    public JLabel[][] getPlateau() {
        return plateau;
    }
    private JLabel[][] plateau;
    private ArrayList<JLabel> poolCarteA;
    private ArrayList<JLabel> poolCarteB;
    public ArrayList<JLabel> getPoolCarteA() {
        return poolCarteA;
    }
    public ArrayList<JLabel> getPoolCarteB() {
        return poolCarteB;
    }

    private Carte[] carteJ1 =
        {
            new Carte(3, 6, 1, 3, "img/cartes/Boule1_Bleu.jpg", "img/cartes/Boule1_Rouge.jpg"),
            new Carte(3, 6, 4, 3, "img/cartes/Carla_Bleu.jpg", "img/cartes/Carla_Rouge.jpg"),
            new Carte(4, 10, 7, 2, "img/cartes/Cendrillon_Bleu.jpg", "img/cartes/Cendrillon_Rouge.jpg"),
            new Carte(9, 2, 7, 5, "img/cartes/Alice_Bleu.jpg", "img/cartes/Alice_Rouge.jpg"),
            new Carte(10, 3, 9, 3, "img/cartes/Artikodin_Bleu.jpg", "img/cartes/Artikodin_Rouge.jpg"),
        };

    private Carte[] carteJ2 =
        {
            new Carte(5, 6, 2, 9, "img/cartes/Epona_Bleu.jpg", "img/cartes/Epona_Rouge.jpg"),
            new Carte(4, 1, 2, 8, "img/cartes/Flynet_Bleu.jpg", "img/cartes/Flynet_Rouge.jpg"),
            new Carte(8, 9, 2, 10, "img/cartes/Hades_Bleu.jpg", "img/cartes/Hades_Rouge.jpg"),
            new Carte(8, 3, 9, 7, "img/cartes/Idefix_Bleu.jpg", "img/cartes/Idefix_Rouge.jpg"),
            new Carte(3, 2, 1, 1, "img/cartes/Pomme_Bleu.jpg", "img/cartes/Pomme_Rouge.jpg")

        };
    public Carte[] getCarteJ1() {
        return carteJ1;
    }
    public Carte[] getCarteJ2() {
        return carteJ2;
    }
    private static final JLabel[] SCORESBLEUS =
        {
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_0.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_1.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_2.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_3.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_4.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_5.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_6.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_7.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_8.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_9.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_10.png")))
        };
    private JLabel scoreBleu = SCORESBLEUS[5];
    private static final JLabel[] SCORESROUGES =
        {
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_0.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_1.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_2.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_3.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_4.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_5.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_6.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_7.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_8.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_9.png"))),
            new JLabel(new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_10.png")))
        };

    public void setScoreBleu(JLabel scoreBleu) {
        this.scoreBleu = scoreBleu;
    }
    public void setScoreRouge(JLabel scoreRouge) {
        this.scoreRouge = scoreRouge;
    }

    public static JLabel[] getSCORESBLEUS() {
        return SCORESBLEUS;
    }
    public static JLabel[] getSCORESROUGES() {
        return SCORESROUGES;
    }

    private JLabel scoreRouge = SCORESROUGES[5];
    private final static ImageIcon EMPTY = new ImageIcon(Vue.class.getResource("img/Empty.jpg"));

    public static ImageIcon getEMPTY() {
        return EMPTY;
    }

    private JPanel pano;
    private JPanel pPlateau;
    private JPanel pCartesTeamA;
    private JPanel pCartesTeamB;
    private JPanel ppCartesTeamA;
    private JPanel ppCartesTeamB;
    private JPanel pScoreBleu;
    private JPanel pScoreRouge;
    private JPanel ppPlateau;
    public Vue (Model model)
    {
        initAttribut();
        creerWidget();

        setSize(1100,700);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initAttribut()
    {
        // set cartes joueur A
        poolCarteA = new ArrayList<>();
        for(i=0; i<carteJ1.length; i++)
            poolCarteA.add(i, new JLabel(carteJ1[i].getImageBleue()));
        // set cartes joueur B
        poolCarteB = new ArrayList<>();
        for(i=0;i<carteJ2.length; i++)
            poolCarteB.add(i, new JLabel(carteJ2[i].getImageRouge()));
        // plateau
        plateau = new JLabel[3][3];
        for(i = 0; i<plateau.length; i++)
            for (j = 0; j < plateau[i].length; j++)
                plateau[i][j] = new JLabel(EMPTY);
        // Scores
    }
    public void creerWidget()
    {
        pano = new JPanel(new BorderLayout());
        // Construction du plateau
        pPlateau = new JPanel(new GridLayout(3,3));
        ppPlateau = new JPanel();
        for (JLabel[] eachPlateau : plateau)
            for (JLabel eachEachPlateau : eachPlateau)
                pPlateau.add(eachEachPlateau);
        // scores
        pScoreBleu = new JPanel();
        pScoreBleu.add(scoreBleu);
        pScoreRouge = new JPanel();
        pScoreRouge.add(scoreRouge);
        // joueur A
        ppCartesTeamA = new JPanel(new BorderLayout());
        pCartesTeamA = new JPanel(new BorderLayout());
        pCartesTeamA.setLayout(new BoxLayout(pCartesTeamA, BoxLayout.Y_AXIS));
        pCartesTeamA.add(Box.createRigidArea(new Dimension(0, 250)));
        for (JLabel aPoolCarteA : poolCarteA)
        {
            pCartesTeamA.add(aPoolCarteA);
            pCartesTeamA.add(Box.createRigidArea(new Dimension(10, -250)));
        }
        // joueur B
        ppCartesTeamB = new JPanel(new BorderLayout());
        pCartesTeamB = new JPanel(new BorderLayout());
        pCartesTeamB.setLayout(new BoxLayout(pCartesTeamB, BoxLayout.Y_AXIS));
        pCartesTeamB.add(Box.createRigidArea(new Dimension(0, 250)));
        for (JLabel aPoolCarteB : poolCarteB)
        {
            pCartesTeamB.add(aPoolCarteB);
            pCartesTeamB.add(Box.createRigidArea(new Dimension(10, -250)));
        }
        // ajout de tous les panels au panel pricipal
        ppCartesTeamA.add(pScoreBleu, BorderLayout.NORTH);
        ppCartesTeamA.add(pCartesTeamA, BorderLayout.CENTER);
        pano.add(ppCartesTeamA, BorderLayout.WEST);
        ppCartesTeamB.add(pScoreRouge, BorderLayout.NORTH);
        ppCartesTeamB.add(pCartesTeamB,BorderLayout.CENTER);
        pano.add(ppCartesTeamB, BorderLayout.EAST);
        ppPlateau.add(pPlateau, BorderLayout.CENTER);
        pano.add(ppPlateau);
        setContentPane(pano);
    }
    public void setMouseButton(MouseListener e)
    {
        for(i = 0; i<poolCarteA.size(); i++)
            poolCarteA.get(i).addMouseListener(e);
        for(i = 0; i<poolCarteB.size(); i++)
            poolCarteB.get(i).addMouseListener(e);
    }
    public void setPlateauButton(MouseListener listener)
    {
        for (JLabel[] aPlateau : plateau)
            for (JLabel anAPlateau : aPlateau)
                if (anAPlateau.getIcon() == EMPTY)
                    anAPlateau.addMouseListener(listener);
    }
}