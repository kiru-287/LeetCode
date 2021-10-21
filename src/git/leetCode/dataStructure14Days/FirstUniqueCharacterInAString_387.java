/*
* https://leetcode.com/problems/first-unique-character-in-a-string/
* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

package git.leetCode.dataStructure14Days;

public class FirstUniqueCharacterInAString_387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode")); //2
        System.out.println(firstUniqChar("leetcode")); //0
    }
    public static int firstUniqChar(String s) {
        int[] vis = new int[s.length()];


        for(int i=0 ; i<s.length() ; i++) {
            if(vis[i] != 1) {
                boolean flag = true;
                char c = s.charAt(i);
                for (int j = i + 1; j < s.length(); j++) {
                    if (c == s.charAt(j)) {
                        vis[j] = 1;
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }

        if(vis[s.length()-1] != 1) {
            return s.charAt(s.length()-1);
        }
        return -1;
    }
}

