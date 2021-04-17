package A1_SparseArray;

/**
 * 【压缩】
 * 实现二维数组--->稀疏数组
 *todo:将稀疏数组保存在磁盘，并读取
 */
public class SparseArray {
    /**
     * 打印数组
     * @param arr
     */
    public static void showArr(int[][] arr){
        for (int[] row:arr) {
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        //创建一个二维数组:1-->黑子  2-->蓝子
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        System.out.println("原始的二维数组如下：");
        /*for (int i = 0;i<11;i++){
            for (int j = 0;j<11;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }*/
        showArr(arr);

        //【将二维数组转换为稀疏数组】
        //1.遍历二维数组得出稀疏数组的第一行：总行数  总列数  总有效值
        int sum = 0;//总有效值
        for(int[] row:arr){
            for(int data:row){
                if(data!=0) sum++;
            }
        }
        System.out.println("原二维数组的有效值："+sum+" 个");
        int[][] spArr = new int[sum+1][3];
        //todo:[笔记]二维数组：行数=数组名.length,列数=数组名[0].length;
        spArr[0][0]=arr.length;
        spArr[0][1]=arr[0].length;
        spArr[0][2]=sum;

        //2.将有效值存入稀疏数组
        //todo:[笔记]因为存入的时候行数要一直变，所以我们定义一个count用于记录是第几个非零数据
        int count = 0;
        for (int i =0;i<arr.length;i++){
            for (int j =0;j<arr[0].length;j++){
                if(arr[i][j]!=0){
                    count++;
                    spArr[count][0]=i;
                    spArr[count][1]=j;
                    spArr[count][2]=arr[i][j];
                }
            }
        }
        //3.打印一下稀疏数组
        System.out.println("稀疏数组如下：");
        showArr(spArr);
    }
}
