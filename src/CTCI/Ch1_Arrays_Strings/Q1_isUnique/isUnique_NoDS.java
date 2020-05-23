package Q1_isUnique;

public class isUnique_NoDS {

    public static boolean isUnique(String str) {

        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (char c: str.toCharArray()) {
            int val = c;
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }


}
