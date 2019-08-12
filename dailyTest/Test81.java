package dailyTest;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Test81
 * @Description TODO
 * @Author L
 * @Date 2019/8/11 22:58
 * @Version 1.0
 **/
public class Test81 {

    static int[][] map;
    static int n,m,maxEnergy = 0;
    static String path = "";
    static LinkedList<String> linkedList  = new LinkedList<>(); // 用于保存路径
    static boolean flag = false; // 用来判断是否找得到出口
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int p = scanner.nextInt();
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            setWay(0,0,p);
            if(!flag) {
                System.out.println("Can not escape!");
            }else {
                System.out.println(path);
            }
        }
    }

    public static void setWay(int i,int j,int energy) {
        if(energy < 0 || i < 0 || j < 0 || i>= n || j>=m||map[i][j]!=1) {
            return;
        }else {
            map[i][j] = 0;
            linkedList.offer("["+i+","+j+"]");
            if(i==0 && j==m-1) {
                if (energy >= maxEnergy){
                    maxEnergy = energy;
                    updatePath();
                }
                map[i][j] = 1;
                linkedList.removeLast();
                flag = true;
                return;
            }
        }
        setWay(i, j+1, energy-1);
        setWay(i+1, j, energy);
        setWay(i-1, j, energy-3);
        setWay(i, j-1, energy-1);
        map[i][j]=1;
        linkedList.removeLast();
    }

    public static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()+",");
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
        }
        path = sb.toString();
    }
}
