import java.util.*;

/**
 * @ClassName Test9
 * @Description TODO
 * @Author L
 * @Date 2019/7/3 11:12
 * @Version 1.0
 **/
public class Test9 {
    public static void main(String[] args){
        int x = 0;
        int count1 = 0;
        Map map = new HashMap();
        Scanner in = new Scanner(System.in);
        String  str = in.nextLine();
        char[] str1 = str.toCharArray();
        for(int i = 0;i<str1.length;i++){
            if(str1[i]>='0'&&str1[i]<='9'){
                List list1 = new ArrayList<>();
                list1.add(str1[i]);
                int count = 1;
                for(int j = i; j<str1.length;j++){
                    if (str1[j] == (str1[j + 1] + 1)) {
                        list1.add(str1[j + 1]);
                        count += 1;
                    }else{
                        if (count>count1){
                            count1=count;
                        }
                        map.put(count1,list1);
                        x++;
                        break;
                    }
                }
            }
        }
        System.out.println(map.get(count1));
    }
}