import entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        // // Créer EntityManagerFactory et EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Instancier des classes
        // 1. Adresses
        Adresse adresse1 = new Adresse(11, "Rue Saint-Denis", 34000, "Montpellier");
        Adresse adresse2 = new Adresse(52, "Rue Gambetta", 59000, "Lille");
        Adresse adresse3 = new Adresse(81, "Rue Jenesaispas", 48000, "Paris");

        // 2. Banques
        Banque hsbc = new Banque("HSBC");
        Banque bnp = new Banque("BNP");
        Banque filipBanque = new Banque("FilipBanque");

        // 3. Clients
        Client client1 = new Client("Dabrowski", "Filip", LocalDate.of(1991,10,03));
        Client client2 = new Client("West", "Kanye", LocalDate.of(1981,11,20));
        Client client3 = new Client("Zidane", "Zinedine", LocalDate.of(1995, 5, 15));

        // 4. Comptes
        LivretA livret1 = new LivretA("1294338l",10019.12,0.05);
        AssuranceVie assurance1 = new AssuranceVie("214332a", 1000.00, LocalDate.of(2090,10,01),0.01);
        AssuranceVie assurance2 = new AssuranceVie("222333b", 20500, LocalDate.of(2081,01,01),0.014);

        // 5. Virements (Généré en IA par Filip :))
        Virement virement1 = new Virement(LocalDateTime.of(2023, 8, 1, 10, 30), 200.0, "Paiement facture", "Alice Dupont");
        Virement virement2 = new Virement(LocalDateTime.of(2023, 8, 2, 14, 45), 1500.0, "Loyer août", "Bob Martin");
        Virement virement3 = new Virement(LocalDateTime.of(2023, 8, 3, 9, 15), 300.0, "Cadeau anniversaire", "Claire Lemoine");
        Virement virement4 = new Virement(LocalDateTime.of(2023, 8, 4, 16, 0), 50.0, "Remboursement", "David Renard");
        Virement virement5 = new Virement(LocalDateTime.of(2023, 8, 5, 11, 30), 100.0, "Frais de transport", "Eva Dubois");

        // Set Adresses
        client1.setAdresse(adresse1);
        client2.setAdresse(adresse2);
        client3.setAdresse(adresse3);

        // Attacher des banques aux clients
        client1.setBanque(filipBanque);
        client2.setBanque(bnp);
        client3.setBanque(hsbc);

        // Attacher des comptes aux clients
        // Selon le modèle, un compte peut être attribué à plusieurs clients (look: client 2 et 3)
        // Le client 1 aura 2 comptes comme demandé dans TP5
        // Aussi, il y a un compte associé au 2 clients : accurance 1 (comme demandé dans TP5)
        client1.addCompte(livret1);
        client2.addCompte(assurance1);
        client3.addCompte(assurance1);
        client1.addCompte(assurance2);

        // Attache des virements aux comptes
        /* Commentaire: ces transactions n'ont aucun sens dans le monde réel
        (par exemple les virements de compte d'assurance).
        Elles servent uniquement à montrer que le code fonctione
         */
        virement1.setCompte(livret1);
        virement2.setCompte(livret1);
        virement3.setCompte(assurance1);
        virement4.setCompte(livret1);
        virement5.setCompte(assurance1);

        // Persister les entités dans la base de données
        em.persist(hsbc);
        em.persist(bnp);
        em.persist(filipBanque);
        em.persist(client1);
        em.persist(client2);
        em.persist(client3);
        em.persist(livret1);
        em.persist(assurance1);
        em.persist(assurance2);
        em.persist(virement1);
        em.persist(virement2);
        em.persist(virement3);
        em.persist(virement4);
        em.persist(virement5);

        // Valider la transaction
        em.getTransaction().commit();

        // Fermer l'EntityManager and l'EntityManagerFactory
        em.close();
        emf.close();

        // C'est fini! :)

    }
}
