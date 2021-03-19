package assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> positiveAsteroids = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                positiveAsteroids.add(asteroids[i]);
            } else {
                boolean negativeAsteroidExplode = false;
                while (!positiveAsteroids.isEmpty()) {
                    if (positiveAsteroids.peek() < -asteroids[i]) {
                        positiveAsteroids.pop();
                    } else if (positiveAsteroids.peek() == -asteroids[i]) {
                        positiveAsteroids.pop();
                        negativeAsteroidExplode = true;
                        break;
                    } else {
                        negativeAsteroidExplode = true;
                        break;
                    }
                }

                if (!negativeAsteroidExplode) {
                    res.add(asteroids[i]);
                }

            }
        }

        int[] finalRes = new int[res.size() + positiveAsteroids.size()];

        for (int i = 0; i <res.size(); i++) {
            finalRes[i] = res.get(i);
        }

        for (int i = positiveAsteroids.size() - 1; i >= 0; i--) {
            finalRes[res.size() + i] = positiveAsteroids.pop();
        }

        return finalRes;
    }

}
