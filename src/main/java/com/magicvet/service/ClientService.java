package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Optional<Client> registerNewClient() {
        Client client = null;
        System.out.println("Please, provide the client's details");
        System.out.print("E-mail: ");
        String email = Main.SCANNER.nextLine();
        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName()
                    + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Provided e-mail is invalid.");
        }
        return Optional.ofNullable(client);
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        System.out.print("First name: ");
        client.setFirstName(Main.SCANNER.nextLine());
        System.out.print("Last name: ");
        client.setLastName(Main.SCANNER.nextLine());
        System.out.println("Location (Kyiv, Lviv, Odesa or other): ");
        Client.Location location;
        String locationInput = Main.SCANNER.nextLine().toUpperCase();
        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput +
                    "'. Using default value: " + Client.Location.UNKNOWN);
        }
        client.setLocation(location);
        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}