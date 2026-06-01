class Room {

    int roomNumber;
    String category;
    double price;
    boolean isBooked;

    public Room(int roomNumber, String category, double price) {

        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
    }

    public void displayRoom() {

        System.out.println(
            "Room No: " + roomNumber +
            " | Category: " + category +
            " | Price: ₹" + price +
            " | Available: " + (!isBooked)
        );
    }
}
