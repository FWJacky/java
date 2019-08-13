package dailyTest;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Test83
 * @Description TODO
 * @Author L
 * @Date 2019/8/13 21:47
 * @Version 1.0
 **/
public class Test83 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k > input.length) {
            return arrayList;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k > input.length) {
            return arrayList;
        }
        for (int i = 0; i < input.length-1; i++) {
            for (int j = 0; j < input.length-i-1; j++) {
                if(input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        for(int i = 0;i<k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        Test83 ts = new Test83();
        ArrayList<Integer> rs = ts.GetLeastNumbers_Solution2(input,4);
        System.out.println(rs);
    }
}
