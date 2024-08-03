package entites;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Représente un compte bancaire dans la base de données
 * <p>
 * Conventions de nommage SQL utilisées :
 * - Noms de tables en PascalCase
 * - Noms de colonnes en snake_case
 * </p>
 */
@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    // attributs

    /**
     * <b>Map de variables</b>
     *
     * Identifiant unique du compte
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * Numéro du compte
     */
    @Column(name = "numero_compte")
    private String numeroCompte;

    /**
     * Solde du compte
     */
    @Column(name = "solde")
    private double solde;

    /**
     * Clients associés au compte
     */
    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    /**
     * Opérations associées au compte
     */
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    /**
     * Bloc d'initialisation pour initialiser les ensembles de clients et d'opérations
     */
    {
        clients = new HashSet<>();
        operations = new HashSet<>();
    }

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public Compte() {
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs du compte
     *
     * @param numeroCompte Numéro du compte
     * @param solde Solde du compte
     */
    public Compte(String numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    // méthodes

    /**
     * Retourne l'identifiant du compte
     *
     * @return l'identifiant du compte
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du compte
     *
     * @param id le nouvel identifiant du compte
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retourne le numéro du compte
     *
     * @return le numéro du compte
     */
    public String getNumeroCompte() {
        return numeroCompte;
    }

    /**
     * Modifie le numéro du compte
     *
     * @param numeroCompte le nouveau numéro du compte
     */
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    /**
     * Retourne le solde du compte
     *
     * @return le solde du compte
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Modifie le solde du compte
     *
     * @param solde le nouveau solde du compte
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Retourne l'ensemble des clients associés au compte
     *
     * @return un ensemble de clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Modifie l'ensemble des clients associés au compte
     *
     * @param clients le nouvel ensemble de clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * Retourne une représentation textuelle de l'objet Compte
     *
     * @return une chaîne de caractères représentant l'objet Compte
     */
    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                '}';
    }
}
