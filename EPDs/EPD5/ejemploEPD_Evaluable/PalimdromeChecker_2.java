package EPDs.EPD5.ejemploEPD_Evaluable;
// Implementacion usando una pila
public class PalimdromeChecker_2 {
    public static boolean isPalindrome(String s) throws EmptyStackException {
        Stack<Character> stack = new Stack<>();
        String normalized = s.toLowerCase().replaceAll("[^a-z]", "");

        int length = normalized.length();
        for (int i = 0; i < length / 2; i++) {
            stack.push(normalized.charAt(i));
        }
        for (int i = (length + 1) / 2; i < length; i++) {
            if (stack.pop() != normalized.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String phrase = "otto";
        try {
            System.out.println(isPalindrome(phrase));
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }
}
