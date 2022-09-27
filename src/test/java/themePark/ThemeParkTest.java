package themePark;
import ThemePark.ThemePark;
import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;
import ThemePark.ThemePark;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    Stall candyflossstall;
    Stall icecreamstall;
    Stall tobaccostall;
    Attraction dodgems;
    Attraction park;
    Attraction playground;
    Attraction rollercoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    ThemePark themepark;
    @Before
    public void before(){
        candyflossstall = new CandyflossStall("CandyFlossStall","candyFlossJoe", ParkingSpot.A1);
        icecreamstall = new IceCreamStall("IceCreamStall","Billy",ParkingSpot.A2);
        tobaccostall = new TobaccoStall("SmokeShack","BobMarley",ParkingSpot.B2);
        dodgems = new Dodgems("Dodgeball",5);
        park = new Park("Central park",4);
        playground = new Playground("HappyPlayground",10);
        rollercoaster = new RollerCoaster("Whopeee",8);
        visitor1 = new Visitor(18,199,20);
        visitor2 = new Visitor(18,201,40);
        visitor3 = new Visitor(18,144,50);
        themepark = new ThemePark("FunPark");
        themepark.addReviewed(park);
//        themepark.addReviewed(playground);
//        themepark.addReviewed(rollercoaster);
//        themepark.addReviewed(dodgems);
//        themepark.addReviewed(candyflossstall);
//        themepark.addReviewed(icecreamstall);
//        themepark.addReviewed(tobaccostall);


    }


    @Test
    public void getAListOfReviewedObjects(){
        List<IReviewed> answer = Arrays.asList(park);
        assertEquals(answer,themepark.getIreviewedObjects());
    }

    @Test
    public void visitorCanVisitAttraction(){
        themepark.visit(visitor1,rollercoaster);
        assertEquals(1,rollercoaster.getVisitCount());
        assertEquals(rollercoaster,visitor1.getAttractionsVisited().get(0));
    }

    @Test
    public void attractionsHaveANameandReview(){
        HashMap<String,Integer> answer = new HashMap<>();
        answer.put("Central park",4);
        assertEquals(answer,themepark.getAllReviews());
    }

    @Test
    public void returnAttractionsThatAllowThisVisitor(){
        List<IReviewed> answer = Arrays.asList(rollercoaster,tobaccostall);
        themepark.addReviewed(rollercoaster);
        themepark.addReviewed(dodgems);
        themepark.addReviewed(tobaccostall);
        assertEquals(answer,themepark.getAllAllowedFor(visitor1));
    }


}
