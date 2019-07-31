package dailyTest;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName Test59
 * @Description TODO
 * @Author L
 * @Date 2019/7/31 11:05
 * @Version 1.0
 **/
public class Test59 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            String[] per = in.nextLine().split(" ");
            LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < per.length; i++) {
                map.put(per[i],0);
            }
            map.put("Invalid",0);
            int voters = Integer.parseInt(in.nextLine());
            String[] poll = in.nextLine().split(" ");
            for (String s : poll) {
                if(map.containsKey(s)) {
                    map.put(s, map.get(s)+1);
                }else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.println(key + " : "+map.get(key));
            }
        }
    }
}
