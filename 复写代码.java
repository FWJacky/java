public Node detectCycle() {
	Node fast = this.head;
	Node slow = this.head;
	while(fast != null && fast.next !=null) {
		if(fast == slow) {
			break;
		}
		fast = fast.next.next;
		slow = slow.next;
	}
	if(fast == null || fast.next == null) {
		return null;
	}
	slow = this.head;
	while(fast != slow) {
		fast = fast.next;
		slow = slow.next;
	}
	return slow;
}

public Node reverseList() {
	Node cur = this.head;
	Node pre = null;
	Node reverseHead = null;
	if(cur == null || cur.next == null) {
		return cur;
	}
	while(cur != null) {
		Node curNext = cur.next;
		if(curNext == null) {
			reverseHead = cur;
		}
		cur.next = pre;
		pre = cur;
		cur = curNext;
	}
	return reverseHead;
}

public Node reverseList() {
	Node cur = this.head;
	Node pre = null;
	while(cur != null) {
		Node curNext = cur.next;
		cur.next = pre;
		pre = cur;
		cur = curNext;
	}
	return pre;
}

public Node reverseList(Node cur) {
	if(cur == null || cur.next == null) {
		return cur;
	}
	Node p = reverseList(cur.next);
	cur.next.next = cur;
	cur.next = null;
	return p;
}

public void push(int x) {
	if(!myQueue1.empty()) {
		myQueue1.add(x);
	}else if(!myQueue2.empty()){
		myQueue2.add(x);
	}else {
		myQueue1.add(x);
	}
	this.useSize++;
}

	//栈
public class MyStackImpl implements IMyStack {
	private int top;
	private int usedSize;
	private int[] elem;
	
	public MyStackImpl(int x) {
		this.top = 0;
		this.usedSize = 0;
		this.elem = new int[x];
	}
	
	//入栈
	 public void push(int item) {
		this.elem[this.top++] = item;
		this.usedSize++;
	}
	
	//栈顶元素出战
	public int pop() { 
		if(this.top == 0) {
			throw new UnsupportedOperationException("栈为空");
		}
		int data = this.elem[this.top-1];
		this.top--;
		this.usedSize--;
		return data;
	}
	
	//得到栈顶元素，不出栈
	public int peek() {
		if(this.top == 0) {
			throw new UnsupportedOperationException("栈为空");
		}
		int data = this.elem[this.top-1];
		return data;
		//return this.elem[this.top-1];
	}
	
	//判断栈是否为空
	public boolean empty() {
		return this.top == 0;
	}
	
	//栈长度
	public int size() {
		return this.usedSize;
	}

//队列	 队列可以用数组和链表来实现   链表实现队列更为优化些
public class MyQueue implements IMyQueue {
	//创建内部类  来使用节点完成队列
	class Node {
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	//头节点——相当于队头
	private Node front;
	//尾节点——相当于队尾
	private Node rear;
	//有效数字
	private int usedSize;
	public MyQueue() {
		this.front = null;
		this.rear = null;
		this.usedSize = 0;
	}
	
	//队列是否为空
	public boolean empty() {
        return this.usedSize == 0;
	}
	
	//取得栈顶元素
	public int peek() {
		if(empty()) {
			throw new UnsupportedOperationException("队列为空");
		}
		return this.front.data;
	}
	
	//出栈   队头出栈
	public int poll() {
		if(empty()) {
			throw new UnsupportedOperationException("队列为空");
		}
		int data = this.front.data;
		//如果只有一个有效数字时
		if(this.usedSize == 1) {
			this.front = null;
			this.rear = null;
		}else {
			this.front = this.front.next;
		}
		this.usedSize--;
		return data;
	}
	
	//入队  队尾入队
	public void add(int item) {
		Node node = new Node(item); 
		if(empty()) {
			this.front = node;
			this.rear = node;
		}else {
			this.rear.next = node;
			this.rear = node;
		}
		this.usedSize++;
	}
	
	//队列长度
	public int size() {
		return this.usedSize;
	}
}


//用两个队列来实现栈
public class MyStack {
    
