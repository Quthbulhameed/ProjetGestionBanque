import java.util.Date;

public class PremiumAccount extends Account {
    private static final int DECOUVERT_MAXIMAL_AUTORISE = 3000;

    public PremiumAccount(int numero, double solde, Date dateOuverture, Bank banque) {
        super(numero,solde,dateOuverture,banque);
    }

    @Override
    public void retireMontant(double montant) {
        if (montant < 0) {
            System.out.println("Erreur : le montant à retirer doit être positif.");
            return;
        }
        if (this.getSolde() - montant < -DECOUVERT_MAXIMAL_AUTORISE) {
            System.out.println("Erreur : le découvert maximal autorisé ne doit pas être dépassé.");
            return;
        }
        this.ajouteMontant(-montant);
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

    @Override
    public void credit(double montant) {
        if (montant > 0) {
            solde += montant;
        }

        else {
            throw new IllegalArgumentException("Montant non valide");
        }
    }


    @Override
    public void ajouteMontant(double montant) {
        this.solde += montant;
    }



}