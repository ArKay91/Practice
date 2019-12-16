// Given two words A and B, and a dictionary, C, find the length of shortest transformation sequence from A to B, such that:

// You must change exactly one character in every transformation.
// Each intermediate word must exist in the dictionary.
// Note:

// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// Input Format:

// The first argument of input contains a string, A.
// The second argument of input contains a string, B.
// The third argument of input contains an array of strings, C.
// Output Format:

// Return an integer representing the minimum number of steps required to change string A to string B.
// Constraints:

// 1 <= length(A), length(B), length(C[i]) <= 25
// 1 <= length(C) <= 5e3
// Example :

// Input 1:
//     A = "hit"
//     B = "cog"
//     C = ["hot", "dot", "dog", "lot", "log"]

// Output 1:
//     5

// Explanation 1:
//     "hit" -> "hot" -> "dot" -> "dog" -> "cog"

import java.util.*;

public class WordLadder1{
    public static int solve(String A, String B, ArrayList<String> C){
        Set<String> set = new HashSet<>(C);
        Queue<String> queue = new LinkedList<>();
        queue.offer(A);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String current = queue.poll();
                char[] word_char = current.toCharArray();
                for(int j=0; j<word_char.length; j++){
                    char orignial_char = word_char[j];
                    for(char k='a';k<='z';k++){
                        word_char[j] = k;
                        String new_word = String.valueOf(word_char);
                        if(new_word.equals(B)) return level+1;
                        if(set.contains(new_word)){
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }
                    word_char[j] = orignial_char;
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args){
        ArrayList<String> C = new ArrayList<>();
        C.add("hot");
        C.add("dot");
        C.add("dog");
        C.add("lot");
        C.add("log");
        System.out.print(WordLadder1.solve("hit","cog",C));     
    }
}