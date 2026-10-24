class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        func(0, digits, "", ans, map);

        return ans;
    }

    private void func(int ind, String digits, String temp,
                      List<String> ans, String[] map) {
        if (ind == digits.length()) {
            ans.add(temp);
            return;
        }
        String letters = map[digits.charAt(ind) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            func(ind + 1, digits, temp + ch, ans, map);
        }
    }
}