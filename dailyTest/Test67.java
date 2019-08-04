package dailyTest;

import java.math.BigInteger;
import java.util.*;

/**
 * @ClassName Test67
 * @Description TODO  大整数排序
 * @Author L
 * @Date 2019/8/4 20:54
 * @Version 1.0
 **/

/*
 * 对N个长度最长可达1000的数进行排序
 *
 **/
public class Test67 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            BigInteger[] bg = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                bg[i] = in.nextBigInteger();
            }
            Arrays.sort(bg);
            for (int i = 0; i < bg.length; i++) {
                System.out.println(bg[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            String[] strings = new String[n];
            HashMap<Integer,String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                strings[i] = in.nextLine();
                map.put(strings[i].length(),strings[i]);
            }

            List<Map.Entry<Integer,String>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, Comparator.comparing(Map.Entry::getKey));

            for (Map.Entry<Integer,String> entry : list) {
                System.out.println(entry.getValue());
            }
        }
    }
}
