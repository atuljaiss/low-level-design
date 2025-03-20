package parkinglot;

import java.util.List;
import java.util.*;

import vechiletype.Vehicle;
import vechiletype.VehicleType;

public class ParkingLevel {
	private int floorNumber;
	private List<ParkingSpot> parkingSpots;
	
	public ParkingLevel(int floorNumber, int totalSpots) {
		this.floorNumber = floorNumber;
		this.parkingSpots = new ArrayList<>();
		
		// Allocate space for each type;
		int carSpots =  (int) (totalSpots * 0.6);
		int bikesSpots =  (int) (totalSpots * 0.2);
		int truckSpots = (int) (totalSpots * 0.1);
		
		int spotNumber = 1;
		spotNumber = addSpots(carSpots, VehicleType.CAR, spotNumber);
		spotNumber = addSpots(carSpots, VehicleType.MOTORCYCLE, spotNumber);
		addSpots(carSpots, VehicleType.TRUCK, spotNumber);
	}

	private int addSpots(int count, VehicleType type, int spotNumber) {
		for(int i = 0; i < count; i++) {
			parkingSpots.add(new ParkingSpot(type, spotNumber++));
		} 
		return spotNumber;
		
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floorNumber + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }
}
