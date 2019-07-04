import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName Test8
 * @Description TODO
 * @Author L
 * @Date 2019/7/2 23:20
 * @Version 1.0
 **/
public class Test8 {

    public static boolean isBracket(char ch) {
        if ('(' == ch || '[' == ch || '{' == ch || ')' == ch || ']' == ch || '}' == ch) {
            return true;
        }
        return false;
    }

    public static boolean chkParenthesis(String A, int n) {
        char[] stack = new char[n];
        int top = 0;
        int j = 0;
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (isBracket(A.charAt(i))) {
                if (A.charAt(i) == '(' || A.charAt(i) == '{' || A.charAt(i) == '[') {
                    stack[top++] = A.charAt(i);
                } else {
                    if (top == 0) {
                        return false;
                    }
                    char c = stack[top - 1];
                    if ('(' == c && ')' == A.charAt(i) || '[' == c && A.charAt(i) == ']' || '{' == c && A.charAt(i) == '}') {
                        --top;
                    }
                }
            } else {
                return false;
            }
        }
        if (top > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "(()())";
        System.out.println(chkParenthesis(str, 6));
    }
}

abstract class a {

    public a(){}

    protected abstract void function();
}

class b extends a{

    @Override
    protected void function() {

    }
}
