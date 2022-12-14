package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {
    private int rating;


    public TobaccoStall(String name, String ownerName, ParkingSpot parkingSpot) {
        super(name, ownerName, parkingSpot);
        this.rating = rating;
    }

    public boolean isAllowed(Visitor visitor) {
        if (visitor.getAge() >= 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getRating() {
        return rating;
    }
}
