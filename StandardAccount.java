import java.util.Date;

public class StandardAccount extends Account {
    private static final int PLAFOND_RETRAIT = 1000;

    public StandardAccount(int numero,double solde,Date dateOuverture,Bank banque) {
        super(numero,solde,dateOuverture,banque);
    }

    @Override
    public void retireMontant(double montant) {
        if (montant > PLAFOND_RETRAIT) {
            System.out.println("Erreur : le montant à retirer ne peut pas dépasser le plafond de retrait autorisé.");
            return;
        }
        if (montant > this.getSolde()) {
            System.out.println("Erreur : solde insuffisant.");
            return;
        }

        if (montant < 0) {
            System.out.println("Erreur : le montant à retirer doit être positif.");
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


