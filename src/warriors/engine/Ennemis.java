package warriors.engine;

import warriors.contracts.Case;
import warriors.contracts.Hero;

public class Ennemis implements Case {

    private String nom;
    private int vie;
    private int attaque;
    private String image;


    public Ennemis(String nom, int vie, int attaque, String image) {
        this.nom = nom;
        this.vie = vie;
        this.attaque = attaque;
        this.image = image;
    }

    public Ennemis() {
    }

    public String toString() {
        return this.nom +
                " -> (vie: " + this.vie +
                " attaque: " + this.attaque + ")";

    }

    @Override
    public void modifstat(Hero hero) {

        vie = vie - ((Personnage) hero).getAttackLevel();
        if (vie > 0) {
            ((Personnage) hero).setLife(((Personnage) hero).getLife() - attaque);
        }

    }


    public void setLife(int vie) {

        this.vie = vie;
    }

    public String getName() {
        return nom;
    }


    public String getImage() {
        return image;
    }


    public int getLife() {
        return vie;
    }


    public int getAttackLevel() {
        return attaque;
    }


}
