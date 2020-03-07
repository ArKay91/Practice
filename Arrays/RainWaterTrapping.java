import java.util.*;

public class RainWaterTrapping{

    public int trappedWater(int[] height){
        int ans = 0; int current = 0;
        Stack<Integer> stack = new Stack<>();
        while(current < height.length){
            while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top = stack.peek();
                stack.pop();
                if(stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    public static void main(String[] args){
        RainWaterTrapping rwt = new RainWaterTrapping();
        System.out.println("Rain Water Trapped " + rwt.trappedWater(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 }));
    }
}