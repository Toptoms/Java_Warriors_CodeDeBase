package warriors.engine;


public class Guerrier extends Personnage {

    public Guerrier() {
    }


    public Guerrier(String nom, String image, int vie, int attaque) {
        super(nom, image, vie, attaque);
        this.viemax = 10;
        this.attaquemax = 10;

    }

}
