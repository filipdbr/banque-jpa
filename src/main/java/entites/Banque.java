package entites;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * La classe représente une entité de banque dans la base de données.
 * <p>
 * Conventions de nommage SQL utilisées :
 * - Noms de tables en PascalCase
 * - Noms de colonnes en snake_case
 * </p>
 */
@Entity
@Table (name = "Banque")
public class Banque {

    // attributs

    /**
     * <b>Map de variables</b>
     *
     * Identifiant unique de la banque.
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    /**
     * Le nom de la banque
     */
    @Column (name = "nom")
    private String nom;

    /**
     * La relation entre la banque est les clients
     * Un banque peut posseder plusieurs clients
     */
    @OneToMany(mappedBy = "Banque")
    private Set<Client> clients;

    /**
     * bloc d'initialisation
     */
    {
        clients = new HashSet<>();
    }

    // constructeurs

    /**
     * Constructeur vide (par défaut)
     */
    public Banque() {

    }

    /**
     * Constructeur avec paramètre pour initialiser le nom de la banque
     *
     * @param nom Nom de la banque en String
     */
    public Banque(String nom) {
        this.nom = nom;
    }

    // méthodes

    /**
     * Return le nom de la banque
     *
     * @return le nom de la banque
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la banque
     *
     * @param nom nouveau nom de la banque
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la liste des clients de la banque
     *
     * @return la liste des clients de la banque
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Modifie la liste des clients de la banque
     *
     * @param clients la nouvelle liste des clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * Retourne une représentation textuelle de l'objet Banque.
     *
     * @return une chaîne de caractères représentant l'objet Banque.
     */
    @Override
    public String toString() {
        return "Banque{" +
                "nom='" + nom + '\'' +
                '}';
    }

}
