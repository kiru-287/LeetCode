package git.leetCode.dataStructure14Days;

public class RansomNote_383 {

    public static void main(String[] args) {
        System.out.println(canConstruct("a","b")); //false
        System.out.println(canConstruct("aa","ab")); //false
        System.out.println(canConstruct("aa","aab")); //true
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }else {
            int[] arr = new int[26];
            for (char c : magazine.toCharArray())
                ++arr[c-'a'];
            for (char c : ransomNote.toCharArray())
                if (--arr[c-'a'] < 0)
                    return false;
            return true;
        }
    }
}
