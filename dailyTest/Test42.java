package com.github.dailyTest;

import java.util.*;

/**
 * @ClassName Test42
 * @Description TODO  DNA序列，一个DNA序列由A/C/G/T四个字母的排列组合组成。
 *              G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数
 *              除以总的字母数目（也就是序列长度）。在基因工程中，在各个比例十分重要
 *              因为高的GC-Ratio可能是基因的起始点
 *              给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中
 *              找出GC-Ratio最高的子序列。
 * @Author L
 * @Date 2019/7/20 13:08
 * @Version 1.0
 **/
public class Test42 {

    public static double maxGCRatio(char[] s) {
        double count = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] == 'G' || s[i] == 'C') {
                count++;
            }
        }
        return count / s.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            int n = Integer.parseInt(in.nextLine());
            List<char[]> result = new LinkedList<>();
            List<Double> ratioRes = new LinkedList<>();
            for (int i = 0; i <= str.length() - n; i++) {
                int k = 0;
                char[] a = new char[n];
                for (int j = i; j <= i+n-1; j++) {
                    a[k++] = str.charAt(j);
                }
                result.add(a);
            }
            for (char[] chars : result) {
                double ratio = maxGCRatio(chars);
                ratioRes.add(ratio);
            }
            int max = 0;
            for (int i = 1; i < ratioRes.size(); i++) {
                if(ratioRes.get(i) > ratioRes.get(max)) {
                    max = i;
                }

            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                if(i == max) {
                    for (int j = 0; j < result.get(i).length; j++) {
                        sb.append(result.get(i)[j]);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
