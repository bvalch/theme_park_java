package ThemePark;

import behaviours.IReviewed;

import java.util.ArrayList;
import java.util.HashMap;


import attractions.Attraction;
import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class ThemePark {


    private ArrayList<IReviewed> reviewed;
    private String name;

    public ThemePark(String name) {
        this.name = name;
        this.reviewed = new ArrayList<>();
    }

    public void addReviewed(IReviewed reviewed) {
        this.reviewed.add(reviewed);
    }

    public int getAttractionsCount() {
        return this.reviewed.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<IReviewed> getIreviewedObjects() {
        ArrayList<IReviewed> answer = new ArrayList<>();

        for (int i = 0; i < this.reviewed.size(); i++) {
            answer.add(reviewed.get(i));
        }
        return answer;

    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addAttractionsToVisitedArray(attraction);
        attraction.incrementVisitCount();


    }

    public HashMap<String, Integer> getAllReviews() {
        HashMap<String, Integer> answerHashMap = new HashMap<>();
        for (int i = 0; i < this.reviewed.size(); i++) {
            answerHashMap.put(reviewed.get(i).getName(), reviewed.get(i).getRating());
        }
        return answerHashMap;
    }


    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> answerArr = new ArrayList<>();

        for (int i = 0; i < this.reviewed.size(); i++) {


            if (this.reviewed.get(i) instanceof ISecurity) {
                if (((ISecurity) reviewed.get(i)).isAllowed(visitor)) {
                    answerArr.add(reviewed.get(i));
                }
                ;

            }
        }

        return answerArr;
    }


}
