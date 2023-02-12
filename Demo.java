//DJIAVOUDINE Quthbulhameed et Idrissa 

import java.util.Date;

public class Demo {
    public static void main (String[] args) {
        // Création de la banque
        Bank banque = new Bank("Banque LCL", "1 rue de la Banque");

        // Création de comptes Standard et Premium
        StandardAccount compteStandard = new StandardAccount(123456, 4000, new Date(), banque);
        PremiumAccount comptePremium = new PremiumAccount(122356, 4000, new Date(), banque);

        // Création de  CompteEpargne et CompteCourant
        SavingsAccount compteEpargne = new SavingsAccount(987654, 500, new Date(), banque, 7);
        CurrentAccount compteCourant = new CurrentAccount(456789, 500, new Date(), banque, 500);

        //Création de coordonnes du client a partir de la classe imbrique
        Customer.Coordonnees coordonnees1 = new Customer.Coordonnees("0632345671", "Paula.john@gmail.com");
        Customer.Coordonnees coordonnees2 = new Customer.Coordonnees("0682345672", "lucas.Durand@gmail.com");
        Customer.Coordonnees coordonnees3 = new Customer.Coordonnees("0602345674", "Hameed.charyyymid@gmail.com");
        Customer.Coordonnees coordonnees4 = new Customer.Coordonnees("0642345673", "idrissa.mug@gmail.com");


        //Création de clients
        Customer client1 = new Customer("Paula", "john",coordonnees1, "2 rue des Clients",Customer.Sexe.FEMALE, Customer.Type.standard, banque, compteStandard);
        Customer client2 = new Customer("lucas", "Durand",coordonnees2, "3 rue des Clients",Customer.Sexe.MALE,Customer.Type.standard, banque, compteEpargne);
        Customer client3 = new Customer("Hameed", "charyyymid",coordonnees3, "3 rue des Clients",Customer.Sexe.MALE,Customer.Type.premium ,banque, comptePremium);
        Customer client4 = new Customer("idrissa", "mug",coordonnees4, "3 rue des Clients",Customer.Sexe.MALE,Customer.Type.premium, banque, compteCourant);


        // Affichage des informations du client

        System.out.println("\n --------------------------------------Affichage les informations du client 3 seulement-------------------------------------------");

        System.out.println("Nom : " + client3.getNom());
        System.out.println("Prénom : " + client3.getPrenom());
        System.out.println("Coordonnées : " + client3.getCoordonnees().getNumeroTelephone() + ", " + client3.getCoordonnees().getEmail());
        System.out.println("adresse: " + client3.getAdresse());
        System.out.println("Sexe : " + client3.getSexe());
        System.out.println("Type : " + client3. getType());
        System.out.println("Banque : " + client3.getBanque().getNom());
        //Affichage du solde total des comptes du client
        System.out.println("Solde total du client : " + client1.getSoldeTotal() + "e");




        System.out.println("\n --------------------------------------Aprés voir ajouter des clients a la banque  -----------------------------------------------");


        // Ajout des clients à la banque
        banque.ajouterClient(client1);
        banque.ajouterClient(client2);
        banque.ajouterClient(client3);
        banque.ajouterClient(client4);



        int nombreClientAjoute = banque.getNombreClients();
        System.out.println("\n  Le nombre de clients de la banque est : " + nombreClientAjoute);


        System.out.println("\n --------------------------------------Aprés voir supprimer un clients a la banque  ----------------------------------------------");

        banque.supprimerClient(client4);


        int nombreClientSupprimer = banque.getNombreClients();
        System.out.println("\n  Le nombre de clients de la banque est : " + nombreClientSupprimer);




        System.out.println("\n --------------------------------------Faire La Demandede du Pret ----------------------------------------------------------------");

        System.out.println("\nSolde total du client 1 : " + client1.getSoldeTotal() + "e");

        // Demande de prêt par le client
        client1.demandePret(500, 12, 0.0);

        // Afficher les prêts en cours de la banque
        // Afficher les prêts en cours de la banque
        banque.afficherPretEnCours();

        // Affichage du solde total des comptes du client après demande de prêt
        System.out.println("Solde total du client 1 après demande de prêt : " + client1.getSoldeTotal() + "e");

        //Affichage du solde total des comptes du client après demande de prêt

        // Récupération du prêt du client
        Loan loan = client1.getLoans().get(0);




        // Remboursement par le client
        client1.remboursement(250);
        client1.remboursement(250);

        // Affichage du solde total des comptes du client après remboursement
        System.out.println("Solde total du client 1 après remboursement : " + client1.getSoldeTotal() + "e");

        System.out.println("\n --------------------------------------Affichage des informations sur le prêt----------------------------------------------------");

        // Affichage des informations sur le prêt
        System.out.println("Informations sur le prêt :");
        System.out.println("- Montant : " + loan.getMontant() + "e");
        System.out.println("- Durée : " + loan.getDuree() + " mois");
        System.out.println("- Taux d'intérêt : " + loan.getTauxInteret() + "%");
        System.out.println("- Date de demande : " + loan.getDateDemande());
        System.out.println("- Montant remboursé : " + loan.getMontantRembourse() + "e");





        System.out.println("\n --------------------------------------Opérations debiter sur les comptes---------------------------------------------------------");

        System.out.println("\n|||||||||||-------------Avant débit -------------|||||||||||");

        System.out.println("\nSolde du compte standard avant le débit Pour le client 1 ");

        // Affichage des informations
        System.out.println("\nInformations du client 1 :");
        System.out.println("Nom : " + client1.getNom());
        System.out.println("Prénom : " + client1.getPrenom());
        System.out.println("Adresse : " + client1.getAdresse());
        System.out.println("Banque : " + client1.getBanque().getNom());
        System.out.println("Solde du compte standard avant le  débit : " + client1.getSoldeTotal() + "e");

        //Affichage du solde du compte standard apres  débit
        compteStandard.retireMontant(200);


        System.out.println("\n|||||||||||-------------Après débit-------------|||||||||||");


        System.out.println("\nSolde du compte standard après le  débit Pour le client 1 " );

        // Affichage des informations
        System.out.println("Informations du client 1 :");
        System.out.println("Nom : " + client1.getNom());
        System.out.println("Prénom : " + client1.getPrenom());
        System.out.println("Adresse : " + client1.getAdresse());
        System.out.println("Banque : " + client1.getBanque().getNom());
        System.out.println("Solde du compte standard apres le  débit : " + client1.getSoldeTotal() + "e");


        System.out.println("\n_______________________________________Opérations crediter sur les comptes________________________________________________________" );

        System.out.println("\n|||||||||||-------------Avant crediter -------------|||||||||||");


        System.out.println("\nSolde du compte standard avant le crediter Pour le client 1 ");

        // Affichage des informations
        System.out.println("\nInformations du client 1 :");
        System.out.println("Nom : " + client1.getNom());
        System.out.println("Prénom : " + client1.getPrenom());
        System.out.println("Adresse : " + client1.getAdresse());
        System.out.println("Banque : " + client1.getBanque().getNom());
        System.out.println("Solde du compte standard avant le  crediter : " + client1.getSoldeTotal() + "e");

        System.out.println("\n|||||||||||-------------Après crediter-------------|||||||||||");

        System.out.println("\nSolde du compte standard après le  débit Pour le client 1 " );
        compteStandard.credit(1222);

        // Affichage des informations
        System.out.println("\nInformations du client 1 :");
        System.out.println("Nom : " + client1.getNom());
        System.out.println("Prénom : " + client1.getPrenom());
        System.out.println("Adresse : " + client1.getAdresse());
        System.out.println("Banque : " + client1.getBanque().getNom());
        System.out.println("Solde du compte standard apres  le  crediter : " + client1.getSoldeTotal() + "e");




        System.out.println("\n-------------------------------------------------Opérations sur les comptes (Compte Epargne)--------------------------------------");

        System.out.println("\n|||||||||||-------------Avant de mettre dans la compte epargne-------------|||||||||||");

        System.out.println("\nAvant le Solde total est " + client2.getSoldeTotal());
        compteEpargne.debiterCompte(50);


        System.out.println("\n|||||||||||-------------Apres avoir mis ou retire dans la compte epargne-------------|||||||||||");



        System.out.println("\nApres le Solde total est  : " + client2.getSoldeTotal());
        //Ajout de l'intérêt au compte épargne
        compteEpargne.addInteret();

        System.out.println("\n|||||||||||---------------------Avec le taux d'interet----------------------|||||||||||");


        // Affichage du solde du compte épargne après ajout de l'intérêt
        System.out.println("\nOn ajoute Taux d'intérêt du compte épargne : " + compteEpargne.getTauxInteret() + "%" );
        System.out.println("\nAvec son taux d'interet de" + " "+ compteEpargne.getTauxInteret() + "%"+ " "+   "son solde va agumenter ." );
        System.out.println("\nSolde total : " + client2.getSoldeTotal());



        System.out.println("\nInformations du client 2 :");
        System.out.println("Nom : " + client2.getNom());
        System.out.println("Prénom : " + client2.getPrenom());
        System.out.println("Adresse : " + client2.getAdresse());
        System.out.println("Banque : " + client2.getBanque().getNom());
        System.out.println("Solde total : " + client2.getSoldeTotal());






        System.out.println("\n-----------------------------------------Opérations sur les comptes (Compte Actuelle)---------------------------------------------");




        System.out.println("\n|||||||||||-------------Avant de retire avec le compte actuelle -------------|||||||||||");
        System.out.println("Solde total : " + client4.getSoldeTotal());


        System.out.println("\n|||||||||||-------------apres avoir retire  avec le compte actuelle -------------|||||||||||");


        compteCourant.debiterCompte(250);
        System.out.println("Solde total : " + client4.getSoldeTotal());


        System.out.println("\n|||||||||||-------------au dela de la de decouvertAutorise  -------------|||||||||||");

        System.out.println("\n j aurais une erreur parceque je dois pas depasse ");


        System.out.println("\nInformations du client 4 :");
        System.out.println("Nom : " + client4.getNom());
        System.out.println("Prénom : " + client4.getPrenom());
        System.out.println("Adresse : " + client4.getAdresse());
        System.out.println("Banque : " + client4.getBanque().getNom());
        System.out.println("Solde total : " + client4.getSoldeTotal());


    }

}
