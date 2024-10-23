import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationForm extends JFrame {
    private JTextField cityField;
    private JTextField priceRangeField;
    private JComboBox<String> starsComboBox;
    private JTextField numberOfPersonsField;
    private JTextField arrivalDateField;
    private JTextField departureDateField;
    private JButton searchButton;
    private JTextArea hotelListArea;

    // Client details fields
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField creditCardField;
    private JButton reserveButton;

    // Sample list of hotels
    private List<Hotel> hotelList = new ArrayList<>();
    private Hotel selectedHotel;

    public HotelReservationForm() {
        setTitle("Hotel Reservation Form");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        // Initialize components
        cityField = new JTextField();
        priceRangeField = new JTextField();
        String[] starOptions = {"1", "2", "3", "4", "5"};
        starsComboBox = new JComboBox<>(starOptions);
        numberOfPersonsField = new JTextField();
        arrivalDateField = new JTextField("YYYY-MM-DD");
        departureDateField = new JTextField("YYYY-MM-DD");

        searchButton = new JButton("Search Hotels");
        hotelListArea = new JTextArea();
        hotelListArea.setEditable(false);

        // Client details input fields
        lastNameField = new JTextField();
        firstNameField = new JTextField();
        creditCardField = new JTextField();
        reserveButton = new JButton("Reserve Hotel");

        // Add components to the frame
        add(new JLabel("City of Stay:"));
        add(cityField);
        add(new JLabel("Desired Price Range:"));
        add(priceRangeField);
        add(new JLabel("Hotel Stars:"));
        add(starsComboBox);
        add(new JLabel("Number of Persons:"));
        add(numberOfPersonsField);
        add(new JLabel("Arrival Date:"));
        add(arrivalDateField);
        add(new JLabel("Departure Date:"));
        add(departureDateField);
        add(searchButton);

        // Add hotel list area
        add(new JLabel("Available Hotels:"));
        add(new JScrollPane(hotelListArea)); // Use JScrollPane for scrollable JTextArea

        // Add client details for reservation
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Credit Card Number:"));
        add(creditCardField);
        add(reserveButton);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllHotels(); // Show all hotels when the button is pressed
            }
        });

        // Add action listener for the reserve button
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeReservation(); // Handle reservation
            }
        });

        // Initialize some sample hotels
        initializeHotels();

        setVisible(true);
    }

    private void initializeHotels() {
        // Create sample Chambre instances
        Chambre chambreA = new Chambre(1, 1, 100.0, 2); // Example values
        Chambre chambreB = new Chambre(2, 1, 150.0, 3);
        Chambre chambreC = new Chambre(3, 2, 200.0, 4);

        // Add sample hotels to the list
        hotelList.add(new Hotel("Hotel A", 4, 100.0, 2, chambreA, new Adresse("France", "Paris", "Rue de Paris", "Place de la République", "48.8566° N, 2.3522° E", 1)));
        hotelList.add(new Hotel("Hotel B", 3, 150.0, 3, chambreB, new Adresse("France", "Lyon", "Rue de Lyon", "Place Bellecour", "45.7640° N, 4.8357° E", 2)));
        hotelList.add(new Hotel("Hotel C", 5, 200.0, 4, chambreC, new Adresse("France", "Marseille", "Rue de Marseille", "Vieux Port", "43.2965° N, 5.3698° E", 3)));
    }

    private void displayAllHotels() {
        hotelListArea.setText(""); // Clear the text area before displaying hotels
        if (hotelList.isEmpty()) {
            hotelListArea.append("No hotels available.\n");
            return;
        }
        for (Hotel hotel : hotelList) {
            String hotelInfo = formatHotelInfo(hotel);
            hotelListArea.append(hotelInfo + "\n\n"); // Append each hotel's info
        }

        // Select the first hotel in the list as an example (you can add selection logic later)
        selectedHotel = hotelList.get(0);
    }

    private String formatHotelInfo(Hotel hotel) {
        String address = String.format("%s, %s, %s %d, %s (%s)",
                hotel.getAdresse().getPays(),
                hotel.getAdresse().getVille(),
                hotel.getAdresse().getRue(),
                hotel.getAdresse().getNumero(),
                hotel.getAdresse().getLieuDit(),
                hotel.getAdresse().getPositionGPS()
        );

        return String.format("Name: %s\nAddress: %s\nPrice: %.2f\nStars: %d\nBeds: %d",
                hotel.getName(),
                address,
                hotel.getPrice(),
                hotel.getStars(),
                hotel.getNumberofBeds()
        );
    }


    private void makeReservation() {
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String creditCard = creditCardField.getText();
        String arrivalDate = arrivalDateField.getText();
        String departureDate = departureDateField.getText();
        String numberOfPersons = numberOfPersonsField.getText();

        if (selectedHotel != null) {
            // Calculate the total price based on the hotel's price and number of persons
            double totalPrice = selectedHotel.getPrice() * Integer.parseInt(numberOfPersons);

            // Create the confirmation message
            String confirmationMessage = String.format(
                    "Reservation Confirmed!\n" +
                            "Hotel: %s\n" +
                            "Arrival Date: %s\n" +
                            "Departure Date: %s\n" +
                            "Number of Persons: %s\n" +
                            "Total Price: %.2f\n" +
                            "Client: %s %s\n" +
                            "Credit Card: %s",
                    selectedHotel.getName(),
                    arrivalDate,
                    departureDate,
                    numberOfPersons,
                    totalPrice,
                    firstName,
                    lastName,
                    creditCard
            );

            // Display confirmation dialog in GUI
            JOptionPane.showMessageDialog(this, confirmationMessage);

            // Print confirmation to console
            System.out.println(confirmationMessage);

            // Store reservation details in a file
            saveReservationToFile(confirmationMessage);
        }
    }

    private void saveReservationToFile(String reservationDetails) {
        // Define the directory and file path
        String directoryPath = "reservations";
        String filePath = directoryPath + "/reservations.txt";

        // Create the directory if it doesn't exist
        java.io.File directory = new java.io.File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory
        }

        // Now write to the file
        System.out.println("Saving reservation to file...");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(reservationDetails);
            writer.newLine();
            writer.write("-----------------------------------------------------");
            writer.newLine();
            writer.flush();  // Ensure data is written to the file
            System.out.println("Reservation saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new HotelReservationForm();
    }
}
