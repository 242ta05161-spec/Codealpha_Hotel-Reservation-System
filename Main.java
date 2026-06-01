import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n====== HOTEL RESERVATION SYSTEM ======");

            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.showRooms();
                    break;

                case 2:
                    hotel.bookRoom();
                    break;

                case 3:
                    hotel.cancelReservation();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
