/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/4/13 16:03
 * @Version 1.0
 **/


public class Test {
    public static void reverse(char[] str,int left,int right) {
        left = 0;
        right = str.length-1;
        while(left<right) {
            char tmp = str[left];
            str[left]=str[right];
            str[right]=tmp;
            left++;
            right--;
        }
    }
    public static String reverseCom(String str){
        char[] ch = str.toCharArray();
        reverse(ch,0,str.length()-1);
        int i = 0;
        int j = 0;
        while(i<ch.length) {
            if(ch[i]==' ') {
                i++;
                j++;
            }else if(j == str.length()||ch[j]==' ') {
                i = ++j;
                reverse(ch,i,j-1);
            }else {
                j++;
            }
//            reverse(ch,i,str.length()-1);
        }
        return String.copyValueOf(ch);
    }
    public static void main(String[] args) {
        System.out.println(reverseCom("i am biter"));
    }
    public static void main1(String[] args) {
        String p = null;
        try {
            int i = p.length();
            System.out.println(i);
            throw new Exception("NullPointerException");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("*****");
        }
    }
}
