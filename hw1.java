import java.util.Arrays;
import java.util.stream.Collectors;

public class HomeWork1 {
    final static int MIN = 0;
    final static int MAX = 2000;

    public static void main(String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int i = getRandomNumber(MIN, MAX);
        System.out.println("Случайное целое число в диапазоне от " + MIN + " до " + MAX + " = " + i);

        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = high_bit_line(i);
        System.out.println("Номер старшего значащего бита выпавшего числа: " + n);

        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int[] m1 = multipleArray(i, n, Short.MAX_VALUE);
        System.out.println("Массив m1 из " + m1.length + " элементов: " + Arrays.stream(m1).mapToObj(String::valueOf).collect(Collectors.joining(", ")));


        // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] m2 = notMultipleArray(i, n, Short.MIN_VALUE);
        System.out.println("Массив m2 из " + m2.length + " элементов: " + Arrays.stream(m2).mapToObj(String::valueOf).collect(Collectors.joining(", ")));

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min + 2)) + min - 1);

    }

    public static int high_bit_line(int n) {
        int res = 0;
        while (n != 1) {
            n >>= 1;
            res++;
        }
        return res;
    }

    public static int[] multipleArray(int i, int n, int limit) {
        int arr_len = 0;
        for (int j = i; j <= limit; j++) {
            if (j % n == 0)
                arr_len++;
        }

        int[] res = new int[arr_len];
        for (int j = i, k = 0; j <= limit; j++) {
            if (j % n == 0) {
                res[k] = j;
                k++;
            }
        }
        return res;
    }

    public static int[] notMultipleArray(int i, int n, int limit) {
        int arr_len = 0;
        for (int j = limit; j <= i; j++) {
            if (j % n != 0)
                arr_len++;
        }

        int[] res = new int[arr_len];
        for (int j = limit, k = 0; j <= i; j++) {
            if (j % n != 0) {
                res[k] = j;
                k++;
            }
        }
        return res;
    }
}
