/**输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。*/

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32 ; i++) {
			//输出二进制中1的个数
            int ret = (n >> i) & 1;
            if(ret == 1) {
                count ++;
            }
        }
        return count;
    }
}

/**给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。*/

public class Solution {
    public double Power(double base, int exponent) {
        double ret = 1.0;
		//首先判断exponent<0&&base==0的情况，这种情况base不合法
		if(exponent<0&&base==0) {
			throw new RuntimeException("base不能为0");
		}
        if(exponent <= 0) {
            for(int i = 0; i > exponent ; i--) {
                ret *= 1/base;
            }
        }else {
            for(int i = 0 ; i < exponent ; i++ ){
                ret *= base;
            }
        }
        return ret;
   }
}





