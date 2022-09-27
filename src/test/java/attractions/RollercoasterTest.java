package attractions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import people.Visitor;
public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(18,199,20);
        visitor2 = new Visitor(18,201,40);

        visitor3 = new Visitor(18,144,50);
        visitor4 = new Visitor(11,160,50);


    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorGetsDoublePrice(){
        assertEquals(16.80,rollerCoaster.ticketVisitor(visitor2),0.0);
    }

    @Test
    public void visitorGetsNormalPrice(){
        assertEquals(8.40, rollerCoaster.ticketVisitor(visitor1),0.0);
    }

    @Test
    public void noAdultDwarvesAllowed(){

        assertEquals(false,rollerCoaster.isAllowed(visitor3));
    }
    @Test
    public void noTallKidsAllowed(){
        assertEquals(false,rollerCoaster.isAllowed((visitor4)));
    }


}
