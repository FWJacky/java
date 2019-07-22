package com.github.dailyTest;

import java.util.*;

//TODO 成绩排序问题
public class Test45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int order = sc.nextInt();
            ArrayList<Integer> list = new ArrayList();
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                list.add(score);
                map.put(name + " " + score, score);
            }
            Collections.sort(list);
            if (order == 0)
                Collections.reverse(list);
            int pre = -1;
            for (int i : list) {
                if (pre == i)
                    continue;
                for (String key : map.keySet()) {
                    if (map.get(key).equals(i)) {
                        System.out.println(key);
                    }
                    pre = i;
                }
            }
        }
    }
}