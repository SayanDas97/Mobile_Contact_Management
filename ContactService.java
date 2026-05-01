import java.util.Scanner;

public class ContactService {

    Scanner sc = new Scanner(System.in);
    ContactDAO dao = new ContactDAO();

    public void menu() {

        while (true) {

            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    dao.addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    dao.searchContact(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    dao.deleteContact(sc.nextLine());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
