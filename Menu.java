import java.util.Scanner;

public class Menu {

    private Scanner scanner;

        public Menu() {
            this.scanner = new Scanner(System.in);
}
    public void displayMainMenu() {
        while (true){
            System.out.println("Welcome to SpinTop Records E-Commerce Platform!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Please choose an option: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                /** Call register method */
                System.out.println ("Register Selected:");
                break;
                case 2:
                /** Call login method */
                System.out.println ("Login Selected:");
                break;
                case 3:
                /** Call exit method */
                System.out.println ("Exiting!");
                return;
                default:
                System.out.println ("Invalid option selected. Please try again.");

            }
           

        }
    }
}
