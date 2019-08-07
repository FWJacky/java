package stack;

import sun.text.normalizer.CharacterIteratorWrapper;

/**
 * @ClassName StackComtureCalculator
 * @Description TODO  利用栈实现综合计算器
 * @Author L
 * @Date 2019/8/4 23:07
 * @Version 1.0
 **/

/*
 *      TODO 利用栈实现综合计算器的思路
 *       利用两个栈，一个栈用来存放数据---numStack，另一个栈用来存放运算符---operaStack
 *       1. 通过一个index值（索引），来遍历我们的表达式
 *       2. 如果我们发现是一个数字，就直接入numStack
 *       3. 如果发现扫描到的是一个运算符，就分以下情况
 *              a）如果当前的operaStack为空，就直接入栈
 *              b）如果operaStack有操作符，就进行比较，如果当前操作符的优先级小于或者等于栈中的操作符
 *                  就需要从numStack中pop出两个数，在operaStack中pop出一个运算符，进行运算，将得到的
 *                  结果入numStack，然后将当前的操作符入operaStack
 *       4. 当表达式扫描完毕后，就顺序的从numStack和operaStack中pop出相应的数和符号，并运算
 *       5. 最后在numStack中只有一个数字，就是表达式的结果
 *
 *
 *      TODO   前缀表达式----又称波兰式，前缀表达式的运算符位于操作数之前
 *       例如：（3+4）*5-6  对应的前缀表达式就是 -*+3 4 5 6
 *       前缀表达式的计算机求值：
 *          从右至左扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数
 *          用运算符对它们做相应的计算（栈顶元素和次顶元素），并将结果入栈；重复上述过程直
 *          到表达式最左端，最后运算得出的值即为表达式的结果
 *
 *      TODO   中缀表达式----就是常见的运算表达式，如（3+4）*5-6   需要判断运算符的优先级
 *
 *
 *      TODO   后缀表达式----逆波兰表达式，运算符位于操作数之后
 *       例如：（3+4）*5-6 对应的后缀表达式就是 3 4 + 5 * 6 -
 *              正常的表达式          逆波兰表达式
 *                  a+b                 a b +
 *                 a+(b-c)              a b c - +
 *                 a+(b-c)*d            a b c - d * +
 *                 a+d*(b-c)            a d b c - * +
 *                  a=1+3               a 1 3 + =
 *       后缀表达式的计算机求值：
 *          从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，
 *          用运算符对它们做相应的计算（次顶元素和栈顶元素），并将结果入栈；重复上述过程，直
 *          到表达式最右端，最后运算得出的值即为表达式的结果。
 *
 *
 **/

//先创建一个栈，直接使用前面创建好的栈
class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组模拟栈，数据就放在该数组中
    private int top = -1; // 栈顶，初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    // 判断栈满
    public boolean isFull() {
        return this.top == maxSize - 1;
    }

    // 判断栈空
    public boolean isEmpty() {
        return this.top == -1;
    }

    // 入栈-push
    public void push(int value) {
        // 先判断栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    // 出栈-pop，将栈顶的数据返回
    public int pop() {
        // 先判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int data = stack[top--];
        return data;
    }

    // 查看栈顶元素
    public int peek() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~~");
            return -1;
        }
        return stack[top];
    }

    // 遍历栈---从栈顶开始遍历
    public void list() {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~~");
            return;
        }
        //需要从栈顶开始遍历
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // 返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    // 数字越大，则优先级越高
    public int priority(int opera) {
        if (opera == '*' || opera == '/') {
            return 1;
        } else if (opera == '+' || opera == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有+，-，*，/
        }
    }

    // 判断是不是一个运算符
    public boolean isOpera(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, char opera) {
        int res = 0; // 用于存放计算的结果
        switch (opera) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;  // 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}

public class StackComtrueCalculatorDemo {

    public static void main(String[] args) {
        String expression = "70-6+2*3-1";
        // 先创建两个栈，一个numStack，一个operaStack
        ArrayStack2 numStack =new ArrayStack2(10);
        ArrayStack2 operaStack =new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        char opera = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描得到的char保存到ch
        String keepNum = "";// 用于拼接多位数
        // 开始while循环的扫描expression
        while (true) {
            // 一次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if(operaStack.isOpera(ch)) {
                // 判断当前的符号栈是否为空
                if(!operaStack.isEmpty()) {
//                    如果operaStack有操作符，就进行比较，如果当前操作符的优先级小于或者等于栈中的操作符
//                    就需要从numStack中pop出两个数，在operaStack中pop出一个运算符，进行运算，将得到的
//                    结果入numStack，然后将当前的操作符入operaStack
                    if(operaStack.priority(ch) <= operaStack.priority(operaStack.peek())) {
                        // 相同优先级时，不能直接入栈，而应该将栈中优先级相同的运算符pop空，才能入栈
                        while (!operaStack.isEmpty()) {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            opera = (char) operaStack.pop();
                            res = numStack.cal(num1, num2, opera);
                            // 把运算结果入numStack
                            numStack.push(res);
                        }
                            //然后将当前的操作符入符号栈
                            operaStack.push(ch);
                    }else {
                        // 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operaStack.push(ch);
                    }
                }else {
                    // 如果为空直接入栈
                    operaStack.push(ch);
                }
            }else { // 如果是数，那么直接入栈

                //numStack.push(ch - 48);
                // 分析思路
                // 1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                // 2. 在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是运算符才入栈
                // 3. 因此我们需要定义一个变量字符串，用于拼接

                // 处理多位数
                keepNum += ch;

                // 如果ch已经是expression的最后一位，就直接入栈
                if(index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else
                // 判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                if(operaStack.isOpera(expression.substring(index+1,index+2).charAt(0))) {
                    // 如果后一位是运算符就入栈
                    numStack.push(Integer.parseInt(keepNum));
                    // 必须将keep清空
                    keepNum = "";
                }
            }
            // 让index + 1，并判断是否扫描到expression最后
            index++;
            if(index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕后，就顺序的从numStack和operaStack中pop出相应的数和符号，并运算
        while (true) {
            // 如果符号栈为空，则计算得到最后的结果，数栈中就只有一个数字
            if(operaStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            opera = (char) operaStack.pop();
            res = numStack.cal(num1,num2,opera);
            numStack.push(res);
        }
        // 将数栈最后的数出栈，就是结果
        System.out.println("表达式 = "+numStack.pop());
    }
}
