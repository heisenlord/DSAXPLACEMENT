package SLIDINGWINDOW;
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int longest = 0;
        int maxf = 0;
        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(i)));
            if (i - l + 1 - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            longest = Math.max(longest, i - l + 1);
        }
        return longest;
    }
}