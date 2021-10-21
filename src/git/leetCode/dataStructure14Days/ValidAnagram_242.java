package git.leetCode.dataStructure14Days;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram")); //true
        System.out.println(isAnagram("rat","cat")); //false
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }else {
            int[] arr = new int[26];
            for (char c : s.toCharArray())
                ++arr[c-'a'];
            for (char c : t.toCharArray())
                if (--arr[c-'a'] < 0)
                    return false;
            return true;
        }
    }
}
