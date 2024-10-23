import java.util.*;

public class Hotel {
    private String name;
    private int stars;
    private double price;
    private int numberofBeds;
    private Chambre chambre;  // Association with the Chambre class
    private Adresse adresse;  // Association with the Adresse class

    // Constructor
    public Hotel(String name, int stars, double price, int numberofBeds, Chambre chambre, Adresse adresse) {
        this.name = name;
        this.stars = stars;
        this.price = price;
        this.numberofBeds = numberofBeds;
        this.chambre = chambre;
        this.adresse = adresse;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberofBeds() {
        return numberofBeds;
    }

    public void setNumberofBeds(int numberofBeds) {
        this.numberofBeds = numberofBeds;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    // Method to display hotel and address details
    public void displayHotelInfo() {
        System.out.println("Hotel Name: " + name);
        System.out.println("Stars: " + stars);
        System.out.println("Price: " + price);
        System.out.println("Available Beds: " + numberofBeds);
        System.out.println("Address Details: ");
        adresse.displayAddress(); // Display associated address details
        System.out.println("Room Details: ");
        chambre.displayInfo(); // Display associated room (chambre) details
    }

    @Override
    public String toString() {
        return "Hotel Name: " + name +
                "\nStars: " + stars +
                "\nPrice: $" + price +
                "\nNumber of Beds: " + numberofBeds +
                "\nAddress: " + adresse.toString() +  // Assuming Adresse also has a toString method
                "\nRoom Details: " + chambre.toString();// Assuming Chambre also has a toString method);
    }
}
