import java.util.*;
public class JumpGame1{
    public static boolean canJump(ArrayList<Integer> A){
        if(A.size() <= 1){
            return false;
        }
        int max = A.get(0);
        for(int i=0; i<A.size(); i++){
            if(max <= i && A.get(i) == 0){
                return false;
            }
            if(max < A.get(i) + i){
                max = A.get(i) + i;
            }
            if(max >= A.size()-1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(3);
        al.add(1);
        al.add(0);
        al.add(4);
        if(JumpGame1.canJump(al)){
            System.out.println("Can Jump ");
        }else{
            System.out.println("Cannot Jump");
        }
    }
}