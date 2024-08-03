package entites;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

/**
 * Représente une adresse, qui peut être intégrée dans une autre entité comme une partie de celle-ci
 * Entité embedded dans l'entité Client
 */
@Embeddable
public class Adresse {

    // attributs

    /**
     * Identifiant unique de l'adresse
     * <p>
     * Cet attribut ne sera pas utilisé comme clé primaire car il s'agit d'une entité intégrée.
     * Cependant, il est inclus pour l'identification logique.
     * </p>
     */
    @Column(name = "id")
    private int id;

    /**
     * Nom de la rue
     */
    @Column(name = "rue")
    private String rue;

    /**
     * Code postal
     */
    @Column(name = "code_postal")
    private int codePostal;

    /**
     * Ville
     */
    @Column(name = "ville")
    private String ville;

    // constructeurs

    /**
     * Constructeur par défaut
     */
    public Adresse() {
    }

    /**
     * Constructeur avec paramètres pour initialiser les attributs de l'adresse
     *
     * @param id Identifiant unique de l'adresse
     * @param rue Nom de la rue
     * @param codePostal Code postal
     * @param ville Ville
     */
    public Adresse(int id, String rue, int codePostal, String ville) {
        this.id = id;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    // méthodes

    /**
     * Retourne l'identifiant unique de l'adresse
     *
     * @return l'identifiant unique de l'adresse
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant unique de l'adresse
     *
     * @param id le nouvel identifiant unique de l'adresse
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne le nom de la rue
     *
     * @return le nom de la rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Modifie le nom de la rue
     *
     * @param rue le nouveau nom de la rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Retourne le code postal
     *
     * @return le code postal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Modifie le code postal
     *
     * @param codePostal le nouveau code postal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Retourne le nom de la ville
     *
     * @return le nom de la ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Modifie le nom de la ville
     *
     * @param ville le nouveau nom de la ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Retourne une représentation textuelle de l'objet Adresse
     *
     * @return une chaîne de caractères représentant l'objet Adresse
     */
    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                '}';
    }
}
