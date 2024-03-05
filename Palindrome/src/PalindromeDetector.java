public class PalindromeDetector {
    public static void main(String[] args) {
//        args[0] = "Bobs is bob";
//        System.out.println(args[0]);
//        System.out.println(isPalindrome("b"));
    }

    public static boolean isPalindrome(String text){
        String firstHalf = "";
        String secondHalf = "";
        String secondHalfRev = "";
        int midpoint;

        if(text.isBlank()){
            return false;
        }else {
            text = text.replaceAll("\\s", "");

            midpoint = text.length() / 2;
            firstHalf = text.substring(0, midpoint);

            if (text.length() % 2 == 0){
                secondHalf = text.substring(midpoint);
            }else{
                secondHalf = text.substring(midpoint + 1);
            }

            for (int i = secondHalf.length() - 1; i >= 0; i--){
                secondHalfRev += secondHalf.charAt(i);
            }

            if (firstHalf.equalsIgnoreCase(secondHalfRev)){
                return true;
            }
        }
        return false;
    }
}
