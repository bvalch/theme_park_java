package attractions;

import behaviours.IReviewed;
import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ITicketed, ISecurity {
    private double price;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.price = 8.40;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        return this.price * 2;
    }

    public boolean isAllowed(Visitor visitor) {
        boolean answer = false;

        if (visitor.getHeight() > 145 && visitor.getAge() > 12) {
            answer = true;
        } else if (visitor.getHeight() < 145 || visitor.getAge() < 12) {
            answer = false;
        }
        return answer;
    }

    public double ticketVisitor(Visitor visitor) {
        if (visitor.getHeight() < 200 && isAllowed(visitor)) {
            return defaultPrice();
        } else {
            return priceFor(visitor);
        }

    }
}
