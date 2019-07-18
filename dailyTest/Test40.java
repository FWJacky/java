package com.github.dailyTest;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName Test40
 * @Description TODO
 * @Author L
 * @Date 2019/7/18 21:03
 * @Version 1.0
 **/


public class Test40 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] A = new int[n];
            for(int i=0;i<n;i++){
                A[i] = in.nextInt();
            }
            int start = 0;
            ArrayList<int[]> result = new ArrayList<>();
            Permutation(A,start,n,result);
            Set<String> sortResult = new TreeSet<>();

            for(int[] out:result){
                if(isLegal(A,out,n)){
                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<n-1;i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
                }
            }
            for(String list:sortResult){
                System.out.println(list);
            }
        }
        in.close();

    }
    private static boolean isLegal(int[] in,int[] out,int n){
        LinkedList<Integer> stack = new LinkedList<>();
        int i=0;
        int j=0;
        while(i<n){ // in 还有元素的时候都需要判断
            if(in[i] == out[j]){ //  相等时候就不用入栈，直接后移
                i++;
                j++;
            }else{
                if(stack.isEmpty()){ //空stack 就只有入栈了
                    stack.push(in[i]);
                    i++;
                }else{
                    int top = stack.peek(); // 栈顶元素相等，进行出栈
                    if(top ==out[j]){
                        j++;
                        stack.pop();
                    }else if(i<n){ //  不等的时候入栈
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while(!stack.isEmpty() && j<n){ // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素 相同
            int top = stack.pop();
            if(top == out[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;

    }
    /**
     * 求出所有排列
     * @param A
     * @param start
     * @param n
     * @param result
     */
    private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
        if(start == n){
            return;
        }
        if(start == n-1){
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for(int i=start;i<n;i++){
            swap(A,start,i);
            Permutation(A,start+1,n,result);
            swap(A,start,i);
        }

    }
    private static void swap(int[] A,int i,int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

}