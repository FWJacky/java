/**
 * @ClassName Test2
 * @Description TODO
 * @Author L
 * @Date 2019/4/12 19:51
 * @Version 1.0
 **/
public class Test2 {
    public static int isNumeric(String str) {
//        char[] ch = str.toCharArray();
        int count = 0;
        int i =0;
        while(i<str.length()) {
            char a=str.charAt(i);
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                count ++;
            }
            i++;
//        for (int i = 0; i < str.length(); i++) {
//            if(ch[i]>'0'&&ch[i]<'9') {
//                count++;
//            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String str = "abc56bc8489cs65489sd" +
//                "wd12123";
        String str = "abc21b416u";
        System.out.println(isNumeric(str));
    }
}
