import javax.swing.*;
import java.util.Date;

public class Reservation {
    private Date arrivalDate;
    private Date departureDate;
    private String numberofPersons;
    private double totalPrice;
    private Hotel hotel;  // Association with the Hotel class
    private Client client; // Association with the Client class

    // Constructor
    public Reservation(Date arrivalDate, Date departureDate, String numberofPersons, double totalPrice, Hotel hotel, Client client) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberofPersons = numberofPersons;
        this.totalPrice = totalPrice;
        this.hotel = hotel;
        this.client = client;
    }

    // Getters and Setters
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getNumberofPersons() {
        return numberofPersons;
    }

    public void setNumberofPersons(String numberofPersons) {
        this.numberofPersons = numberofPersons;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Method to display reservation details
    public void displayReservationInfo() {
        System.out.println("Arrival Date: " + arrivalDate);
        System.out.println("Departure Date: " + departureDate);
        System.out.println("Number of Persons: " + numberofPersons);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Hotel Information: ");
        hotel.displayHotelInfo();
        System.out.println("Client Information: ");
        client.displayClientInfo();
    }
    public void showConfirmation(Reservation reservation) {
        String message = "Booking Confirmed!\n" +
                "Hotel: " + reservation.getHotel().getName() + "\n" +
                "Arrival Date: " + reservation.getArrivalDate() + "\n" +
                "Departure Date: " + reservation.getDepartureDate() + "\n" +
                "Number of Persons: " + reservation.getNumberofPersons() + "\n" +
                "Total Price: " + reservation.getTotalPrice();

        JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
}
