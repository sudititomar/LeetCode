class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", ans, phone);

        return ans;
    }

    public void backtrack(String digits, int index, String current,
                           List<String> ans, String[] phone) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(
                digits,
                index + 1,
                current + letters.charAt(i),
                ans,
                phone
            );
        }
    }
}