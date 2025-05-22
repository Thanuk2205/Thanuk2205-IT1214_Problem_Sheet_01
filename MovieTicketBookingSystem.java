import java.util.Scanner;

public class MovieTicketBookingSystem {

    static class Ticket {
        private int ticketNumber;
        private String customerName;
        private int seatNumber;

        public Ticket(int ticketNumber, String customerName, int seatNumber) {
            this.ticketNumber = ticketNumber;
            this.customerName = customerName;
            this.seatNumber = seatNumber;
        }

        public int getTicketNumber() {
            return ticketNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

        @Override
        public String toString() {
            return "Ticket No: " + ticketNumber + ", Name: " + customerName + ", Seat: " + seatNumber;
        }
    }

    static class BookingSystem {
        private Ticket[] tickets;
        private int count;

        public BookingSystem() {
            tickets = new Ticket[10];
            count = 0;
        }

        private boolean isSeatTaken(int seatNumber) {
            for (int i = 0; i < count; i++) {
                if (tickets[i] != null && tickets[i].getSeatNumber() == seatNumber) {
                    return true;
                }
            }
            return false;
        }

        public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
            if (count >= 10) {
                System.out.println("Booking failed: All seats are booked.");
                return;
            }
            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number. Must be between 1 and 10.");
                return;
            }
            if (isSeatTaken(seatNumber)) {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return;
            }

            tickets[count] = new Ticket(ticketNumber, customerName, seatNumber);
            count++;
            System.out.println("Ticket booked successfully for " + customerName + " (Seat " + seatNumber + ")");
        }

        public void cancelTicket(int ticketNumber) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (tickets[i] != null && tickets[i].getTicketNumber() == ticketNumber) {
                    for (int j = i; j < count - 1; j++) {
                        tickets[j] = tickets[j + 1];
                    }
                    tickets[count - 1] = null;
                    count--;
                    found = true;
                    System.out.println("Ticket " + ticketNumber + " cancelled.");
                    break;
                }
            }
            if (!found) {
                System.out.println("Ticket number " + ticketNumber + " not found.");
            }
        }

        public void displayTickets() {
            System.out.println("\n--- Booked Tickets ---");
            if (count == 0) {
                System.out.println("No tickets booked.");
            } else {
                for (int i = 0; i < count; i++) {
                    System.out.println(tickets[i]);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystem system = new BookingSystem();

        while (true) {
            System.out.println("\n--- Movie Ticket Booking ---");
            System.out.println("1. Book a ticket");
            System.out.println("2. Cancel a ticket");
            System.out.println("3. Show all bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket number: ");
                    int ticketNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter seat number (1-10): ");
                    int seat = scanner.nextInt();
                    system.bookTicket(ticketNumber, name, seat);
                    break;
                case 2:
                    System.out.print("Enter ticket number to cancel: ");
                    int cancelId = scanner.nextInt();
                    system.cancelTicket(cancelId);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.println("Thank you for using the booking system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
