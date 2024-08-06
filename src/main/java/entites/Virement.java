package entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Représente une opération de virement bancaire dans la base de données
 * <p>
 * Conventions de nommage SQL utilisées :
 * - Noms de tables en PascalCase
 * - Noms de colonnes en snake_case
 * </p>
 */
@Entity
@Table(name = "Operation")
public class Virement extends Operation {

    // attributs

    /**
     * <b>Map de variables</b>
     *
     * Identifiant unique du virement
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * Le bénéficiaire du virement
     */
    @Column(name = "beneficiaire")
    private String beneficiaire;

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public Virement() {
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs du virement
     *
     * @param date Date et heure de l'opération
     * @param montant Montant de l'opération
     * @param motif Motif de l'opération
     * @param beneficiaire Bénéficiaire du virement
     */
    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    // méthodes

    /**
     * Retourne le bénéficiaire du virement
     *
     * @return le bénéficiaire du virement
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Modifie le bénéficiaire du virement
     *
     * @param beneficiaire le nouveau bénéficiaire du virement
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    /**
     * Retourne une représentation textuelle de l'objet Virement
     *
     * @return une chaîne de caractères représentant l'objet Virement
     */
    @Override
    public String toString() {
        return "Virement{" +
                "id=" + super.getId() +
                ", date=" + getDate() +
                ", montant=" + getMontant() +
                ", motif='" + getMotif() + '\'' +
                ", beneficiaire='" + beneficiaire + '\'' +
                '}';
    }
}
