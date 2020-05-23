package Q2_checkPermutation;

import java.util.HashMap;

public class checkPermutation {

    public static boolean permutation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }
        HashMap<Character,Integer> letters = new HashMap<>();
        for (char c : a.toCharArray()) {
            if (letters.get(c) != null) {
                letters.put(c,letters.get(c)+1);
            }
            else {
                letters.put(c,1);
            }
        }

        for (char c : b.toCharArray()) {
            if (letters.get(c) != null) {
                int val = letters.get(c);
                val--;
                if (val<0) {
                    return false;
                }
                letters.put(c,letters.get(c)-1);
            }
        }

        return true;
    }



    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"},{"anu","shila"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
