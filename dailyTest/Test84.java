package dailyTest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName Test84
 * @Description TODO
 * @Author L
 * @Date 2019/8/13 22:19
 * @Version 1.0
 **/
public class Test84 {

    static class Customer implements Comparable<Customer>{
        private int customers;
        private int money;

        public Customer(int customers, int money) {
            this.customers = customers;
            this.money = money;
        }

        @Override
        public int compareTo(Customer o) {
            if(o.money>this.money) {
                return 1;
            }else if(o.money < this.money) {
                return -1;
            }else {
                return 0;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] table = new int[n];
            for (int i = 0; i < n; i++) {
                table[i] = scanner.nextInt();
            }
            Arrays.sort(table); // 将桌子容量从小到大排序
            PriorityQueue<Customer> queue = new PriorityQueue<>();  // 将客人列入优先队列
            for (int i = 0; i < m; i++) {
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                if(b <= table[n-1]) {
                    queue.add(new Customer(b,c));
                }
            }
            boolean[] visited = new boolean[n];
            long sum = 0;
            int count = 0;
            while (!queue.isEmpty()) {
                Customer customer = queue.poll();
                for (int i = 0; i < n; i++) {
                    if(customer.customers <= table[i] && !visited[i]) {
                        sum += customer.money;
                        visited[i] = true;
                        count++;
                        break;
                    }
                }
                if(count == n) {
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}
