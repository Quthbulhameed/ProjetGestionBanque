import java.util.Date;

public class SavingsAccount extends Account {
    // Attribut de la classe SavingsAccount
    private double tauxInteret;

    // Constructeur de la classe SavingsAccount
    public SavingsAccount(int numero, double solde, Date dateOuverture, Bank banque, double tauxInteret) {
        super(numero, solde, dateOuverture, banque);
        this.tauxInteret = tauxInteret;
    }

    // Méthode pour obtenir le taux d'intérêt du compte
    public double getTauxInteret() {
        return tauxInteret;
    }

    // Méthode pour ajouter l'intérêt au compte
    public void addInteret() {
        double interet = getSolde() * tauxInteret / 100;
        credit(interet);
    }

    @Override
    public void debiterCompte(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
        }
        else {
            throw new IllegalArgumentException("Montant non valide");
        }
    }


}
