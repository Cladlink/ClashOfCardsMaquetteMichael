import javax.swing.*;

public class Model
{
    private Boolean plateauPret = false;
    private JLabel carteMemoire;
    private Boolean joueur = true;
    private int iBleu = 5;
    private int iRouge = 5;

    public int getiBleu() {
        return iBleu;
    }
    public int getiRouge() {
        return iRouge;
    }
    
    private final static String PATHEMPTY = "src/img/Empty.jpg";;
    private int i;
    public Boolean getJoueur() {
        return joueur;
    }
    public void setJoueur(Boolean joueur) {
        this.joueur = joueur;
    }
    public JLabel getCarteMemoire() {
        return carteMemoire;
    }
    public void setCarteMemoire(JLabel carteMemoire) {
        this.carteMemoire = carteMemoire;
    }
    public Boolean getPlateauPret() {
        return plateauPret;
    }
    public void setPlateauPret(Boolean plateauPret) {
        this.plateauPret = plateauPret;
    }

    public void normal(Carte[] cartesJ1, Carte[] cartesJ2, JLabel[][] plateau, int x, int y)
    {
        int carteJouee=0;

        if(joueur)
        {
            // stockage de la carte qui vient d'être jouée
            for (i=0;i<cartesJ1.length;i++)
            {
                if (plateau[x][y].getIcon().toString().contains(cartesJ1[i].getAdresseBleue()))
                {
                    carteJouee=i;
                }
            }

            //test depuis la droite
            if (y+1<=2 && plateau[x][y+1].getIcon().toString() != PATHEMPTY)
            {
                for(i=0; i<cartesJ2.length;i++)
                {
                    if (plateau[x][y+1].getIcon().toString().contains(cartesJ2[i].getAdresseRouge())
                            && cartesJ2[i].getWest() < cartesJ1[carteJouee].getEast())
                    {
                        flip(plateau, cartesJ2[i], x, y+1);
                    }
                    else if(plateau[x][y+1].getIcon().toString().contains(cartesJ1[i].getAdresseRouge())
                            && cartesJ2[i].getWest() < cartesJ1[carteJouee].getEast())
                    {
                        flip(plateau, cartesJ1[i], x, y+1);
                    }

                }
            }
            //test depuis la gauche
            if (y-1>=0 && plateau[x][y-1].getIcon().toString() != PATHEMPTY)
            {
                for(i=0; i<cartesJ2.length;i++)
                {
                    if (plateau[x][y-1].getIcon().toString().contains(cartesJ2[i].getAdresseRouge())
                            && cartesJ2[i].getEast() < cartesJ1[carteJouee].getWest())
                    {
                        flip(plateau, cartesJ2[i], x, y-1);
                    }
                    else if (plateau[x][y-1].getIcon().toString().contains(cartesJ1[i].getAdresseRouge())
                        && cartesJ2[i].getEast() < cartesJ1[carteJouee].getWest())
                    {
                        flip(plateau, cartesJ1[i], x, y-1);
                    }
                }
            }
            if (x+1<=2 && plateau[x+1][y].getIcon().toString() != PATHEMPTY)
            {
                //test depuis le dessus
                for(i=0; i<cartesJ2.length;i++)
                {
                    if (plateau[x+1][y].getIcon().toString().contains(cartesJ2[i].getAdresseRouge())
                            && cartesJ2[i].getNorth() < cartesJ1[carteJouee].getSouth())
                    {
                        flip(plateau, cartesJ2[i], x+1, y);
                    }
                    else if(plateau[x+1][y].getIcon().toString().contains(cartesJ1[i].getAdresseRouge())
                            && cartesJ2[i].getNorth() < cartesJ1[carteJouee].getSouth())
                    {
                        flip(plateau, cartesJ1[i], x+1, y);

                    }
                }
            }
            if (x-1>=0 && plateau[x-1][y].getIcon().toString() != PATHEMPTY)
            {
                //test depuis le dessous
                for(i=0; i<cartesJ2.length;i++)
                {
                    if (plateau[x-1][y].getIcon().toString().contains(cartesJ2[i].getAdresseRouge())
                            && cartesJ2[i].getSouth() < cartesJ1[carteJouee].getNorth())
                    {
                        flip(plateau, cartesJ2[i], x-1, y);
                    }

                    else if (plateau[x-1][y].getIcon().toString().contains(cartesJ1[i].getAdresseRouge())
                            && cartesJ2[i].getSouth() < cartesJ1[carteJouee].getNorth())
                    {
                        flip(plateau, cartesJ1[i], x-1, y);
                    }
                }
            }
        }
        //adversaire
        else
        {
            // stockage de la carte qui vient d'être jouée
            for (i=0;i<cartesJ1.length;i++)
            {
                if (plateau[x][y].getIcon().toString().contains(cartesJ2[i].getAdresseRouge()))
                {
                    carteJouee=i;
                }
            }
            //test depuis la droite
            if (y+1<=2 && plateau[x][y+1].getIcon().toString() != PATHEMPTY)
            {
                for(i=0; i<cartesJ1.length;i++)
                {
                    if (plateau[x][y+1].getIcon().toString().contains(cartesJ1[i].getAdresseBleue())
                            && cartesJ1[i].getWest() < cartesJ2[carteJouee].getEast())
                    {
                        flip(plateau, cartesJ1[i], x, y+1);
                    }
                    else if (plateau[x][y+1].getIcon().toString().contains(cartesJ2[i].getAdresseBleue())
                            && cartesJ1[i].getWest() < cartesJ2[carteJouee].getEast())
                    {
                        flip(plateau, cartesJ2[i], x, y+1);

                    }
                }
            }
            //prise depuis la gauche
            if (y-1>=0 && plateau[x][y-1].getIcon().toString() != PATHEMPTY)
            {
                for(i=0; i<cartesJ1.length;i++)
                {
                    if (plateau[x][y-1].getIcon().toString().contains(cartesJ1[i].getAdresseBleue())
                            && cartesJ1[i].getEast() < cartesJ2[carteJouee].getWest())
                    {
                        flip(plateau, cartesJ1[i], x, y-1);
                    }
                    else if (plateau[x][y-1].getIcon().toString().contains(cartesJ2[i].getAdresseBleue())
                            && cartesJ1[i].getEast() < cartesJ2[carteJouee].getWest())
                    {
                        flip(plateau, cartesJ2[i], x, y-1);
                    }
                }
            }
            //test depuis le haut
            if (x+1<=2 && plateau[x+1][y].getIcon().toString() != PATHEMPTY)
            {
                for(i=0; i<cartesJ1.length;i++)
                {
                    if (plateau[x+1][y].getIcon().toString().contains(cartesJ1[i].getAdresseBleue())
                            && cartesJ1[i].getNorth() < cartesJ2[carteJouee].getSouth())
                    {
                        flip(plateau, cartesJ1[i], x+1, y);
                    }
                    else if( plateau[x+1][y].getIcon().toString().contains(cartesJ2[i].getAdresseBleue())
                            && cartesJ1[i].getNorth() < cartesJ2[carteJouee].getSouth())
                    {
                        flip(plateau, cartesJ2[i], x+1, y);
                    }
                }
            }
            //test depuis le bas
            if (x-1>=0 && plateau[x-1][y].getIcon().toString() != PATHEMPTY)
            {
                //NS
                for(i=0; i<cartesJ2.length;i++)
                {
                    if (plateau[x-1][y].getIcon().toString().contains(cartesJ1[i].getAdresseBleue())
                            && cartesJ1[i].getSouth() < cartesJ2[carteJouee].getNorth())
                    {
                        flip(plateau, cartesJ1[i], x-1, y);
                    }
                    else if (plateau[x-1][y].getIcon().toString().contains(cartesJ2[i].getAdresseBleue())
                            &&  cartesJ1[i].getSouth() < cartesJ2[carteJouee].getNorth())
                    {
                        flip(plateau, cartesJ2[i], x-1, y);
                    }
                }
            }
        }
    }
    public void flip(JLabel[][] plateau, Carte carte, int x, int y)
    {
        if(plateau[x][y].getIcon().toString().contains("Rouge.jpg"))
        {
            plateau[x][y]= new JLabel(carte.getImageBleue());
            iBleu++;
            iRouge--;

        }
        else
        {
            plateau[x][y]= new JLabel(carte.getImageRouge());
            iBleu--;
            iRouge++;

        }
    }
}