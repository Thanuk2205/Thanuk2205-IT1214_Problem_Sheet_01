public class ParkingLotTracker {

    static class Vehicle {
        private String licensePlate;
        private String ownerName;
        private int hoursParked;

        public Vehicle(String licensePlate, String ownerName, int hoursParked) {
            this.licensePlate = licensePlate;
            this.ownerName = ownerName;
            this.hoursParked = hoursParked;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public int getHoursParked() {
            return hoursParked;
        }

        public void setHoursParked(int hoursParked) {
            this.hoursParked = hoursParked;
        }

        public void displayInfo() {
            System.out.println("License Plate: " + licensePlate + ", Owner: " + ownerName + ", Hours Parked: " + hoursParked);
        }
    }

    // ParkingLot class
    static class ParkingLot {
        private Vehicle[] vehicles;
        private int count;

        public ParkingLot() {
            vehicles = new Vehicle[5];
            count = 0;
        }

        public void parkVehicle(Vehicle v) {
            if (count < vehicles.length) {
                vehicles[count] = v;
                count++;
                System.out.println("Vehicle parked: " + v.getLicensePlate());
            } else {
                System.out.println("Parking lot is full!");
            }
        }

        public void removeVehicle(String licensePlate) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (vehicles[i].getLicensePlate().equalsIgnoreCase(licensePlate)) {
                    System.out.println("Removing vehicle: " + vehicles[i].getLicensePlate());
                    for (int j = i; j < count - 1; j++) {
                        vehicles[j] = vehicles[j + 1];
                    }
                    vehicles[count - 1] = null;
                    count--;
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Vehicle with license " + licensePlate + " not found.");
            }
        }

        public void displayVehicles() {
            if (count == 0) {
                System.out.println("No vehicles parked.");
            } else {
                System.out.println("Parked Vehicles:");
                for (int i = 0; i < count; i++) {
                    vehicles[i].displayInfo();
                }
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle v1 = new Vehicle("ABC123", "John Doe", 2);
        Vehicle v2 = new Vehicle("XYZ789", "Jane Smith", 4);
        Vehicle v3 = new Vehicle("LMN456", "Bob Brown", 1);

        lot.parkVehicle(v1);
        lot.parkVehicle(v2);
        lot.parkVehicle(v3);

        lot.removeVehicle("XYZ789");

        lot.displayVehicles();
    }
}
