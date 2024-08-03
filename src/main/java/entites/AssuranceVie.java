package entites;

import java.time.LocalDate;

/**
 * Représente un compte de type Assurance Vie dans la base de données
 * <p>
 * Conventions de nommage SQL utilisées :
 * - Noms de tables en PascalCase
 * - Noms de colonnes en snake_case
 * </p>
 */
public class AssuranceVie extends Compte {

    // attributs

    /**
     * Date de fin de l'assurance vie
     */
    private LocalDate dateFin;

    /**
     * Taux d'intérêt de l'assurance vie
     */
    private double taux;

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public AssuranceVie() {
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs de l'assurance vie
     *
     * @param numeroCompte Numéro du compte
     * @param solde Solde du compte
     * @param dateFin Date de fin de l'assurance vie
     * @param taux Taux d'intérêt de l'assurance vie
     */
    public AssuranceVie(String numeroCompte, double solde, LocalDate dateFin, double taux) {
        super(numeroCompte, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    // méthodes

    /**
     * Retourne la date de fin de l'assurance vie
     *
     * @return la date de fin de l'assurance vie
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Modifie la date de fin de l'assurance vie
     *
     * @param dateFin la nouvelle date de fin de l'assurance vie
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Retourne le taux d'intérêt de l'assurance vie
     *
     * @return le taux d'intérêt de l'assurance vie
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Modifie le taux d'intérêt de l'assurance vie
     *
     * @param taux le nouveau taux d'intérêt de l'assurance vie
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     * Retourne une représentation textuelle de l'objet AssuranceVie
     *
     * @return une chaîne de caractères représentant l'objet AssuranceVie
     */
    @Override
    public String toString() {
        return "AssuranceVie{" +
                "numeroCompte='" + getNumeroCompte() + '\'' +
                ", solde=" + getSolde() +
                ", dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}
