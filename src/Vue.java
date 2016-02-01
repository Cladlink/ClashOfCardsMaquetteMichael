import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Vue extends JFrame
{

    private ImageIcon[][] plateau;
    private ImageIcon[] cartesTeamA;
    private ImageIcon[] cartesTeamB;
    private String[] tabImageA =
            {
                "Alice_Bleu.jpg",
                "Artikodin_Bleu.jpg",
                "Boule1_Bleu.jpg",
                "Carla_Bleu.jpg",
                "Cendrillon_Bleu.jpg"
            };
    private String[] tabImageB =
            {
                "Epona_Rouge.jpg",
                "Flynet_Rouge.jpg",
                "Hades_Rouge.jpg",
                "Idefix_Rouge.jpg",
                "Pomme_Rouge.jpg"
            };
    private ArrayList<JLabel> poolCarteA;
    private ArrayList<JLabel> poolCarteB;
    private static final ImageIcon[] SCORESBLEUS =
            {
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_0.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_1.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_2.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_3.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_4.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_5.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_6.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_7.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_8.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_9.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Bleu_Mini_10.png"))
            };
    private static final ImageIcon[] SCORESROUGES =
            {
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_0.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_1.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_2.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_3.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_4.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_5.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_6.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_7.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_8.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_9.png")),
                    new ImageIcon(Vue.class.getResource("img/scores/Score_Rouge_Mini_10.png"))
            };
    private final static ImageIcon EMPTY = new ImageIcon(Vue.class.getResource("img/Empty.jpg"));

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
        int i;
        String adresse;
        // set cartes joueur A
        cartesTeamA = new ImageIcon[5];
        poolCarteA = new ArrayList<>();
        for(i=0; i<tabImageA.length; i++)
        {
            adresse = "img/cartes/";
            adresse += tabImageA[i];
            cartesTeamA[i] = new ImageIcon(Vue.class.getResource(adresse));
            cartesTeamA[i] = new ImageIcon(cartesTeamA[i].getImage().getScaledInstance(200, 200, BufferedImage.SCALE_SMOOTH));
            poolCarteA.add(i, new JLabel(cartesTeamA[i]));
        }

        // set cartes joueur B
        cartesTeamB = new ImageIcon[5];
        poolCarteB = new ArrayList<>();
        for(i=0;i<tabImageB.length; i++)
        {
            adresse = "img/cartes/";
            adresse += tabImageB[i];
            cartesTeamB[i] = new ImageIcon (Vue.class.getResource(adresse));
            cartesTeamB[i] = new ImageIcon(cartesTeamB[i].getImage().getScaledInstance(200, 200, BufferedImage.SCALE_SMOOTH));
            poolCarteB.add(i, new JLabel(cartesTeamB[i]));
        }
    }

    private void creerWidget()
    {
        JPanel pCartesTeamA = new JPanel();
        JLayeredPane lp = new JLayeredPane();
        pCartesTeamA.setLayout(new BoxLayout(pCartesTeamA, BoxLayout.Y_AXIS));
        for(int i=0; i<poolCarteA.size(); i++)
        {
            lp.add(poolCarteA.get(i), i);
            lp.add(Box.createRigidArea(new Dimension(0, -150)));
        }
        pCartesTeamA.add(lp);
        setContentPane(pCartesTeamA);
    }
}