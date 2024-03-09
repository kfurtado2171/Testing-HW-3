import java.math.BigDecimal;
import java.math.RoundingMode;

public class SumOfSquares {
    public static void main(String[] args) {
    }

    // Function taking a double array as input and returning the sum of its squares
    public static String calcSumOfSquares(double[] arr){
        double sumOfSquares = 0.0;

        // If arr does not have at least one element --> throw invalid array size exception
        if(arr.length < 1){
            throw new IllegalArgumentException("Invalid array size: <1");
        }

        // Calculate the sum of the squares of each element in arr
        for(int i = 0; i < arr.length; i++){
            sumOfSquares += Math.pow(arr[i], 2);
        }

        // Round to a max of 4 decimal places
        BigDecimal sumOfSquaresRounded = new BigDecimal(sumOfSquares);
        sumOfSquaresRounded = sumOfSquaresRounded.setScale(4, RoundingMode.HALF_UP);
        sumOfSquaresRounded = sumOfSquaresRounded.stripTrailingZeros();

        return sumOfSquaresRounded.toString();
    }
}