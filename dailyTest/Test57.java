package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test57
 * @Description TODO  人民币转换
 * @Author L
 * @Date 2019/7/29 10:23
 * @Version 1.0
 **/

// 壹贰叁肆伍陆柒捌玖拾
public class Test57 {
    public static String numConv(char i) {
        if (i == '1') {
            return "壹";
        }
        if (i == '2') {
            return "贰";
        }
        if (i == '3') {
            return "叁";
        }
        if (i == '4') {
            return "肆";
        }
        if (i == '5') {
            return "伍";
        }
        if (i == '6') {
            return "陆";
        }
        if (i == '7') {
            return "柒";
        }
        if (i == '8') {
            return "捌";
        }
        if (i == '9') {
            return "玖";
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] money = in.nextLine().split("\\.");
            String num = money[0];
            StringBuilder sb = new StringBuilder("人民币");
            for (int j = 0, i = num.length() - 1; i >= 0; i--, j++) {
                // 四个分为一组
                // 当个数对于3个时，如果有连续的两个零，只保存一个零
                if (num.charAt(j) != '0') {
                    if (j >= 3 && i % 4 == 0 && num.charAt(j - 1) == '0' && num.charAt(j - 2) == '0') {
                        sb.append("零");
                    }
                    // 从最高位开始进行转换
                    // 排除十位、十万位、十亿
                    if(num.charAt(j) !='1' || i % 4 != 1) {
                        sb.append(numConv(num.charAt(j)));
                    }
                }
                // 再拼接位数  万   亿  仟   拾
                if (i != 0) {
                    if (i % 8 == 0 && i >= 8) {
                        sb.append("亿");
                    }
                    if (i % 4 == 0 && i % 8 != 0) {
                        sb.append("万");
                    }
                    if (i % 4 == 3 && num.charAt(j) != '0') {
                        sb.append("仟");
                        if (num.charAt(j + 1) == '0' && num.charAt(j + 2) != '0') {
                            sb.append("零");
                        }
                    }
                    if (i % 4 == 2 && num.charAt(j) != '0') {
                        sb.append("佰");
                        if (num.charAt(j + 1) == '0' && num.charAt(j + 2) != '0') {
                            sb.append("零");
                        }
                    }
                    if (i % 4 == 1 && num.charAt(j) != '0') {
                        sb.append("拾");
                    }
                }
            }
            if (num.charAt(0) != '0') {
                sb.append("元");
            }
            if (money[1].equals("00")) {
                sb.append("整");
            } else {
                if (money[1].charAt(0) == '0') {
                    sb.append(numConv(money[1].charAt(1)));
                    sb.append("分");
                }
                if (money[1].charAt(1) == '0') {
                    sb.append(numConv(money[1].charAt(0)));
                    sb.append("角");
                }
                if (money[1].charAt(0) != '0' && money[1].charAt(1) != '0') {
                    sb.append(numConv(money[1].charAt(0)));
                    sb.append("角");
                    sb.append(numConv(money[1].charAt(1)));
                    sb.append("分");
                }
            }
            System.out.println(sb.toString());
        }
    }
}

