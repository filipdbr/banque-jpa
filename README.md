<h1>Projet Banque-JPA</h1>

<h2>Description</h2>
Ce projet est une implémentation complète des exercices de TP 4 et 5 de mon cours sur la modélisation JPA (Java Persistence API) chez Diginamic.

L'objectif est de renforcer les compétences en modélisation JPA, y compris l'utilisation des annotations relationnelles et d'héritage. Le projet consiste à créer diverses entités, à établir des relations et à les persister dans une base de données.

<h2>Entités et relations clés :</h2>

    1. Entités Créées :
        Banque : Représente une entité bancaire.
        Client : Représente un client bancaire. Chaque client peut avoir plusieurs comptes.
        Compte : Une classe abstraite représentant un compte bancaire.
            LivretA : Un type spécifique de compte d'épargne.
            AssuranceVie : Un compte d'assurance vie.
        Virement : Représente une opération de virement bancaire.

    2. Fonctionnalités implémentées :
        Insertion d'un compte associé à deux clients : le compte d'assurance vie (assurance1) est associé à la fois au client 2 (Kanye West) et au client 3 (Zinedine Zidane).
        Insertion d'un client avec plusieurs comptes : le client 1 (Filip Dabrowski) possède deux comptes :

    3. Fonctionnalités Supplémentaires :
        Insertion de plusieurs opérations de Virement pour démontrer la gestion des transactions.

<h2>Structure du Projet</h2>

    Package des Entités (entites) : Contient toutes les classes d'entités avec les annotations JPA appropriées.
    Classe Principale (App) : Le point d'entrée de l'application, responsable de la création d'un EntityManager, de la gestion des transactions et de la persistance des entités.

<h2>Commentaire de l'auteur</h2>
<p></p>Tout le code et la logique ont été crée par l'auteur, sans utiliser l'IA.</p>
<p>Cependant, la génération des opérations de virements, en raison de sa nature répétitive a été automatisée à l'aide de l'IA. De plus, ce fichier README a été rédigé avec l'aide de l'IA pour assurer une présentation claire et cohérente. L'intégralité du fichier README a été vérifiée par l'auteur.</p>

<h2>Comment Exécuter</h2>

    Configurez une base de données MariaDB avec le nom "banque".
    Assurez-vous que votre persistence.xml est correctement configuré avec l'URL de la base de données et les identifiants.
    Exécutez l'application en utilisant un environnement Java approprié.

<h3>Informations Supplémentaires</h3>

Le projet adhère aux exigences spécifiées dans les exercices de TP. Le code est structuré pour être clair et maintenable, suivant les meilleures pratiques en matière de JPA et de conception orientée objet.

<h2>Auteur</h2>

<b>Filip Dabrowski</b>

L'auteur a personnellement écrit l'essentiel du code et vérifié l'ensemble du projet, à l'exception de l'automatisation de certaines parties répétitives via l'IA.
