package entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Représente un client dans la base de données
 * <p>
 * Conventions de nommage SQL utilisées :
 * - Noms de tables en PascalCase
 * - Noms de colonnes en snake_case
 * </p>
 */
@Entity
@Table(name = "Client")
public class Client {


    // attributs

    /**
     * <b>Map de variables</b>
     *
     * Identifiant unique du client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * Nom du client
     */
    @Column(name = "nom")
    private String nom;

    /**
     * Prénom du client
     */
    @Column(name = "prenom")
    private String prenom;

    /**
     * Date de naissance du client
     */
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    /**
     * La relation entre la banque et le client
     * Dans notre modèle, un client ne peut être affecté qu'à une seule banque.
     */
    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    /**
     * Comptes associés au client
     * Un client peut posseder plusieur comptes
     */
    @ManyToMany
    @JoinTable(
            name = "banque_compte",
            joinColumns = @JoinColumn(name = "banque_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id", referencedColumnName = "id")
    )
    private Set<Compte> comptes;

    /**
     * Bloc d'initialisation pour initialiser les comptes
     */
    {
        comptes = new HashSet<>();
    }

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public Client() {
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs du client
     *
     * @param nom Nom du client
     * @param prenom Prénom du client
     * @param dateNaissance Date de naissance du client
     */
    public Client(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    // méthodes

    /**
     * Retourne l'identifiant du client
     *
     * @return l'identifiant du client
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du client
     *
     * @param id le nouvel identifiant du client
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retourne le nom du client
     *
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du client
     *
     * @param nom le nouveau nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom du client
     *
     * @return le prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom du client
     *
     * @param prenom le nouveau prénom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne la date de naissance du client
     *
     * @return la date de naissance du client
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Modifie la date de naissance du client
     *
     * @param dateNaissance la nouvelle date de naissance du client
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne la banque associée au client
     *
     * @return la banque associée au client
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Modifie la banque associée au client
     *
     * @param banque la nouvelle banque associée au client
     */
    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     * Retourne l'ensemble des comptes associés au client
     *
     * @return un ensemble de comptes
     */
    public Set<Compte> getComptes() {
        return comptes;
    }

    /**
     * Modifie l'ensemble des comptes associés au client
     *
     * @param comptes le nouvel ensemble de comptes
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    /**
     * Retourne une représentation textuelle de l'objet Client
     *
     * @return une chaîne de caractères représentant l'objet Client : id, nom et prénom sans de date de naissance
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}