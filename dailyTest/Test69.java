package dailyTest;

import java.util.*;

/**
 * @ClassName Test69
 * @Description TODO   简单错误记录
 * @Author L
 * @Date 2019/8/5 11:48
 * @Version 1.0
 **/

/*
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1. 记录最多8条错误记录，对相同的错误记录（即文件名称和行号完全匹配）只记录一跳，错误计数增加；（文件所在的目录不同，文件名和行号相同也要合并）
 * 2. 超过16个字符的文件名称，只记录文件的最后有效16个字符；（如果文件名不同，而只是文件名的后16个字符和行号相同，不要合并）
 * 3. 输入的文件可能带路径，记录文件名称不能带路径
 * 结果根据数目从多到少排序，数目相同的情况，按照第一次出现顺序排序
 * 如果超过8条记录，则只输出前8条记录
 *
 **/
public class Test69 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while (in.hasNext()) {
            String string = in.nextLine();
            String[] strings = string.split(" ");
            String str = strings[0];
            int lineNum = Integer.parseInt(strings[1]);
            String[] error = str.split("\\\\");
            String fileName = error[error.length - 1];
            String key = fileName + " " + lineNum;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        in.close();
        // 排序
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            // 降序比较
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - (o1.getValue())) == 0 ? (o1.getValue() - o2.getValue()) : (o2.getValue() - o1.getValue());
            }
        });
        int count = Math.min(8, list.size());
        for (Map.Entry<String, Integer> entry : list) {
            if (count >= 0) {
                String[] strFileName = entry.getKey().split(" ");
                strFileName[0] = (strFileName[0].length() > 16) ? strFileName[0].substring(strFileName[0].length() - 16) : strFileName[0];
                System.out.println(strFileName[0] + " " + strFileName[1] + " " + entry.getValue());
            }
            count--;
        }
    }
}
