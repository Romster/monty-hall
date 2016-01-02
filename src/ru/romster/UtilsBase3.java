package ru.romster;

import java.util.Random;

/**
 * Методы для работы со значениями от 0 до 2(включительно)
 * Created by r0m5t3r on 1/1/16.
 */
public class UtilsBase3 {
    private static final Random random = new Random();

    public static int randomValue() {
        return random.nextInt(3);
    }

    public static int randomExcept(int exceptValue) {
        int result;
        int value = randomValue();
        if (value == exceptValue) {
            boolean left = random.nextBoolean();
            if (left) {
                if (value == 0) {
                    result = 2;
                } else {
                    result = value - 1;
                }
            } else {
                if (value == 2) {
                    result = 0;
                } else {
                    result = value + 1;
                }
            }
        } else {
            result = value;
        }
        return result;
    }
    public static int getMissingValue(int except1, int except2) {
        for(int i = 0; i < 3; i++) {
            if(i != except1 && i != except2) {
                return i;
            }
        }
        throw new IllegalStateException("This exception should never be thrown");
    }

}
