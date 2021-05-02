package model;

import java.util.List;
import java.util.Random;

public class RandomObject {
    private static Random random = new Random();

    public static <T>  T getRandomItem(List<T> list) {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}