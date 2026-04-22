import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            if (isWithinTwoEdits(query, dictionary)) {
                result.add(query);
            }
        }

        return result;
    }

    private boolean isWithinTwoEdits(String query, String[] dictionary) {
        for (String word : dictionary) {
            if (countDiff(query, word) <= 2) {
                return true;
            }
        }
        return false;
    }

    private int countDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return diff; // Early exit
            }
        }
        return diff;
    }
}