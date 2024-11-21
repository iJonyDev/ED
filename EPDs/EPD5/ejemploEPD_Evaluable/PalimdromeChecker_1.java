package EPDs.EPD5.ejemploEPD_Evaluable;

// Implementacion usando una cola y una pila
public class PalimdromeChecker_1 {
    public static boolean isPalindrome(String s) throws PilaVaciaExcept, ColaVaciaExcept {
        Pila1<Character> stack = new Pila1<>();
        Cola1<Character> queue = new Cola1<>();
        String normalized = s.toLowerCase().replaceAll("[^a-z]", "");
        for (int i = 0; i < s.length(); i++) {
            stack.push(normalized.charAt(i));
            queue.enqueue(normalized.charAt(i));

        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String phrase = "otto";
        try {
            System.out.println(isPalindrome(phrase));
        } catch (PilaVaciaExcept | ColaVaciaExcept e) {
            e.printStackTrace();
        }
    }
}
