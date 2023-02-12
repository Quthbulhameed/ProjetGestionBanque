import java.util.Date;

public abstract class Account {
    // Attributs de la classe Account
    private int numero;
     double solde;
    private Date dateOuverture;
    private Bank banque;


    // Constructeur de la classe Account
    public Account(int numero, double solde, Date dateOuverture, Bank banque) {
        this.numero = numero;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
        this.banque = banque;
    }

    // Méthode pour obtenir le numéro de compte
    public int getNumero() {
        return numero;
    }

    // Méthode pour obtenir le solde du compte
    public double getSolde() {
        return solde;
    }

    // Méthode pour obtenir la date d'ouverture du compte
    public Date getDateOuverture() {
        return dateOuverture;
    }

    // Méthode pour obtenir la banque du compte
    public Bank getBanque() {
        return banque;
    }



    // Méthode pour débiter le compte
    public void debiterCompte(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
        }


        else {
            throw new IllegalArgumentException("Montant non valide");
        }
    }

    // Méthode pour créditer le compte
    public void credit(double montant) {
        if (montant > 0) {
            solde += montant;
        }

        else {
            throw new IllegalArgumentException("Montant non valide");
        }
    }

    public void ajouteMontant(double montant) {
        this.solde += montant;
    }

    public void retireMontant(double montant) {
        if (montant < 0) {
            System.out.println("Erreur : le montant à retirer doit être positif.");
            return;
        }

        if (this.solde - montant < 0) {
            System.out.println("Erreur : le solde ne peut pas être négatif.");
            return;
        }

        this.solde -= montant;
    }
}
