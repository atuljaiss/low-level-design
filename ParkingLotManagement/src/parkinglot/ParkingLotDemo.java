package parkinglot;

import vechiletype.Car;
import vechiletype.Mototcycle;
import vechiletype.Truck;
import vechiletype.Vehicle;

public class ParkingLotDemo {
	public static void main(String args[]) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new ParkingLevel(1, 100));
        parkingLot.addLevel(new ParkingLevel(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Mototcycle("M1234");

        // Park vehicles
        System.out.println(parkingLot.parkVehicle(car));
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);
//
//        // Display availability
//        parkingLot.displayAvailability();
//
//        // Unpark vehicle
//        parkingLot.unparkVehicle(motorcycle);
//
//        // Display updated availability
//        parkingLot.displayAvailability();
	}
}
