package dailyTest;

import java.util.*;

/**
 * @ClassName Test72
 * @Description TODO  锤子剪刀布
 * @Author L
 * @Date 2019/8/8 10:44
 * @Version 1.0
 **/
public class Test72 {

    public static void main2(String[] args) {
        Scanner scnner = new Scanner(System.in);
        while (scnner.hasNext()) {
            int n = Integer.parseInt(scnner.nextLine());
            Map<String, Integer> winMap = new LinkedHashMap<>();
            winMap.put("B",0);
            winMap.put("C",0);
            winMap.put("J",0);
            Map<String, Integer> loseMap = new LinkedHashMap<>();
            loseMap.put("B",0);
            loseMap.put("C",0);
            loseMap.put("J",0);
            int countP = 0;
            int countLose = 0;
            for (int i = 0; i < n; i++) {
                String[] strings = scnner.nextLine().split(" ");
                if ("B".equals(strings[0])) {
                    if ("C".equals(strings[1])) {
                        winMap.put("B", winMap.get("B")+1);
                    } else if ("B".equals(strings[1])) {
                        countP++;
                    } else {
                        countLose++;
                        loseMap.put(strings[0], countLose);
                    }
                }
                if ("C".equals(strings[0])) {
                    if ("J".equals(strings[1])) {
                        winMap.put("C", winMap.get("C")+1);
                    } else if ("C".equals(strings[1])) {
                        countP++;
                    } else {
                        countLose++;
                        loseMap.put("C", countLose);
                    }
                }
                if ("J".equals(strings[0])) {
                    if ("B".equals(strings[1])) {
                        winMap.put("J", winMap.get("J")+1);
                    } else if ("J".equals(strings[1])) {
                        countP++;
                    } else {
                        countLose++;
                        loseMap.put("J", countLose);
                    }
                }
            }
            int sum = 0;
            Collection<Integer> value = winMap.values();
            Object[] arr = value.toArray();
            Arrays.sort(arr);
            Integer max = (Integer) arr[arr.length - 1];
            Collection<Integer> value2 = loseMap.values();
            Object[] arr2 = value2.toArray();
            Arrays.sort(arr2);
            Integer min = (Integer) arr2[0];
            String maxStr = null;
            String minStr = null;
            for (String key : winMap.keySet()) {
                sum += winMap.get(key);
                if (max.equals(winMap.get(key))) {
                    if(maxStr==null) {
                        maxStr = key;
                    }
                }
            }
            for (String key : loseMap.keySet()) {
                if (min.equals(loseMap.get(key))) {
                    if(minStr==null) {
                        minStr = key;
                    }
                }
            }
            System.out.println(sum + " " + countP + " " + countLose);
            System.out.println(countLose + " " + countP + " " + sum);
            if ("C".equals(minStr)) {
                minStr = "B";
            } else if ("B".equals(minStr)) {
                minStr = "J";
            } else {
                minStr = "C";
            }
            System.out.println(maxStr + " " + minStr);
        }
        scnner.close();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Model mA = new Model();
        Model mB = new Model();

        for (int i = 0; i < N; i++) {
            String a = sc.next();
            String b = sc.next();
            judge(a, b, mA, mB);
        }

        System.out.println(mA.win + " " + mA.tie + " " + mA.lose);
        System.out.println(mB.win + " " + mB.tie + " " + mB.lose);
        System.out.println(getMostGen(mA.map) + " " + getMostGen(mB.map));
    }

    public static void judge(String a, String b, Model mA,
                             Model mB) {
        if (a.equals("C")) {
            if (b.equals("C")) {
                mA.tie++;
                mB.tie++;
            } else if (b.equals("J")) {
                mA.win++;
                mB.lose++;
                mA.map.put("C", mA.map.get("C") + 1);
            } else {
                mA.lose++;
                mB.win++;
                mB.map.put("B", mA.map.get("B") + 1);
            }
        } else if (a.equals("J")) {
            if (b.equals("C")) {
                mA.lose++;
                mB.win++;
                mB.map.put("C", mA.map.get("C") + 1);
            } else if (b.equals("J")) {
                mA.tie++;
                mB.tie++;
            } else {
                mA.win++;
                mB.lose++;
                mA.map.put("J", mA.map.get("J") + 1);
            }
        } else {
            if (b.equals("C")) {
                mA.win++;
                mB.lose++;
                mA.map.put("B", mA.map.get("B") + 1);
            } else if (b.equals("J")) {
                mA.lose++;
                mB.win++;
                mB.map.put("J", mA.map.get("J") + 1);
            } else {
                mA.tie++;
                mB.tie++;
            }
        }
    }

    public static String getMostGen(Map<String, Integer> map) {
        if (map.get("C") >= map.get("J")) {
            if (map.get("C") > map.get("B")) {
                return "C";
            } else {
                return "B";
            }
        } else {
            if (map.get("J") > map.get("B")) {
                return "J";
            } else {
                return "B";
            }
        }
    }

    static class Model {
        int win;
        int tie;
        int lose;
        Map<String, Integer> map;

        Model() {
            map = new HashMap<>();
            map.put("B", 0);
            map.put("C", 0);
            map.put("J", 0);
        }
    }
}
