import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FeetToMetersTest {
    @ParameterizedTest
    @MethodSource("testConversionInputs")
    void testCoversionsDoubleInput(String expected, double input, int places){
        String[] args = null;

        if(input < 0) {
            Exception e = assertThrows(IllegalArgumentException.class, () -> FeetToMeters.convert(input, places));
            assertEquals("Input must be greater than or equal to 0.", e.getMessage());
        }
        else if(places != 2 && places != 3){
            Exception e = assertThrows(IllegalArgumentException.class, () -> FeetToMeters.convert(input, places));
            assertEquals("Places must be 2 or 3", e.getMessage());
        }
        else{
            assertEquals(expected, FeetToMeters.convert(input, places));
        }
        FeetToMeters.main(args);
    }

    private static Stream<Arguments> testConversionInputs(){
        return Stream.of(
                // Equivalence class tests
                Arguments.of("Input must be greater than or equal to 0.",-1, 2), // testing that an error will occur if input is below 0
                Arguments.of("14.158",500, 3), // valid input rounding to 3
                Arguments.of("14.16", 500, 2), // valid input rounding to 2
                Arguments.of("Places must be 2 or 3", 500, 1), // invalid input for places

                // BVA tests
                Arguments.of("Input must be greater than or equal to 0.",-1, 2), // min - 1
                Arguments.of(".000",0, 3), // min
                Arguments.of(".028",1, 3), // min + 1
                Arguments.of("28.317",1000, 3) // nominal input
        );
    }
}