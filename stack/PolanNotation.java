package stack;

import java.sql.PreparedStatement;
import java.util.*;

/**
 * @ClassName PolanNotation
 * @Description TODO  逆波兰计算器
 * @Author L
 * @Date 2019/8/5 16:49
 * @Version 1.0
 **/
public class PolanNotation {

    public static void main(String[] args) {

        // 完成将一个中缀表达式转成后缀表达式的功能
        // 说明
        // 1. 1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
        // 2. 得到存放中缀表达式的list
        // 3. 得到后缀表达式 ArrayList=[1,2,3,+,4,*,+,5,-]

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> suffixExpressionList = parseSuffinExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);
        System.out.println("expression = " + calculate(suffixExpressionList));




//        // 先定义一个逆波兰表达式
//        // （3+4）*5-6  ---->   3 4 + 5 * 6 -
//        // 4 * 5 - 8 + 60 + 8 / 2 ==> 4 5 * 8 - 60 + 8 2 / +
//        // 为了方便，逆波兰表达式的数字和符号之间用空格隔开
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        // 思路
//        // 1. 先将 "3 4 + 5 * 6 -" => 放到ArrayList中
//        // 2. 将ArrayList 传递给一个方法，配合栈完成计算
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println("rpnList" + rpnList);
//
//        int res = calculate(rpnList);
//        System.out.println("运算结果 = " + res);
    }

    // 得到后缀表达式 ArrayList=[1,2,3,+,4,*,+,5,-]
    public static List<String> parseSuffinExpressionList(List<String> list) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>(); // 符号栈
        List<String> s2 = new ArrayList<>();

        // 遍历list
        for (String item : list) {
            // 如果是一个数，加入s2
            if(item.matches("\\d+")) {
                s2.add(item);
            }else if(item.equals("(")) {
                s1.push(item);
            }else if(item.equals(")")) {
                while(!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); // 将 ( 弹出s1，消除括号
            }else {
                // 当item的优先级小于或等于s1栈顶的运算符优先级
                // 缺少一个比较优先级高低的方法
                while (!s1.isEmpty() && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出并加入s2
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    // 将一个中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String str) {
        // 定义一个List,存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        int i = 0;// 用于遍历中缀表达式字符串
        String string;// 对多位数进行拼接
        char c;// 每遍历到一个字符，就放到c
        do{
            // 如果c是一个非数字，则加入到list
            if((c=str.charAt(i)) < '0' || (c=str.charAt(i)) >'9') {
                list.add(""+c);
                i++;
            }else {
                string="";// 先将string置成""
                while (i<str.length() && (c=str.charAt(i)) >= '0' && (c=str.charAt(i)) <= '9') {
                    string += c;
                    i++;
                }
                list.add(string);
            }
        }while (i < str.length());
        return list;
    }

    // 将一个逆波兰表达式，依次将数据和运算符 放到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> list) {
        // 创建栈，只需要一个栈
        Stack<String> stack = new Stack<>();
        // 遍历list
        for (String item : list) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                // 把res入栈
                stack.push(res + "");
            }
        }
        // 最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}

// 编写一个类Operation，返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}