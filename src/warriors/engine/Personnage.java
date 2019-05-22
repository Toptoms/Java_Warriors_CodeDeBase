package warriors.engine;


import warriors.contracts.Hero;

public abstract class Personnage implements Hero {
    private String nom;
    private String image;
    private int vie;
    private int attaque;


    public Personnage() {
    }

    public Personnage(String nom, String image, int vie, int attaque) {
        this.nom = nom;
        this.image = image;
        this.vie = vie;
        this.attaque = attaque;

    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getName() {
        return nom;
    }

    public void setImage(String image) {
        this.image = nom;
    }

    public String getImage() {
        return image;
    }


    public void setAttackLevel(int attaque) {
        this.attaque = attaque;
    }

    public int getAttackLevel() {
        return attaque;
    }

    public void setLife(int vie) {
        this.vie = vie;
    }

    public int getLife() {
        return vie;
    }


    public String toString() {
        return "1 nom : " + this.nom +
                "\n2 image : " + this.image +
                "\n3 vie : " + this.vie +
                "\n4 attaque : " + this.attaque;


    }
}
