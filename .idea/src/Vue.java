import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by cladlink on 21/01/16.
 */
public class Vue extends JFrame
{
    private ImageIcon[][] plateau;
    private ArrayList<ImageIcon> cartesTeamA;
    private ArrayList<ImageIcon> cartesTeamB;
    private static final ImageIcon[] SCORESBLEUS = 
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
            };
    private ImageIcon empty;

    public Vue (Model model)
    {
        initAttributs();
        setSize(1100,700);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initAttributs()
    {
        
    }
    private void creerWidget()
    {
        
    }

}
