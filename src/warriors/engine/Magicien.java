package warriors.engine;


public class Magicien extends Personnage {


    public Magicien() {
    }


    public Magicien(String nom, String image, int vie, int attaque) {
        super(nom, image, vie, attaque);
        this.viemax = 6;
        this.attaquemax = 15;
    }


}




