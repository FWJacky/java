import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/6/5 16:55
 * @Version 1.0
 **/
public class Test {
    public static void reverse(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            while (i < arr.length && !isEven(arr[i])) {
                i++;
                j = i + 1;
            }
            while(j<arr.length && isEven(arr[j])) {
                j++;
            }
            if(j<arr.length) {
                for (int k = j; k > i;k--) {
                    int tmp = arr[k-1];
                    arr[k-1] = arr[k];
                    arr[k] = tmp;
                }
            }else {
                break;
            }
        }
    }

    static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
