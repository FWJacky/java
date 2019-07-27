package dailyTest;

import java.util.*;

/**
 * @ClassName Test55
 * @Description TODO
 * @Author L
 * @Date 2019/7/27 12:16
 * @Version 1.0
 **/
public class Test55 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] str1 = in.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);
            String[] str2 = in.nextLine().split(" ");
            int[] grade = new int[str2.length+1];
            for (int i = 1; i <= str2.length; i++) {
                grade[i] = Integer.parseInt(str2[i-1]);
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, grade[i]);
            }
            List<String[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(in.nextLine().split(" "));
            }
            for (String[] c : list) {
                if("Q".equals(c[0])) {
                    if(Integer.parseInt(c[1]) < Integer.parseInt(c[2])) {
                        int max = map.get(Integer.parseInt(c[1]));
                        for (int i = Integer.parseInt(c[1]) + 1; i <= Integer.parseInt(c[2]); i++) {
                            max = Math.max(max, map.get(i));
                        }
                        System.out.println(max);
                    }else {
                        int max = map.get(Integer.parseInt(c[2]));
                        for (int i = Integer.parseInt(c[2]) + 1; i <= Integer.parseInt(c[1]); i++) {
                            max = Math.max(max, map.get(i));
                        }
                        System.out.println(max);
                    }
                }
                if("U".equals(c[0])) {
                    map.put(Integer.parseInt(c[1]),Integer.parseInt(c[2]));
                }
            }
        }
        in.close();
    }
}
