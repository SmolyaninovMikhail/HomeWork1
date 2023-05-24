public class hw1 {
    final static int MIN = 0;
    final static int MAX = 2000;

    public static void main(String[] args) {
        
        int i = getRandomNumber(MIN, MAX);
        System.out.println("Случайное целое число в диапазоне от " + MIN + " до " + MAX + " = " + i);
        
        int n = high_bit_line(i);
        System.out.println("Номер старшего значащего бита выпавшего числа: " + n);
                
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
   
}
