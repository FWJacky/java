/**在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。*/

public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i = 0;i<array.length;i++) {
              for(int j = 0;j<array[i].length;j++){
                  if(array[i][j] == target) {
                      return true;
                  }
              }
        }
        return false;
    }
}

/**请实现一个函数，
将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer tmp = new StringBuffer();
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i)!=' ') {
                tmp.append(str.charAt(i));
            }else {
                tmp.append("%20");
            }
        }
        return tmp.toString();
    }
}


/**输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。*/

import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}

