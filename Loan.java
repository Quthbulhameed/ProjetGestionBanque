import java.util.Date;

public class Loan {
    // Attributs de la classe Loan
    private double montant;
    private int duree;
    private double tauxInteret;
    private Date dateDemande;
    private double montantRembourse;
    private boolean estRembourse;

    // Constructeur de la classe Loan
    public Loan(double montant, int duree, double tauxInteret) {
        this.montant = montant;
        this.duree = duree;
        this.tauxInteret = tauxInteret;
        this.dateDemande = new Date();
        this.montantRembourse = 0;
        this.estRembourse = false;
    }

    // Méthode pour obtenir le montant du prêt
    public double getMontant() {
        return montant;
    }

    // Méthode pour obtenir la durée du prêt
    public int getDuree() {
        return duree;
    }

    // Méthode pour obtenir le taux d'intérêt du prêt
    public double getTauxInteret() {
        return tauxInteret;
    }

    // Méthode pour obtenir la date de demande du prêt
    public Date getDateDemande() {
        return dateDemande;
    }

    // Méthode pour obtenir le montant remboursé du prêt
    public double getMontantRembourse() {
        return montantRembourse;
    }

    // Méthode pour savoir si le prêt a été remboursé
    public boolean EstRembourse() {
        return estRembourse;
    }

    // Méthode pour effectuer un remboursement sur le prêt
    public void remboursement(double montant) {
        if (estRembourse) {
            System.out.println("Erreur : ce prêt a déjà été entièrement remboursé.");
            return;
        }

        this.montantRembourse += montant;

        if (this.montantRembourse >= this.montant) {
            this.estRembourse = true;
            System.out.println("Le prêt a été entièrement remboursé.");
        }
    }



    public void demandePret(double montant, int duree, double tauxInteret) {
        this.montant = montant;
        this.duree = duree;
        this.tauxInteret = tauxInteret;
        this.dateDemande = new Date();
        this.montantRembourse = 0;
        this.estRembourse = false;
    }

}
