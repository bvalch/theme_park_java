package attractions;

import behaviours.IReviewed;
import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed, IReviewed {
    private double price;

    public Dodgems(String name, int rating) {
        super(name, rating);
        this.price = 4.50;

    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        return this.price / 2;
    }

    public double ticketVisitor(Visitor visitor) {
        if (visitor.getAge() > 14) {
            return defaultPrice();
        } else {
            return priceFor(visitor);
        }

    }

}
