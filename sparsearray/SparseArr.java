package sparsearray;

import java.io.*;

/**
 * @ClassName
 * @Description TODO   将二维数组转变为稀疏数组，并将稀疏数组保存到磁盘的map.data文件中，再从map.data文件中读取出稀疏数组，并将稀疏数组转换为原始的二维数组
 *              TODO   实际应用在五子棋盘中
 * @Author L
 * @Date 2019/7/26 16:07
 * @Version 1.0
 **/
public class SparseArr {

    // 打印二维数组
    public static void print(int[][] chessArr) {
        for(int[] row : chessArr) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    // 得到二维数组中非零的个数
    public static int getNZ(int[][] chessArr) {
        int sum = 0;
        for (int[] row : chessArr) {
            for (int data : row) {
                if(data != 0) {
                    sum ++;
                }
            }
        }
        return sum;
    }


    // 将稀疏数组存到磁盘下的map.data中
    public static void putMap(File file,int[][] sparseArr) {
        // 1. 必须保证父目录存在
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        // 2. 进行文件传输
        try(FileWriter output = new FileWriter(file)) {
            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < sparseArr[0].length; j++) {
                    output.write(sparseArr[i][j]+ "\t");
                }
                output.write("\r\n");
            }
        }catch (IOException e) {
            System.out.println("文件压缩失败");
            e.printStackTrace();
        }
    }

    // 将稀疏数组从磁盘下的map.data中读取出来
    public static int[][] getMap(File file) {
        int[][] sparseArr = null;
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String line;
            int row = 0;
            while((line = in.readLine()) != null) {
                String[] temp = line.split("\t");
                if(sparseArr == null) {
                    sparseArr = new int[Integer.parseInt(temp[temp.length-1])+1][3];
                }
                for (int i = 0; i < temp.length; i++) {
                    sparseArr[row][i] = Integer.parseInt(temp[i]);
                }
                row++;
            }
        }catch (IOException e) {
            System.out.println("文件读取失败");
            e.printStackTrace();
        }
        return sparseArr;
    }

    // 得到稀疏数组
    public static int[][] getSparseArr(int[][] chessArr) {
        // 将二维数组 ==>  稀疏数组
        // 1. 先遍历二维数组，得到非0的个数
        int sum = getNZ(chessArr);

        // 2. 创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放在sparseArr中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        return sparseArr;
    }

    // 将稀疏数组 ==> 恢复成原始二维数组
    public static int[][] renewChessArr(int[][] sparseArr) {
        // 将稀疏数组  ==>  恢复成原始的二维数组
        /**
         思路：
         1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr = int[11][11]
         2. 再读取稀疏数组后几行的数据，并赋给原始的二维数组
         */

        // 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2. 再读取稀疏数组后几行的数据，并赋给原始的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return chessArr2;
    }

    public static void main(String[] args) {
        // 创建原始的二维数组 11 * 11
        int[][] chessArr = new int[11][11];
        // 0：表示没有旗子    1：表示黑子   2：表示蓝子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 1;
        System.out.println("原始的数组");
        print(chessArr);

        // 得到稀疏数组
        int[][] sparseArr = getSparseArr(chessArr);

        // 将稀疏数组压缩到map.data文件中
        File file = new File("D:"+File.separator+"test"+File.separator+"map.data");
        putMap(file, sparseArr);

        // 将稀疏数组从map.data文件中读取出来
        int[][] sparseArr2 = getMap(file);

        // 打印读取出来的稀疏数组
        System.out.println();
        System.out.println("读取出来的稀疏数组");
        print(sparseArr2);

        // 将提取出来的稀疏数组 转为  原始的二维数组
        int[][] chessArr2 = renewChessArr(sparseArr2);

        // 3. 打印恢复后的二维数组
        System.out.println();
        System.out.println("由读取出的稀疏数组转换而来的二维数组");
        print(chessArr2);

    }
}
