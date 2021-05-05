package ObjectOrientedDesign;
import java.util.ArrayList;

/**
 * Design a parking lot using object-oriented principles.
 * ASSUMPTIONS:
 * parking lot has multiple levels. Each level has multiple rows of spots
 * parking lot can park motorcycles, car and buses
 * parking lot has motorcycles spots, compact spots, and large spots
 * a motorcycle can park in any spot
 * car can park in either a single compact spot or a single large spot
 * bus can park in five large spots that are consecutive and within the same row .it cannot park in small spots.


// wrapper class for an array of Levels.
public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot(){...}
    // park vehicle in a spot or multiple spots. return false if failed
    public boolean parkVehicle(Vehicle vehicle){...}
}

enum VehicleSize{Motorcycle, Compact, Large}

abstract class Vehicle{
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded(){return spotsNeeded;}
    public VehicleSize getSize(){return size;}

    // park vehicle in this spot
    public void ParkInSpot(ParkingSpot s){parkingSpots.add(s);}
    // remove car from spot, and notify that it's gone
    public void clearSpots(){...}
    //checks if spot is big enough for vehicle and is available.
    public abstract boolean canFitInSpot(ParkingSpot spot);
}
class Bus extends Vehicle{
    public Bus(){
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
    // checks if the spot is large. Doesn't check num of spots
    public boolean canFitInSpot(ParkingSpot spot){...}
}
class Car extends Vehicle{
    public Car(){
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    public boolean canFitInSpot(ParkingSpot spot){...}
}
class Motorcycle extends Vehicle{
    public Motorcycle(){
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    public boolean canFitInSpot(ParkingSpot spot){...}
}

class ParkingSpot{
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize s){...}
    public boolean isAvailable(){return vehicle == null;}

    public boolean canFitVehicle(Vehicle vehicle){...}
    public boolean park(Vehicle v){...}
    public int getRow(){return row;}
    public int getSpotNumber(){return spotNumber;}
    public void removeVehicle(){...}
}

// represents a level in a parking garage
class Level{
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots =0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots){...}
    public int availableSpots(){return availableSpots;}
    // find a place to park this vehicle. return false if failed
    public boolean parkVehicle(Vehicle vehicle){...}
    private boolean parkStartingAtSpot(int num, Vehicle v){...}
    private int findAvailableSpots(Vehicle vehicle){...}
    public void spotFreed(){availableSpots++}
}
 */