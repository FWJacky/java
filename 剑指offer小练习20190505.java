/**把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/

//遍历整个数组   时间复杂度：O(n2)
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        for(int i = 0;i<array.length;i++) {
            for(int j = i+1;j<array.length;j++) {
                if(array[i]>array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array[0];
    }
}

//二分法  时间复杂度：O(log2n)
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right) {
            int mid = left + (right - left) /2;
            if(array[mid] > array[right]) {
                left = mid+1;
            }else if(array[mid] == array[right]){
                right = right-1;
            }else {
               right = mid;
            }
        }
        return array[left];
    }
}

/**大家都知道斐波那契数列，现在要求输入一个整数n，
请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39*/

public class Solution {
    public int Fibonacci(int n) {
        if(n<=0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int fibonacciOne = 0;
        int fibonacciTwo = 1;
        int fibonacciNum = 0;
        for(int i = 2;i<=n;i++) {
            fibonacciNum = fibonacciOne + fibonacciTwo;
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = fibonacciNum;
        }
        return fibonacciNum;
    }
}

/**用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
       stack1.push(node);
    }
    public int pop() {
        int data = 0;
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            data = stack2.pop();
        }else {
            data = stack2.pop();
        }
        return data;
    }
}