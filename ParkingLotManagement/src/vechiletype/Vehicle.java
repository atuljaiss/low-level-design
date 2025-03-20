package vechiletype;

public abstract class Vehicle {
	public VehicleType vehicleType;
	public String licencePlate;
	
//	public Vehicle (VehicleType vechileType, String licencePlate ) {
//		this.licencePlate = licencePlate;
//		this.vehicleType = vehicleType;
//	}
//	
	public VehicleType getType() {
		return vehicleType;
	}
}