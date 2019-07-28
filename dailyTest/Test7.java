import java.util.Scanner;

/**
 * @ClassName Test7
 * @Description TODO
 * @Author L
 * @Date 2019/7/2 22:04
 * @Version 1.0
 **/
public class Test7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] numS = new String[str.length()];
        int k = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            while(!(str.charAt(i)>='0'&&str.charAt(i)<='9')) {
                i++;
            }
            for (j = i; j < str.length(); j++) {
                if(!(str.charAt(j)>='0'&&str.charAt(j)<='9')) {
                    break;
                }
            }
            numS[k++] = str.substring(i,j);
        }
        String max = numS[0];
        for (int i = 0; i < k; i++) {
            if(numS[i].length()>max.length()){
                max = numS[i];
            }
        }
        System.out.println(max);
    }
}
