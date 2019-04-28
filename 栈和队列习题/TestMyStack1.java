package 栈和队列习题;

import 栈.MyStackImpl;

/**
 * @ClassName TestMystack1
 * @Description
 * @Author L
 * @Date 2019/4/26 22:00
 * @Version 1.0
 **/
public class TestMyStack1 {
    private MyStackImpl myStack;

    public TestMyStack1(int x) {
        this.myStack = new MyStackImpl(x);
    }

//    public void push(char ch) {
//        while(!myStack.empty()) {
//            myStack.pop2();
//        }
//        myStack.push2(ch);
//        this.usedSize++;
//    }
//
//    public char pop() {
//        if(empty()){
//            return 0;
//        }
//        char ch = 0;
//        if(!myStack.empty()) {
//            ch = myStack.pop2();
//        }
//        this.usedSize--;
//        return ch;
//    }
//
//    public char top() {
//        if(empty()) {
//            return 0;
//        }
//        char ch = 0;
//        if(!myStack.empty()) {
//            ch = myStack.pop2();
//        }
//        return ch;
//    }
//
//
//    public boolean empty() {
//        return this.usedSize == 0;
//    }
//
//    public int size(){
//        return this.usedSize;
//    }

    /**给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：
    1.左括号必须用相同类型的右括号闭合。
    2.左括号必须以正确的顺序闭合。

    注意空字符串可被认为是有效字符串。*/
    public boolean isValid(String s) {
        char[] ch = new char[s.length()];
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
            while(ch[i] != ' ') {
                if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                    myStack.push2(ch[i]);
                    break;
                } else {
                    if ((myStack.peek2() == '(' && ch[i] == ')') || (myStack.peek2() == '[' && ch[i] == ']')
                            || (myStack.peek2() == '{' && ch[i] == '}')) {
                        myStack.top--;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            len--;
        }
        if(myStack.top>0){
            return false;
        }
        return true;
    }


}
