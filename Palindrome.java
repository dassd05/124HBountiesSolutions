import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    public static void main(String[] args) {
        //random palindromes found from internet + random word generator
        Map<String, Boolean> tests = new HashMap<>();
        tests.put("kayak", true);
        tests.put("deified", true);
        tests.put("Racecar", true);
        tests.put("Borrow or Rob", true);
        tests.put("platform", false);
        tests.put("investment", false);

        tests.forEach((key, value) -> {
            //boolean worked = true;
            if(checkPalindrome(key) != value) {
                System.out.println("you failed!");
            } else {
                System.out.println("seems to be working");
            }  
        });
    }

    public static boolean checkPalindrome(String s) {
		String normalized = s.replaceAll(" ", "").toLowerCase();
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}