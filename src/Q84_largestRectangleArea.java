import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q84_largestRectangleArea
 * @Date: 2024/6/24
 */
public class Q84_largestRectangleArea {
    public static void main(String[] args) {
        int result=largestRectangleArea0(new int[]{2,1,5,6,2,3});
        System.out.println(result);
    }
    public static int largestRectangleArea(int[] heights){
        //1.暴力求解
        int minheight=Integer.MAX_VALUE;
        int maxheight=0;
        int n=heights.length;
        int maxArea=0;
        for(int i=0;i<n;i++){
            minheight=Math.min(heights[i],minheight);
            maxheight=Math.max(heights[i],maxheight);
        }
        for(int height=minheight;height<=maxheight;height++){
            int left=0,right=0;
            for(int j=0;j<n;j++){
                if(heights[j]<height){
                    continue;
                }
                left=j;
                right=j;
                while(j<n&&heights[j]>=height){
                    j++;
                    right++;
                }
                maxArea=Math.max(maxArea,height*(right-left));
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea0(int[] heights){
        Stack<Integer> stack=new Stack<>();
        //1.扩展
        int maxArea=0,n=heights.length;
        int[] newHeights=new int[n+2];
        newHeights[0]=0;
        for(int i=0;i<n;i++){
            newHeights[i+1]=heights[i];
        }
        stack.push(0);
        heights=newHeights;
        for(int j=1;j<n+2;j++){
            if(heights[j]>=heights[stack.peek()]){
                stack.push(j);
            }else{
                while(!stack.isEmpty()&&heights[j]<heights[stack.peek()]){
                    int mid=stack.pop();
                    int left=stack.peek();
                    int right=j;
                    int area=heights[mid]*(right-left-1);
                    maxArea=Math.max(maxArea,area);
                }
                stack.push(j);
            }

        }
        return maxArea;
    }
}
