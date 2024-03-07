public class PalindromeDetector {
    public static void main(String[] args) {
//        args[0] = "Bobs is bob";
//        System.out.println(args[0]);
//        System.out.println(isPalindrome("b"));
    }

    public static boolean isPalindrome(String text){
        // Variables for breaking up the original string
        String firstHalf = "";
        String secondHalf = "";
        String secondHalfRev = "";
        int midpoint;

        // If the string is blank, not a palindrome
        // If the string is not blank, check for palindrome
        if(text.isBlank()){
            return false;
        }else {
            // Remove blank space for multi-word palindromes
            text = text.replaceAll("\\s", "");

            // Find the midpoint for splitting string in half
            midpoint = text.length() / 2;
            firstHalf = text.substring(0, midpoint);

            // If length is even, second half starts right after first
            // If length is odd, midpoint is ignored since it is shared by both halves
            if (text.length() % 2 == 0){
                secondHalf = text.substring(midpoint);
            }else{
                secondHalf = text.substring(midpoint + 1);
            }

            // Reverse the second half
            for (int i = secondHalf.length() - 1; i >= 0; i--){
                secondHalfRev += secondHalf.charAt(i);
            }

            // If the first half is the same as the reversed second half, its a palindrome
            if (firstHalf.equalsIgnoreCase(secondHalfRev)){
                return true;
            }
        }
        return false;
    }
}
