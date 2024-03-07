import java.rmi.UnexpectedException;
import java.text.DecimalFormat;

public class FeetToMeters {
    public static void main(String[] args) {

    }

    // Divide cubic feet per day by 35.315 to get cubic meters per day.
    // The only constraint is that the input must be positive.
    public static String convert(double feet, int places){
        double conversionRate = 35.315;
        double meters;
        String result;


        if(places != 2 && places != 3){
            throw new IllegalArgumentException("Places must be 2 or 3");
        }

        if (places == 2){
            DecimalFormat dec = new DecimalFormat("#.00");
            meters = feet/conversionRate;
            result = dec.format(meters);
        } else{
            DecimalFormat dec = new DecimalFormat("#.000");
            meters = feet/conversionRate;
            result = dec.format(meters);
        }

        if(feet < 0){
            throw new IllegalArgumentException("Input must be greater than or equal to 0.");
        }

        return result;
    }
}