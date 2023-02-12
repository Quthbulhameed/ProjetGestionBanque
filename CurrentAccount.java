import java.util.Date;

public class CurrentAccount extends Account {
    private double decouvertAutorise;

    public CurrentAccount(int numero, double solde, Date dateOuverture, Bank banque, double decouvertAutorise) {
        super(numero, solde, dateOuverture, banque);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    @Override
    public void debiterCompte(double montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Montant non valide");
        }
        if (montant <= decouvertAutorise) {
            solde -= montant;
        } else {
            throw new IllegalArgumentException("Solde insuffisant");
        }
    }


}
