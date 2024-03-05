import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeDetectorTest {
    @ParameterizedTest
    @MethodSource("testPalInputs")
    void palindromeTester(boolean expected, String testString){
        String[] args = null;

        assertEquals(expected, PalindromeDetector.isPalindrome(testString));
        PalindromeDetector.main(args);
    }

    private static Stream<Arguments> testPalInputs(){
        return Stream.of(
                // Equivalence class tests
                Arguments.of(false, "awooga"), // Valid non-palindrome
                Arguments.of(true, "tacocat"), // Valid palindrome
                Arguments.of(false, ""), // Invalid string length
                Arguments.of(false, "  "), // Invalid blank string
                Arguments.of(true, "doggod"), // Valid palindrome of even length
                Arguments.of(true, "ada"), // Valid palindrome of odd length
                Arguments.of(true, "bobs is bob"), // Valid multi-word palindrome

                // BVA tests
                Arguments.of(false, ""), // Min length - 1
                Arguments.of(true, "a"), // Min length
                Arguments.of(false, "as"), // Min length + 1
                Arguments.of(true, "bob"), // Nominal length
                Arguments.of(false, "")

        );
    }
}