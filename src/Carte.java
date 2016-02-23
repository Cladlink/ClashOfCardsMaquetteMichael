import javax.swing.*;
/**
 * Created by cladlink on 29/01/16.
 */
public class Carte
{
    private int north;
    private int east;
    private int south;
    private int west;

    public int getNorth() {
        return north;
    }
    public int getEast() {
        return east;
    }
    public int getSouth() {
        return south;
    }
    public int getWest() {
        return west;
    }

    private String adresseBleue;
    private String adresseRouge;

    public String getAdresseBleue() {
        return adresseBleue;
    }
    public String getAdresseRouge() {
        return adresseRouge;
    }

    private ImageIcon imageBleue;
    private ImageIcon imageRouge;
    public ImageIcon getImageBleue() {
        return imageBleue;
    }
    public ImageIcon getImageRouge() {
        return imageRouge;
    }



    public Carte(int n, int e, int s, int w, String adresseBleue, String adresseRouge)
    {
        this.north = n;
        this.east = e;
        this.south = s;
        this.west = w;

        this.adresseBleue = adresseBleue;
        this.adresseRouge = adresseRouge;

        imageBleue = new ImageIcon(getClass().getResource(this.adresseBleue));
        imageRouge = new ImageIcon(getClass().getResource(this.adresseRouge));


    }

}
