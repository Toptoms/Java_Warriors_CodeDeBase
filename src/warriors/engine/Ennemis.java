package warriors.engine;

import warriors.contracts.Case;

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
    public Ennemis(){}

    public String toString() {
        return "1 nom : " + this.nom +
                "\n2 image : " + this.image +
                "\n3 vie : " + this.vie +
                "\n4 attaque : " + this.attaque;

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
