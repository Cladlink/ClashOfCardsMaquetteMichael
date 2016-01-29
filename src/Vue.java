import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

/**
 * Created by cladlink on 21/01/16.
 */
public class Vue extends JFrame
{
    private JLabel a;
    private ImageIcon[][] plateau;
    private ArrayList<ImageIcon> cartesTeamA;
    private ArrayList<ImageIcon> cartesTeamB;
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
   /* private static final ImageIcon[] SCORESBLEUS =
            {
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_0.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_1.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_2.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_3.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_4.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_5.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_6.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_7.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_8.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_9.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Bleu_Mini_10.png"))

            };
    private static final ImageIcon[] SCORESROUGES =
            {
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_0.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_1.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_2.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_3.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_4.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_5.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_6.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_7.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_8.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_9.png")),
                    new ImageIcon(ImageIcon.class.getResource("img/scores/Score_Rouge_Mini_10.png"))
            };*/
    private final ImageIcon empty = new ImageIcon(getClass().getResource(("img/Empty.jpg")));

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

        a = new JLabel("coucou");
        int i, j;
        String adresse = "img/scores/";
        cartesTeamA = new ArrayList<>(5);
        for(i=0; i<cartesTeamA.size(); i++)
        {
            adresse += tabImageA[i];
            System.out.println(adresse);
            //cartesTeamA.add(i, new ImageIcon(ImageIcon.class.getResource(adresse )));
            adresse = "";
        }
        cartesTeamB = new ArrayList<>(5);
    }
    private void creerWidget()
    {
        JPanel pano = new JPanel();
        pano.add(a);
        setContentPane(pano);
    }
}