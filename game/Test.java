/**
 * @ClassName Test
 * @Description TODO
 * @Author L
 * @Date 2019/4/12 18:13
 * @Version 1.0
 **/
public class Test {
    public static String stringCompress(String str) {
        //创建一个新的字符串，用来保存压缩后的结果
        StringBuffer sb = new StringBuffer();
        //创建下标变量
        int i = 0;
        //将字符串变为字符数组
        char[] ch = str.toCharArray();
        //外层循环，控制循环次数
        while (i<str.length()) {
            //定义变量，用来统计连续的相同字符的个数
            int count = 1;
            //内存循环，控制比较的次数
            for(int j = i+1;j<str.length();j++) {
                if(ch[i] == ch[j]) {
                    count++;
                }
                //如果连续的两个字符不相等，则跳出当前循环
                else {
                    break;
                }
            }
            if(count>1) {
                sb.append(ch[i]).append(count);
            }
            else {
                sb.append(ch[i]).append(count);
            }
            //连续相同字符的最后一个下标处
            i = i+count;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "aaaabbbeeffdwwwwwa";
        System.out.println(stringCompress(str));
    }
}

