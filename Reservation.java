public class Reservation {

    String customerName;
    int roomNumber;
    String category;
    double amount;

    public Reservation(String customerName,
                       int roomNumber,
                       String category,
                       double amount) {

        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.amount = amount;
    }

    public void displayReservation() {

        System.out.println("\n===== BOOKING DETAILS =====");

        System.out.println("Customer Name : " + customerName);
        System.out.println("Room Number   : " + roomNumber);
        System.out.println("Room Category : " + category);
        System.out.println("Amount Paid   : ₹" + amount);

        System.out.println("===========================\n");
    }
}
