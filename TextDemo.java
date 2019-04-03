public class TextDemo {
	/*public static boolean isLeapYear(int year) {
		if(year%4==0&&year%100!=0||year%400==0) {
			return true;
		}
		return false;
	}*/
	//public static void main(String[] args) {
		/*for(int year=2000;year<=3000;year++){
			if(isLeapYear(year)){
				System.out.println(year);*/
			//}
		//}
	//}
	// class Student {
		// public int age;  //public variable
	// }
	
	public static boolean isLeapYear(int year) {
		if(year%4 == 0 && year%100 != 0) {
			return true;
		}
		return false;
	}
	public static void main1(String[] args){
		for(int year=1000;year<=2000;year++){
			if(isLeapYear(year)) {
				System.out.println(year);
			}
		}
	}

	public static void main2(String[] args) {
		// int i=3;
		// String str = "gao";
		// long i = 3L;
		// switch (i) {
		// 		case 1L:
		// 		System.out.println("2");
		// 		break;
		// 		case 2L:
		// 		System.out.println("3");
		// 		// break;
		// 		case 3L:
		// 		System.out.println("1");
		// 		// break;
		// 		default:
		// 		System.out.println("worning!");
		// 		break;
		// }
	}

	//写一个函数：求1-100的和，1-100奇数的和，1-100偶数的和
	public static void function(int n) {  //这里的函数相当于C语言中无返回值的函数，再函数体内部输出
		int sum=0;
		int sumOdd=0;
		int sumEve=0;
		// int i=0; //已经定义了i  所以不需要再定义i了（for循环的表达式1已经定义了i）
		for(int i=1;i<=n;i++) {
			sum += i;
		}
		for (int i=1;i<=n ;i+=2 ) {
			sumOdd +=i;
		}
		for (int i=2;i<=n ;i+=2 ) {
			sumEve +=i;
		}
		System.out.println("1-100：sum== "+sum);
		System.out.println("1-100：sumOdd== "+sumOdd);
		System.out.println("1-100：sumEve== "+sumEve);
	}

	public static void function2(int n) {
		int i=1;
		int sum=0;
		int sumOdd=0;
		int sumEve=0;
		while(i<=n) {
			sum+=i;
			i+=1;
		}
		i=1;   //这里不能用 int i =1   因为数据类型 + 变量 = 1  是定义变量并初始化变量
		while (i<=n) {
			sumOdd += i ;
			i +=2;
		}
		i=2;
		while(i<=n) {
			sumEve += i;
			i +=2;
		}
		System.out.println("1-100：sum== "+sum);
		System.out.println("1-100：sumOdd== "+sumOdd);
		System.out.println("1-100：sumEve== "+sumEve);
	}

	public static void function3(int n) {
		int sum=0;
		int sumOdd=0;
		int sumEve=0;
		int i = 1;
		do {
			sum += i;
			i += 1;
		}while(i<=n);

		i=1;
		do {
			sumOdd += i;
			i += 2;
		}while(i<=n);

		i = 2;
		do {
			sumEve += i;
			i += 2;
		}while(i<=n);

		System.out.println("1-100：sum== "+sum);
		System.out.println("1-100：sumOdd== "+sumOdd);
		System.out.println("1-100：sumEve== "+sumEve);
	}

	//找出1-n之内，既能被3整除，也能被5整除的数字
	public static void function4(int n) {
		for (int i=0;i <= n ;i++ ) {
			if(i%15!=0) {
				continue;
			}
			System.out.println(i);
		}
		// return;
	}

	//打印乘法口诀表
	// public static void mutiTable(int n) {
	// 	for(int i=1;i<= n;i++) {  //行数
	// 		for(int j=1;j<=i;j++) {  //列数
	// 			System.out.print(i+"*"+j+"="+i*j+"\t");
	// 		}
	// 		System.out.print("\n");
	// 	}
	// }

	// public static int add (int a,int b) {
	// 	// return a+b;
	// 	System.out.println(a+b);
	// }


	public static void main(String[] args) {
		function4(100);

		// TextDemo textDemo = new TextDemo();  //定义生产对象
		// function4(100);
		// textDemo.function4(100);  //.function4  引用function函数
		// mutiTable(9);
		// for (int i=0;i<10;i++) {
		// 		if(i==3){
		// 			break;
		// 		}
		// 	System.out.println("hello bit");
		// }	



		//至少会执行一次
		// do {
		// 	System.out.println("hello bit");
		// }while(i<2);
		// while (i<2) {
		// 	System.out.println("hello bit");
		// 	i ++ ;
		// }
		// function3(100);
	



		// for ( int i=0;i<10;i++) {
		// 	System.out.println("hello bit");
		// }
	}




		// if(1<2&&(10/0==0)){
			// System.out.println("条件满⾜");
		// int i=10;
		// i=++i;
		// System.out.println(i);
		
		// int x=3;
		// int y=4;
		// int result = x++ * y;		
		// System.out.println(x);
		// System.out.println(result);
		
		// int maxValue=Integer.MAX_VALUE;
		// long num = maxValue+1l;
		// int result=(int)num;
		// int minValue=Integer.MIN_VALUE;
		// System.out.println(maxValue+1);
		// System.out.println(result);
		// System.out.println(minValue-1);
		

}