    private int usedSize;
    private MyQueue myQueue1;
	private MyQueue myQueue2;

    /** Initialize your data structure here. */
    public MyStack() {
        this.myQueue1 = new myQueue();
		this.myQueue2 = new myQueue();
		this.usedSize = 0;
    }
    
	//谁不为空 入栈入到谁中
    /** Push element x onto stack. */
    public void push(int x) {
        if(!myQueue1.empty()) {
			myQueue1.add(x);
		}else if(!myQueue2.empty()) {
			myQueue2.add(x);
		}else {
		myQueue1.add(x);
		}
		this.usedSize++;
    }
    
	//出栈  因为以队列的性质为主：即队列为先进先出
	//假设 数据为  12  35  65   栈顶元素应该为12  而不是65   因为要根据队列的先进先出原则
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
			throw new UnsupportedOperationException("栈为空");
		}
		int data = 0;
		if(!myQueue1.empty()) {
			for(int i = 0;i < this.usedSize-1;i++) {
				myQueue2.add(myQueue1.pop());
			}
			data = myQueue1.pop();
		}else if(!myQueue2.empty()) {
			for(int i = 0;i < this.usedSize-1;i++) {
				myQueue1.add(myQueue2.pop());
			}
			data = myQueue2.pop();
		}
		this.usedSize--;
		return data;
	}
    
	//得到栈顶元素
    /** Get the top element. */
    public int top() {
        if(empty()) {
			throw new UnsupportedOperationException("栈为空");
		}
		int data = 0;
		if(!myQueue2.empty()) {
			for (int i = 0;i<this.usedSize;i++) {
			data = myQueue2.pop();
				myQueue1.add(data);
			}
		}else if(!myQueue1.empty()) {
			for(int i = 0;i<this.usedSize;i++) {
				data = myQueue1.pop();
				myQueue2.add(data);
			}
		}
		return data;	
    }
    
	//判断栈是否为空
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.usedSize == 0;
    }
}

//用栈来实现队列
class MyQueue {

	private int this.usedSize;
	private MyStack myStack1;
	private MyStack myStack2;
	
	/** Initialize your data structure here. */
    public MyQueue() {
        this.usedSize = 0;
		this.myStack1 = new MyStack();
		this.myStack2 = new MyStack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        myStack1.push(x);
		this.usedSize++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) {
			return -1;
		}
		int data = 0;
		if(myStack2.empty()) {
			while(!myStack1.empty()) {
				myStack2.push(myStack1.pop())
			}
		}
		if(!myStack2.empty()) {
			data = myStack2.pop();
		}
		this.usedSize--;
		return data;
    }
    
    /** Get the front element. */
    public int peek() {
        if(empty()) {
			return -1;
		}
		int data = 0;
		if(myStack2.empty()) {
			while(!myStack1.empty()) {
				myStack2.push(myStack1.pop());
			}
		}
		if(!myStack2.empty()) {
			data = myStack2.peek();
		}
		return data;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.usedSize == 0;
    }
}

//最小栈
class MinStack {

	private MyStack myStack;
	private MyStack minStack;
	
    /** initialize your data structure here. */
    public MinStack(int x) {
		this.myStack = new MyStack(x);
		this.minStack = new MyStack(x);
    }
    
	//入栈   直接入到myStack中  而入到minStack中是有条件的   只有当x<=minStack.peek()时 才将x入栈
    public void push(int x) {
        myStack.push(x);
		if(minStack.empty()) {
			minStack.push(x);
		}else {
			if(x<=minStack.peek()) {
				minStack.push(x);
			}
		}	
    }
    
	//出栈不是出最小栈
    public void pop() {
        //if(myStack.empty()) {
			//throw new UnsupportedOperationException("栈为空");
		//}
		//或者
		if(!myStack.empty()) {
			int data = myStack.pop();
			if(data == minStack.peek()) {
				minStack.pop();
			}
		}
    }
    
	//得到栈顶元素，不是得到最小栈
    public int top() {
        if(myStack.empty()) {
			throw new UnsupportedOperationException("栈为空");
		}else {
			return myStack.peek();
		}
    }
    
