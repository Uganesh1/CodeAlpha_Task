import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isAvailable;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
    }
}

class Booking {
    String guestName;
    Room room;

    Booking(String guestName, Room room) {
        this.guestName = guestName;
        this.room = room;
        this.room.isAvailable = false;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Room> rooms = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));

        while (true) {
            System.out.println("\n1. View Available Rooms\n2. Book Room\n3. View Bookings\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.println("Available Rooms:");
                    for (Room room : rooms) {
                        if (room.isAvailable)
                            System.out.printf("Room %d (%s)\n", room.roomNumber, room.type);
                    }
                    break;

                case 2:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String type = scanner.nextLine();

                    boolean booked = false;
                    for (Room room : rooms) {
                        if (room.type.equalsIgnoreCase(type) && room.isAvailable) {
                            bookings.add(new Booking(name, room));
                            System.out.println("Room booked: " + room.roomNumber);
                            booked = true;
                            break;
                        }
                    }

                    if (!booked) System.out.println("No available rooms of that type.");
                    break;

                case 3:
                    System.out.println("Bookings:");
                    for (Booking booking : bookings) {
                        System.out.printf("%s booked Room %d (%s)\n", booking.guestName, booking.room.roomNumber, booking.room.type);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the system.");
                    scanner.close();
                    return;
            }
        }
    }
}
