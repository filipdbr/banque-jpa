package entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Banque")
public class Banque {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "Id")
    private Integer id;
    @Column (name = "Nom")
    private String nom;
    @OneToMany(mappedBy = "Banque")
    private Set<Client> clients;

    {
        clients = new HashSet<>();
    }

    // constructeurs

    public Banque() {

    }

    public Banque(String nom) {
        this.nom = nom;
    }

    // getters and setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    // toString

    @Override
    public String toString() {
        return "Banque{" +
                "nom='" + nom + '\'' +
                '}';
    }

}
