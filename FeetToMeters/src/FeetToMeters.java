import java.rmi.UnexpectedException;

public class FeetToMeters {
    public static void main(String[] args) {
        System.out.println(convert(1000));
    }

    // Divide cubic feet per day by 35.315 to get cubic meters per day.
    // The only constraint is that the input must be positive.
    public static double convert(double feet){

        if(feet < 0){
            throw new IllegalArgumentException("Input must be greater than or equal to 0.");
        }

        double conversionRate = 35.315;
        double meters = feet/conversionRate;

        return meters;
    }
}