import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Hotel() {

        // Standard Rooms
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));

        // Deluxe Rooms
        rooms.add(new Room(201, "Deluxe", 3000));
        rooms.add(new Room(202, "Deluxe", 3000));

        // Suite Rooms
        rooms.add(new Room(301, "Suite", 5000));
        rooms.add(new Room(302, "Suite", 5000));
    }

    // Display available rooms
    public void showRooms() {

        System.out.println("\n===== AVAILABLE ROOMS =====");

        for (Room room : rooms) {

            if (!room.isBooked) {
                room.displayRoom();
            }
        }

        System.out.println("===========================\n");
    }

    // Book Room
    public void bookRoom() {

        showRooms();

        System.out.print("Enter Room Number to Book: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo && !room.isBooked) {

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                // Payment Simulation
                System.out.println("Room Price: ₹" + room.price);
                System.out.print("Confirm Payment? (yes/no): ");

                String payment = sc.nextLine();

                if (payment.equalsIgnoreCase("yes")) {

                    room.isBooked = true;

                    Reservation reservation =
                        new Reservation(
                            name,
                            room.roomNumber,
                            room.category,
                            room.price
                        );

                    reservations.add(reservation);

                    saveBookingToFile(reservation);

                    System.out.println("\nBooking Successful!");

                    reservation.displayReservation();

                } else {

                    System.out.println("Payment Failed.");
                }

                return;
            }
        }

        System.out.println("Room not available.");
    }

    // Cancel Booking
    public void cancelReservation() {

        System.out.print("Enter Room Number to Cancel: ");

        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo && room.isBooked) {

                room.isBooked = false;

                System.out.println("Reservation Cancelled.");

                return;
            }
        }

        System.out.println("No reservation found.");
    }

    // Save booking to file
    public void saveBookingToFile(Reservation reservation) {

        try {

            FileWriter fw = new FileWriter("bookings.txt", true);

            fw.write(
                reservation.customerName + ", " +
                reservation.roomNumber + ", " +
                reservation.category + ", " +
                reservation.amount + "\n"
            );

            fw.close();

        } catch (IOException e) {

            System.out.println("Error saving booking.");
        }
    }
}
