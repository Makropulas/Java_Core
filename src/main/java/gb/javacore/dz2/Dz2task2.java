package gb.javacore.dz2;

// Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.


public class Dz2task2 {
    public static void main(String[] args) {
        int[] arr = {55, 12, 22, 2, 9, 0, 1, 15, 32};
        System.out.println(diffBetweenMaxAndMin(arr));
    }

    public static int diffBetweenMaxAndMin(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        return max - min;
    }
}
