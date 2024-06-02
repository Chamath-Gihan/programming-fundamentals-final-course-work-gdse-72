import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String validUsername = "admin";
    static String validPassword = "1234";

    public static void main(String[] args) {
        boolean next = loginPage();

        if (next){
            options();
        }
    }

    public static void options() {

        topicRectangle("WELCOME TO IJSE STOCK MANAGEMENT SYSTEM");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Change the Credentials");
            System.out.println("2. Supplier Manage");
            System.out.println("3. Stock Manage");
            System.out.println("4. Log Out");
            System.out.println("5. Exist the system");

            System.out.print("\nEnter your choice (1-5): ");
            String choice = scanner.next();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case "1":
                    credentialManage();
                    break;
                case "2":
//                    viewProfile();
                    break;
                case "3":
//                    manageContacts();
                    break;
                case "4":
//                    sendMessage();
                    break;
                case "5":
                    System.out.println("Existing ...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    clearConsole();
                    topicRectangle("WELCOME TO IJSE STOCK MANAGEMENT SYSTEM");
            }
        }
    }

    public static void credentialManage() {
        clearConsole();
        topicRectangle("CREDENTIAL MANAGE");

        while (true) {
            System.out.print("\nPlease enter the user name to verify it's you: ");
            String name = scanner.next();

            if (Objects.equals(name, validUsername)) {
                System.out.println("\nHey " + validUsername);
                while (true) {
                    System.out.print("\nEnter your current password: ");
                    String password = scanner.next();

                    if (password.equals(validPassword)) {
                        System.out.print("Enter your new password: ");
                        validPassword = scanner.next();
                        System.out.print("\nPassword changed successfully! Do you want to go to the Home page (Y/N): ");
                        String answer = scanner.next();

                        while (!(answer.equals("Y") || answer.equals("y") || answer.equals("N") || answer.equals("n"))) {
                            System.out.print("\nPlease enter a valid value (Y/N): ");
                            answer = scanner.next();
                        }

                        if (answer.equals("Y") || answer.equals("y")) {
                            clearConsole();
                            options();
                            return;
                        } else {
                            clearConsole();
                            topicRectangle("CREDENTIAL MANAGE");
                            break;
                        }
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid username. Please try again.");
            }
        }
    }

    public static boolean loginPage(){
        topicRectangle("LOGIN PAGE");

        boolean first = true;
        boolean second = true;

        while (first) {
            System.out.print("\nEnter username: ");
            String enteredUsername = scanner.nextLine();

            if (enteredUsername.equals(validUsername)) {
                while (second){
                    System.out.print("Enter password: ");
                    String enteredPassword = scanner.nextLine();
                    if (enteredPassword.equals(validPassword)) {
                        first = false;
                        second = false;
                    } else {
                        System.out.println("\nIncorrect password. Please try again.");
                        System.out.println("\n");
                    }
                }
            } else {
                System.out.println("\nInvalid username. Please try again.");
                System.out.println("\n");
            }
        }
        clearConsole();
        return true;
    }

    public static void topicRectangle(String name) {
        int width = 120;
        int height = 3;

        int nameLength = 0;
        for (int i = 0; i < name.length(); i++) {
            nameLength++;
        }

        int nameRow = height / 2;
        int nameColumn = (width - nameLength) / 2;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("-");
                } else if (j >= nameColumn && j < nameColumn + nameLength) {
                    System.out.print(name.charAt(j - nameColumn));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
//handle the exception
            System.err.println(e.getMessage());
        }
    }
}
