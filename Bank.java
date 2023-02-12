import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Attributs de la classe Bank
    private String nom;
    private String adresse;
    private ArrayList<Account> comptes; // Liste des comptes de la banque
    private ArrayList<Customer> clients; // Liste des clients de la banque

    // Constructeur de la classe Bank
    public Bank(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        comptes = new ArrayList<Account>();
        clients = new ArrayList<Customer>();
    }

    // Getters et setters de la classe Bank
    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public String getadress() {
        return adresse;
    }

    public void setAddress(String address) {
        this.adresse = address;
    }




    // Méthode pour ajouter un client à la banque
    public void ajouterClient(Customer client) {
        clients.add(client);
    }

    // Méthode pour Supprimer un client à la banque

    public void supprimerClient(Customer client) {
        if (clients.contains(client)) {
            clients.remove(client);
        } else {
            System.out.println("Erreur : ce client n'est pas inscrit dans cette banque.");
        }
    }


    // Méthode pour voir nombre client qui sont inscrit a la banque
    public int getNombreClients() {
        return clients.size();
    }




    // Méthode pour obtenir la liste des comptes de la banque
    public ArrayList<Account> getComptes() {
        return comptes;
    }

    // Méthode pour obtenir la liste des clients de la banque
    public ArrayList<Customer> getClients() {
        return clients;
    }


    // Méthode pour afficher les Pret En Cours

        public void afficherPretEnCours () {
            for (Customer customer : clients) {
                List<Loan> loans = customer.getLoans();
                for (Loan loan : loans) {
                    if (!loan.EstRembourse()) {
                        System.out.println("" +customer.getNom() + " " + customer.getPrenom() + " fait la demande du pret avec le montant " +" : " + loan.getMontant() + "e");
                    }
                }
            }
        }




    }
