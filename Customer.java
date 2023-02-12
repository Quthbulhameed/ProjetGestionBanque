import java.util.ArrayList;
import java.util.List;

public class Customer {
    // Attributs de la classe Customer
    private String nom;
    private String prenom;

    private Coordonnees coordonnees;
    private String adresse;

    private Sexe sexe;

    private Type type;


    private Bank banque;
    private List<Account> accounts;

    private List<Loan> loans; // Liste des prêts du client

    private double soldeTotal;





    // Classe imbrique coordonnes
    public static class Coordonnees {
        private String numeroTelephone;
        private String email;

        // Constructeur de la classe Coordonnees
        public Coordonnees(String numeroTelephone, String email) {
            this.numeroTelephone = numeroTelephone;
            this.email = email;
        }

        // Méthodes pour accéder aux attributs de la classe Coordonnees
        public String getNumeroTelephone() {
            return numeroTelephone;
        }
        public String getEmail() {
            return email;
        }
    }


    public enum Sexe {
        MALE, FEMALE
    }

    public enum Type {
        standard , premium
    }


    // Constructeur de la classe Customer
    public Customer(String nom, String prenom, Coordonnees coordonnees, String adresse, Sexe sexe,Type type , Bank banque, Account... accounts) {
        this.nom = nom;
        this.prenom = prenom;
        this.coordonnees = coordonnees;
        this.adresse = adresse;
        this.sexe = sexe;
        this.type=type;
        this.banque = banque;

        this.accounts = new ArrayList<>();
        for (Account account : accounts) {
            this.accounts.add(account);
            this.soldeTotal += account.getSolde();
        }
        this.loans = new ArrayList<>();
    }





    // Méthode pour obtenir le nom du client
    public String getNom() {
        return nom;
    }

    // Méthode pour modifier le nom du client
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir le prénom du client
    public String getPrenom() {
        return prenom;
    }

    // Méthode pour modifier le prénom du client
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    // Méthode pour modifier les coordonnées du client
    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    // Méthode pour obtenir l'adresse du client
    public String getAdresse() {
        return adresse;
    }


    // Méthode pour modifier l'adresse du client
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }



    // Méthode pour obtenir la banque du client
    public Bank getBanque() {
        return banque;
    }

    // Méthode pour obtenir la liste des comptes du client
    public List<Account> getAccounts() {
        return accounts;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }






    // Méthode pour obtenir le solde total des comptes du client
    public double getSoldeTotal() {
        double soldeTotal = 0;
        for (Account compte : accounts) {
            soldeTotal += compte.getSolde();
        }
        return soldeTotal;
    }

    public void demandePret(double montant, int duree, double tauxInteret) {
        loans.add(new Loan(montant, duree, tauxInteret));
        ajouteMontant(montant);
    }

    public void ajouteMontant(double montant) {
        // On ajoute le montant uniquement au premier compte de la liste
        accounts.get(0).ajouteMontant(montant);
    }






    public void remboursement(double montant) {
        if (loans.isEmpty()) {
            System.out.println("Erreur : ce client n'a pas de prêts en cours.");
            return;
        }

        // On récupère le premier prêt du client
        Loan loan = loans.get(0);

        // On effectue le remboursement sur le prêt
        loan.remboursement(montant);

        // On met à jour le solde des comptes du client en fonction du remboursement
        for (Account account : accounts) {
            if (account.getSolde() >= montant) {
                account.retireMontant(montant);
                break;
            } else {
                montant -= account.getSolde();
                account.retireMontant(account.getSolde());
            }
        }
    }







}


