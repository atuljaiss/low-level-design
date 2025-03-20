```markdown
# Parking Lot System

## Overview

The Parking Lot System is designed to manage parking spots in a multi-level parking facility. It supports multiple types of vehicles such as cars, motorcycles, and trucks, and efficiently handles the allocation and release of parking spots. The system provides real-time availability updates, handles multiple entry and exit points, and supports concurrent access for customers.

## Features

- **Multiple Levels:** The parking lot consists of multiple levels, each with a set number of parking spots.
- **Vehicle Types:** The system supports various vehicle types, including:
  - Cars
  - Motorcycles
  - Trucks
- **Parking Spot Allocation:** Each parking spot is designated to accommodate a specific type of vehicle.
- **Real-time Availability:** The system tracks the availability of parking spots and provides real-time data to users.
- **Concurrent Access:** Multiple entry and exit points are supported, with the system handling concurrent operations.

## System Requirements

- **Vehicle Types Handling:** Vehicles should be classified into types such as car, motorcycle, and truck.
- **Parking Spots Management:** Each parking spot should have a maximum size and should be able to handle specific vehicle types:
  - Cars should be allocated to car-sized spots.
  - Motorcycles should be allocated to motorcycle-sized spots.
  - Trucks should be allocated to larger truck-sized spots.
- **Parking Spot Assignment:** When a vehicle enters, it should be assigned the closest available parking spot based on its type.
- **Parking Spot Release:** When a vehicle exits, its parking spot should be released, and the spot should be marked as available again.
- **Multiple Entry and Exit Points:** The system should support concurrent parking operations through multiple entry and exit points.
- **Real-time Updates:** The parking lot should provide real-time availability information, so users can check the availability of spots before entering.

## Classes and Methods

### 1. **ParkingLot**

- Represents the parking lot with multiple levels and parking spots.

#### Methods:

- `addLevel(level: ParkingLevel)`
- `getAvailableSpots(vehicleType: VehicleType)`: Returns the available parking spots for a specific vehicle type.
- `getTotalAvailableSpots()`: Returns the total number of available parking spots across all levels.

### 2. **ParkingLevel**

- Represents a specific level in the parking lot, containing multiple parking spots.

#### Methods:

- `addSpot(spot: ParkingSpot)`
- `getAvailableSpot(vehicleType: VehicleType)`: Returns the available spot for the given vehicle type.

### 3. **ParkingSpot**

- Represents a specific parking spot in the parking lot.

#### Methods:

- `isAvailable()`: Returns if the spot is available or not.
- `assignVehicle(vehicle: Vehicle)`: Assigns a vehicle to the parking spot.
- `releaseSpot()`: Releases the parking spot when the vehicle exits.

### 4. **Vehicle**

- Represents a vehicle entering or exiting the parking lot.

#### Methods:

- `getType()`: Returns the vehicle type (Car, Motorcycle, Truck).

### 5. **VehicleType**

- Enum representing different vehicle types.

#### Values:

- `CAR`
- `MOTORCYCLE`
- `TRUCK`

## Concurrency Considerations

- **Multiple Entry/Exit Points:** The system should be thread-safe and handle concurrent entry and exit requests.
- **Synchronization:** Access to parking spots should be synchronized to avoid race conditions, especially when a spot is being assigned or released.

## Example Usage
```

### 1. **Initialize Parking Lot**

```java
ParkingLot parkingLot = new ParkingLot();
ParkingLevel level1 = new ParkingLevel(10);
ParkingLevel level2 = new ParkingLevel(15);

parkingLot.addLevel(level1);
parkingLot.addLevel(level2);
```

### 2. **Add Parking Spots**

```java
ParkingSpot spot1 = new ParkingSpot(VehicleType.CAR);
ParkingSpot spot2 = new ParkingSpot(VehicleType.MOTORCYCLE);

level1.addSpot(spot1);
level1.addSpot(spot2);
```

### 3. **Assign Vehicle**

```java
Vehicle car = new Vehicle(VehicleType.CAR);
ParkingSpot assignedSpot = parkingLot.getAvailableSpots(VehicleType.CAR);
assignedSpot.assignVehicle(car);
```

### 4. **Release Parking Spot**

```java
assignedSpot.releaseSpot();
```

## Real-Time Availability

The system continuously tracks and updates the availability of parking spots in real time. Customers can query the available parking spots before entering the parking lot to ensure the availability of their preferred spot.

## Conclusion

This Parking Lot System is a robust solution to manage parking spaces in a multi-level parking facility. It supports concurrent access, real-time availability tracking, and effective management of different vehicle types and parking spots.
