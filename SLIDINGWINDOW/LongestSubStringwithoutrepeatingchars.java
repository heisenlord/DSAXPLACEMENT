package SLIDINGWINDOW;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        while(r<s.length())
        {
            char c=s.charAt(r);
        
            if(map.containsKey(c))
            {
                l=Math.max(l,map.get(c)+1);
            }
            map.put(c,r);
           max= Math.max(max,r-l+1);
            r++;
        }
        return max;
       
    }
}