package warriors.engine;

import warriors.contracts.Case;
import warriors.contracts.Hero;

public class Equipement implements Case {
    private String nom;
    private int attaque;


    public Equipement(String nom, int attaque) {

        this.nom = nom;
        this.attaque = attaque;
    }

    public String toString() {
        return "1 nom : " + this.nom +
                "\n2 point: " + this.attaque;
    }

    public

    public Equipement() {
    }

    public void setPoint(int attaque) {
        this.attaque = attaque;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }



}
