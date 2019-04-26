package 栈和队列习题;

import 队列.MyQueue;

/**
 * @ClassName TestMyStack
 * @Description 队列实现栈
 * @Author L
 * @Date 2019/4/25 20:23
 * @Version 1.0
 **/
public class TestMyStack {

    private MyQueue myQueue1;
    private MyQueue myQueue2;
    private int usedSize;

    public TestMyStack() {
        this.myQueue1 = new MyQueue();
        this.myQueue2 = new MyQueue();
        this.usedSize = 0;
    }

        /** 入栈 谁不为空入到谁里面*/
        public void push(int x) {
            if (!myQueue1.empty()) {
                myQueue1.add(x);
            }else if(!myQueue2.empty()){
                myQueue2.add(x);
            }else {
                myQueue1.add(x);
            }
            this.usedSize++;
        }

        //出栈
        public int pop() {
            if(empty()){
                return -1;
            }
            int data = 0;
            if(!myQueue1.empty()) {
                for (int i = 0; i < this.usedSize-1; i++) {
                    myQueue2.add(myQueue1.poll());
                }
                data = myQueue1.poll();
            }else if(!myQueue2.empty()) {
                for (int i = 0; i < this.usedSize-1; i++) {
                    myQueue1.add(myQueue2.poll());
                }
                data =  myQueue2.poll();
            }
            this.usedSize--;
            return data;
        }

        /** 得到栈顶元素 */
        public int top() {
            //首先判断是否为空
            if(empty()) {
                return -1;
            }
            int data = 0;
            if(!myQueue1.empty()) {
                for (int i = 0; i < usedSize; i++) {
                    data = myQueue1.poll();
                    myQueue2.add(data);
                }
            }else if(!myQueue2.empty()) {
                for (int i = 0; i < usedSize; i++) {
                    data = myQueue2.poll();
                    myQueue1.add(data);
                }
            }
            return data;
        }

        public boolean empty() {
            return this.usedSize == 0;
        }

        public int size(){
            return this.usedSize;
        }
}
