package example;

import java.util.List;

public class Rating {

    public static Integer average(List<Integer> ratings) {
        if (ratings.size() == 0) {
            return null;
        }
        int sum = 0;
        for (int rating: ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

}
