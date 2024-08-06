package entites;

import jakarta.persistence.*;

/**
 * Représente un Livret A, un type spécifique de compte bancaire
 *  * <p>
 *  * Conventions de nommage SQL utilisées :
 *  * - Noms de tables en PascalCase
 *  * - Noms de colonnes en snake_case
 *  * </p>
 */
@Entity
@Table(name = "LivretA")
public class LivretA extends Compte {

    // attributs

    @Column(name = "taux")
    private double taux;

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public LivretA() {
        super(); // Call to the default constructor of Compte
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs du Livret A
     *
     * @param numeroCompte Numéro du compte
     * @param solde Solde du compte
     * @param taux Taux d'intérêt
     */
    public LivretA(String numeroCompte, double solde, double taux) {
        super(numeroCompte, solde); // Call to the parameterized constructor of Compte
        this.taux = taux;
    }

    // méthodes

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "id=" + getId() +
                ", numeroCompte='" + getNumeroCompte() + '\'' +
                ", solde=" + getSolde() +
                ", taux=" + taux +
                '}';
    }
}
