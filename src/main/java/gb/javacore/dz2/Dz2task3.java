package gb.javacore.dz2;

// Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением

import java.util.Arrays;

public class Dz2task3 {
    public static void main(String[] args) {
        int[] array = {55, 12, 0, 2, 9, 0, 1, 15, 0, 0};
        System.out.println(twoZeros(array));

        int[] bigArray = fillArray(10000);
        System.out.println(fastTwoZeros(bigArray));
    }

    public static int[] fillArray(int size) {
        int[] array = new int[size];
        Arrays.fill(array, 1);
        return array;
    }

    public static boolean twoZeros(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i + 1] == 0)
                return true;
        }
        return false;
    }

    // На массиве до 10 млн элементов, метод fastTwoZeros, показал в среднем +40% производительности.
    // На массиве большей размерности он почему-то работает медленнее чем метод twoZeros.
    public static boolean fastTwoZeros(int[] array) {
        if (array.length == 2 && (array[0] == 0 && (array[1] == 0))) {
            return true;
        } else if (array.length > 2) {
            for (int i = 1; i <= array.length - 1; i += 2) {
                if (i == array.length - 1) {
                    if ((array[i] == 0 && (array[i - 1] == 0)))
                        return true;
                    else break;
                }
                if (array[i] == 0 && (array[i - 1] == 0 || array[i + 1] == 0))
                    return true;
            }
        }
        return false;
    }
}
