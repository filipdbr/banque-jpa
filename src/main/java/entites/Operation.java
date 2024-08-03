package entites;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Représente une opération bancaire dans la base de données
 * <p>
 * Conventions de nommage SQL utilisées :
 * - Noms de tables en PascalCase
 * - Noms de colonnes en snake_case
 * </p>
 */
@Entity
@Table(name = "Operation")
public class Operation {

    // attributs

    /**
     * <b>Map de variables</b>
     *
     * Identifiant unique de l'opération
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * Date et heure de l'opération
     */
    @Column(name = "date")
    private LocalDateTime date;

    /**
     * Montant de l'opération
     */
    @Column(name = "montant")
    private double montant;

    /**
     * Motif de l'opération
     */
    @Column(name = "motif")
    private String motif;

    /**
     * Compte associé à l'opération
     */
    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public Operation() {
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs de l'opération
     *
     * @param date Date et heure de l'opération
     * @param montant Montant de l'opération
     * @param motif Motif de l'opération
     */
    public Operation(LocalDateTime date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    // méthodes

    /**
     * Retourne l'identifiant de l'opération
     *
     * @return l'identifiant de l'opération
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de l'opération
     *
     * @param id le nouvel identifiant de l'opération
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retourne la date et l'heure de l'opération
     *
     * @return la date et l'heure de l'opération
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Modifie la date et l'heure de l'opération
     *
     * @param date la nouvelle date et heure de l'opération
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Retourne le montant de l'opération
     *
     * @return le montant de l'opération
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Modifie le montant de l'opération
     *
     * @param montant le nouveau montant de l'opération
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Retourne le motif de l'opération
     *
     * @return le motif de l'opération
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Modifie le motif de l'opération
     *
     * @param motif le nouveau motif de l'opération
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * Retourne une représentation textuelle de l'objet Operation
     *
     * @return une chaîne de caractères représentant l'objet Operation
     */
    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                '}';
    }
}
