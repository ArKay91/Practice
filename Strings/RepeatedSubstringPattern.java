public class RepeatedSubstringPattern{

    public boolean isRepeatedSubstringPattern(String s){
        int len = s.length();
        for(int i=len/2; i >= 1; i--){
            if(len % i == 0){
                int num_repeats = len/i;
                StringBuilder sb = new StringBuilder();
                String substring  = s.substring(0, i);
                for(int j=0; j<num_repeats; j++){
                    sb.append(substring);
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        RepeatedSubstringPattern rs = new RepeatedSubstringPattern();
        rs.isRepeatedSubstringPattern("ababa");
        rs.isRepeatedSubstringPattern("abcabc");
        rs.isRepeatedSubstringPattern("abc"); 
    }
}