package warriors.engine;


import warriors.contracts.Hero;

public abstract class Personnage implements Hero {
    private String nom;
    private String image;
    private int vie;
    private int attaque;
    public int viemax;
    public int attaquemax;


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
        if (attaque > attaquemax) {
            this. attaque = attaquemax;
        } else {
            this.attaque = attaque;
        }

    }

    public int getAttackLevel() {
        return attaque;
    }

    public void setLife(int vie) {

        if (vie > viemax) {
            this.vie = viemax;
        } else {
            this.vie = vie;
        }

    }

    public int getLife() {
        return vie;
    }


    public String toString() {
        return this.nom +
                " -> (vie: " + this.vie +
                " attaque: " + this.attaque + ")";


    }
}
