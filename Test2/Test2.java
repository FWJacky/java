/**
 * @ClassName Test2
 * @Description TODO
 * @Author L
 * @Date 2019/4/11 20:41
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
        String str = "1f4567";
        char[] ch = str.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            if(ch[i]<'0'||ch[i]>'9') {
                break;
            }
        }
        System.out.println("不是全由数字组成");

    }
}