	//得到最小栈
    public int getMin() {
		return minStack.peek();
    }
}


//设计循环队列
public class MyCircularQueue() {
	private int front;
	private int rear;
	//用数组实现循环队列队列
	private int[] elem;
	//队列长度
	private int size;
	//队列元素个数
	private this.usedSize;
	
	public MyCircularQueue(int k) {
		this.front = 0;
		this.rear = 0;
		//队列最后一个不存数据，用来防止队列满的情况，如果要存k个数据，必须要k+1个数组长度
		this.elem = new int[k+1];
		this.size = k+1;
		this.usedSize = 0;
	}
	
	//入队
	public boolean enQueue(int value) {
		if(isFull()) {
			return false;
		}
		this.elem[this.rear] = value;
		this.rear = (this.rear+1)%size;
		this.usedSize++;
		return true;
	}
	
	//出队
	public boolean deQueue() {
		if(empty()) {
			return false;
		}
		this.front = (this.front+1)%size;
		this.usedSize--;
		return true;
	}
	
	//得到栈顶元素
	public int front() {
		if(empty()) {
			throw new UnsupportedOperationException("队列为空");
		}
		return this.elem[this.front];
	}
	
	//得到队尾元素
	public int Rear() {
		if(empty()) {
			throw new UnsupportedOperationException("队列为空");
		}
		int index = this.rear == 0 ? this.size - 1 : this.rear - 1;
		return this.elem[index];
	}
	
	//检查队列是否为空
	public boolean isEmpty() {
		return this.front == this.rear;
	}
	
	//检查队列是否为满
	public boolean isFull() {
		if((this.rear+1)%size == this.front) {
			return false;
		}
		return true;
	}
}

//直接插入排序   时间复杂度为：O(n^2)   空间复杂度为：O(1)
/**直接插入排序的方法思路为:设置两个下标，一个i，一个j，i下标从start+1开始，j下标从i-1开始，
*将array[i]的值先保存在tmp中，然后找i下标前大于tmp的值，再将大于tmp值放到i的下标处，即array[i] = array[j];
*一直到没有大于tmp的值处结束。
**/
class InsertSort {
	public static void insertSort(int[] array,int start,int end) {
		int i = start + 1;
		for	( i = start + 1;i <= end;i++) {
			int tmp = array[i];
			int j = 0;
			for(j = i-1;j >= 0;j--) {
				if(array[j] > tmp) {
					array[j+1] = array[j];
				}else {
					break;
				}
			}
			array[j+1] = tmp;
		}
	}
	
//希尔排序 时间复杂度为：O(n^1.3~n^1.5)   空间复杂度为：
class shellSort {
	//进行分组
	public static void shellSort(int[] array) {
		int[] drr = {5,3,1};
		for(int i = 0;i<drr.length;i++) {
			shell(array,drr[i]);
		}
	}
	//希尔排序主体   直接插入排序
	public static void shell(int[] array,int gap) {
		int tmp = 0;
		for(int i = gap ; i < array.length ; i++) {
			tmp = array[i];
			for(int j = i-gap ; j >= 0;j-=gap) {
				if(array[j] > tmp) {
					array[j+gap] = array[j];
				}else {
					break;
				}
			}
			array[j+gap] = tmp;
		}
	}
}
	
//直接选择排序
class SelectSort {
	public static void selectSort(int[] array) {
		for(int i = 0;i<array.length;i++) {
			for(int j = i+1;j<array.length;j++) {
				if(array[j] < array[i]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
		
public static int partion(int[] array,int low,int high) {
	int tmp = array[low];
	while(low<right) {
		while((low<high) && array[high] > tmp) {
			high--;
		}
		if(array[high] < tmp) {
			array[low] = array[high];
			array[high] = tmp;
		}
		if(high == slow) {
			break;
		}
		while((low<high) && array[low] < tmp){
			low++;
		}
		if(array[low] > tmp) {
			array[high] = array[low];
			array[low] = tmp;
		}
		if(high == slow) {
			break;
		}
	}
	array[low] = tmp;
	return tmp;
}
		
	
		
	