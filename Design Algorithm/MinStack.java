import java.util.*;

public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack(){
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    public void push(int x){
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop(){
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min;
    }

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(0);
        minStack.push(3);
        minStack.push(-3);
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.top());
    }
}