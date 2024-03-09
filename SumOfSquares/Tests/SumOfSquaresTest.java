import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSquaresTest {
    @ParameterizedTest
    @MethodSource("testSumOfSquaresInputs")
    void SumOfSquaresTester(String expected, double[] arrTest){
        String[] args = null;
        SumOfSquares.main(args);

        if (expected.startsWith("Invalid")) {
            // If the expected result indicates an invalid array size, test for the exception
            assertThrows(IllegalArgumentException.class, () -> SumOfSquares.calcSumOfSquares(arrTest));
        } else {
            // Otherwise, assert the result as usual
            assertEquals(expected, SumOfSquares.calcSumOfSquares(arrTest));
        }
    }

    private static Stream<Arguments> testSumOfSquaresInputs(){
        return Stream.of(
                // Equivalence class tests
                Arguments.of("Invalid double value: >max", new double[]{12.929,19.738,Double.MAX_VALUE+1}), // Invalid double value >max
                Arguments.of("80.05", new double[]{7.9,4.2}), // Valid rounding when <4 decimal places
                Arguments.of("85.0687", new double[]{3.589311,8.49621}), // Valid rounding down when >4 decimal places
                Arguments.of("556.7477", new double[]{12.929,19.738}), // Valid rounding up when >4 decimal places

                // BVA tests
                Arguments.of("Invalid array size: <1", new double[]{}), // Min length - 1
                Arguments.of("25", new double[]{5}), // Min length
                Arguments.of("342.8125", new double[]{10.5,15.25}), // Min length + 1
                Arguments.of("2828.325", new double[]{5,10,15,20,25,5.25,10.5,15.75,20.3,25.6}) // Nominal length
        );
    }
}