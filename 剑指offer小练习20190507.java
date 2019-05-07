/**  跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/

/**解题思路：先将跳各级台阶的跳法列出来，寻找规律：
1级台阶   1种跳法
2级台阶   2种跳法
3级台阶   3种跳法
4级台阶   5种跳法
5级台阶   8种跳法
6级台阶   13种跳法
从这些数字中我们可以发现，从第三级台阶开始，跳法都是前两级台阶跳法之和，
相当于斐波那契数列，由此可知可以利用递归来解决。*/
//递归方法
public class Solution {
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target-2);
    }
}

//动态规划
public class Solution {
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        int num = 0;
        int jumpFnum1 = 1;
        int jumpFnum2 = 2;
        for(int i = 3 ; i <= target ; i++) {
            num = jumpFnum1 + jumpFnum2;
            jumpFnum1 = jumpFnum2;
            jumpFnum2 = num;
        }
        return num;
    }
}

/**  变态跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。*/

/**解题思路：先将跳各级台阶的跳法列出来，寻找规律：
1级台阶   1种跳法
2级台阶   2种跳法
3级台阶   4种跳法
4级台阶   8种跳法
5级台阶   16种跳法
6级台阶   32种跳法
从这些数字中我们可以发现，从第三级台阶开始，跳法都是前两级台阶跳法之和，再加上1
由此可知可以利用递归来解决。*/

public class Solution {
    public int JumpFloorII(int target) {
        if(target <= 2) {
            return target;
        }
        int num = 0;
        for(int i = 1;i<target;i++) {
            num += JumpFloorII(target - i);
        }
        return num+1;
    }
}

/**矩形覆盖*/
/**我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/
/**解题思路：此题相当于跳台阶，即是斐波那契数列。利用递归解决。*/
//递归问题都可以利用动态规划来解决
//递归方法
public class Solution {
    public int RectCover(int target) {
        if(target <= 2) {
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}

//动态规划
public class Solution {
    public int RectCover(int target) {
        if(target <= 2) {
            return target;
        }
        int rectCover1 = 1;
        int rectCover2 = 2;
        int num = 0;
        for(int i = 3;i<=target;i++) {
            num = rectCover1 + rectCover2;
            rectCover1 = rectCover2;
            rectCover2 = num;
        }
        return num;
    }
}

