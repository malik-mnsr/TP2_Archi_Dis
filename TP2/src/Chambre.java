public class Chambre {
    private int nbrChambre;
    private int nbrEtage;
    private double price;
    private int numberofBed;

    // Constructor
    public Chambre(int nbrChambre, int nbrEtage, double price, int numberofBed) {
        this.nbrChambre = nbrChambre;
        this.nbrEtage = nbrEtage;
        this.price = price;
        this.numberofBed = numberofBed;
    }

    // Getters and Setters
    public int getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public int getNbrEtage() {
        return nbrEtage;
    }

    public void setNbrEtage(int nbrEtage) {
        this.nbrEtage = nbrEtage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberofBed() {
        return numberofBed;
    }

    public void setNumberofBed(int numberofBed) {
        this.numberofBed = numberofBed;
    }

    // You could add a method to display room information
    public void displayInfo() {
        System.out.println("Room Number: " + nbrChambre);
        System.out.println("Floor: " + nbrEtage);
        System.out.println("Price: " + price);
        System.out.println("Beds: " + numberofBed);
    }
    public String toString() {
        return "Room Number: " + nbrChambre + ", Floor: " + nbrEtage + ", Price: $" + price + ", Beds: " + numberofBed;
    }
}

