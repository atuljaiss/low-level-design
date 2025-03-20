package parkinglot;

import java.util.ArrayList;
import java.util.List;

import vechiletype.Vehicle;

public class ParkingLot {
	private List<ParkingLevel> parkingLevels;
	private static ParkingLot instance;
	
	private ParkingLot() {
		parkingLevels = new ArrayList<>();
	}
	
	 public static synchronized ParkingLot getInstance() {
	        if (instance == null) {
	            instance = new ParkingLot();
	        }
	        return instance;
	    }
	 
	 public void addLevel(ParkingLevel level) {
	        parkingLevels.add(level);
	    }
	
	public boolean parkVehicle(Vehicle vehicle) {
		for(ParkingLevel level : parkingLevels) {
			if(level.parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	  public boolean unparkVehicle(Vehicle vehicle) {
	        for (ParkingLevel level : parkingLevels) {
	            if (level.unparkVehicle(vehicle)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void displayAvailability() {
	        for (ParkingLevel level : parkingLevels) {
	            level.displayAvailability();
	        }
	    }
	
	
	
}
