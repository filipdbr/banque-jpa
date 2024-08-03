package entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Compte")
public class Compte {

    // attributs
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "Id")
    private Integer id;
    @Column (name = "Numero_Compte")
    private String numero_compte;
    @Column (name = "Solde")
    private double solde;
    @ManyToMany (mappedBy = "comptes")
    private Set<Client> clients;

    {
        clients = new HashSet<Client>();
    }

    // contructeurs

    public Compte() {

    }

    public Compte(String numero_compte, double solde) {
        this.numero_compte = numero_compte;
        this.solde = solde;
    }

    // méthodes

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_compte() {
        return numero_compte;
    }

    public void setNumero_compte(String numero_compte) {
        this.numero_compte = numero_compte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero_compte='" + numero_compte + '\'' +
                ", solde=" + solde +
                '}';
    }
}
