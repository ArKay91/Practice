import java.util.*;

public class FirstUniqueChar{
    public static int firstUniqueChar(String a){
        int[] map = new int[256];
        for(char c : a.toCharArray()){
            map[c-'a']++;
        }
        int i=0;
        for(char c : a.toCharArray()){
            if(map[c-'a'] == 1) return i;
            i++;
        }

        return -1;
    }

    public static void main(String[] args){
        String s = "bbsgbgbbgbdbbfdfvd";
        System.out.println("First Unique character : " + s.charAt(FirstUniqueChar.firstUniqueChar(s)));
    }
}
