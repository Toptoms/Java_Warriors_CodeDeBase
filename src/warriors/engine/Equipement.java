package warriors.engine;


import warriors.contracts.Case;
import warriors.contracts.Hero;


public class Equipement implements Case {
    private String nom;
    private int point;


    public Equipement(String nom, int attaque) {

        this.nom = nom;
        this.point = attaque;
    }

    public String toString() {
        return this.nom +
                " point + " + this.point;
    }

    public void modifstat(Hero hero) {

        if ((nom == "arc" || nom == "massue" || nom == "epee") && ((Personnage) hero) instanceof Guerrier) {
            ((Personnage) hero).setAttackLevel(point + ((Personnage) hero).getAttackLevel());


        } else if ((nom == "eclair" || nom == "boules de feu") && ((Personnage) hero) instanceof Magicien) {
            ((Personnage) hero).setAttackLevel(point + ((Personnage) hero).getAttackLevel());

        }
        else if (nom == "potion mineure"){
            ((Personnage) hero).setLife(point+((Personnage) hero).getLife());
    }

    }


    public Equipement() {
    }

    public void setPoint(int attaque) {
        this.point = attaque;
    }

    public int getAttaque() {
        return point;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }


}
