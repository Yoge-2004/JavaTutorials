public class NeonNumber {
    public static boolean isNeon(int number) {
        int squaredNumber = number * number;
        
        int sum = 0;
        while (squaredNumber > 0) {
            sum += (squaredNumber % 10);
            squaredNumber /= 10;
        }
        
        return sum == number;
    }
}
