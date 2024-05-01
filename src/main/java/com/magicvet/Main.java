package main.java.com.magicvet;

import main.java.com.magicvet.component.ApplicationRunner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner SCANNER = new Scanner(System.in);


    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static void main(String[] args) {

        ApplicationRunner runner = new ApplicationRunner();
        runner.run();

    }

    static Client buildCient(String email) {
        Client client = new Client();
        client.email = email;
        System.out.print("First name: ");
        client.firstName = SCANNER.nextLine();
        System.out.print("Last name: ");
        client.lastName = SCANNER.nextLine();
        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}




