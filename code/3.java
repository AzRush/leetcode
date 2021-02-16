O(Nlog(N))
class Solution {
    public static boolean check(String s,int len){
        HashMap<Character,Integer> myMap = new HashMap();
        int conf = 0;
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(myMap.getOrDefault(ch,0) > 0)conf++;
            myMap.put(ch,myMap.getOrDefault(ch,0) + 1);
        }
        if(conf == 0)return true;
        for(int i = len; i < s.length(); i++){
            char ch = s.charAt(i - len);
            if(myMap.getOrDefault(ch,0) > 1)conf--;
            myMap.put(ch,myMap.getOrDefault(ch,0) - 1);
            ch = s.charAt(i);
            if(myMap.getOrDefault(ch,0) > 0)conf++;
            myMap.put(ch,myMap.getOrDefault(ch,0) + 1);
            if(conf == 0)return true;
        }
        return false;
    }
    public static  int lengthOfLongestSubstring(String s) {
        if(s == "" || s.length() == 0)return 0;
        int l = 1, r = s.length(),mid = (l + r + 1) / 2;
        while(l < r){
            mid =  (l + r + 1) / 2;
            System.out.println(l + " " + r + " " + mid);
            if(check(s,mid)){
                l = mid;
            }
            else
                r = mid - 1;
        }
        return l;
    }
}
O(N)
class Solution {
    public static  int lengthOfLongestSubstring(String s) {
        int l = 0,r = 0,ans = 0,conf = 0;
        int[] count = new int[256];
        while(l < s.length() && r < s.length()){
            char ch = s.charAt(r);
            if(count[ch] > 0)conf++;
            count[ch]++;
            while(conf > 0){
                ch = s.charAt(l);
                if(count[ch] > 1)conf--;
                count[ch]--;
                l++;
            }
            if(r - l + 1 > ans)ans = r - l + 1;
            r++;
        }
        return ans;
    }
}
