package A1_SparseArray;

/**
 * * 稀疏数组--->二维数组
 */
public class SpToArr {
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
        //手动创建那个稀疏数组
        int[][] spArr = new int[3][3];
        spArr[0][0] = 11;
        spArr[0][1] = 11;
        spArr[0][2] = 2;
        spArr[1][0] = 1;
        spArr[1][1] = 2;
        spArr[1][2] = 1;
        spArr[2][0] = 2;
        spArr[2][1] = 3;
        spArr[2][2] = 2;

        System.out.println("稀疏数组如下：");
        showArr(spArr);
        //【将稀疏数组转换为二维数组】
        //1.根据稀疏数组的第一行创建二维数组
        int[][] arr = new int[spArr[0][0]][spArr[0][1]];
        //2.遍历稀疏数组，将有效值填入二维数组
        for (int i = 1;i<spArr.length;i++){

            arr[spArr[i][0]][spArr[i][1]]=spArr[i][2];

        }
        //3.打印恢复的二维数组
        System.out.println("恢复的二维数组如下：");
        showArr(arr);
    }
}
