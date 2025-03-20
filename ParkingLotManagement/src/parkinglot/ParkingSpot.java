package parkinglot;

import vechiletype.Vehicle;
import vechiletype.VehicleType;

public class ParkingSpot {
	private VehicleType spotType;
	private boolean isOccupied;
	private Vehicle currentVehicle;
	private int spotNumber;
	
	public ParkingSpot(VehicleType spotType, int spotNumber) {
		this.spotType = spotType;
		this.spotNumber = spotNumber;
		isOccupied = false;
	}
	

	public boolean parkVehicle(Vehicle vehicle) {
		if(vehicle.vehicleType == this.spotType && isAvailable()) {
			this.currentVehicle = vehicle;
			this.isOccupied = true;
			return true;
		}
		return false;
	}
	
	
	
	public void unparkVehicle() {
		this.currentVehicle = null;
		this.isOccupied=false;
	}
	
	public boolean isAvailable() {
		return !isOccupied;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}


	public VehicleType getVehicleType() {
		return spotType;
	}


	public Vehicle getParkedVehicle() {
		return currentVehicle;
	}
	
}
