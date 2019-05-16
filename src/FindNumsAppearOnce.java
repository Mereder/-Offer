public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 1.数组各个数相 异或
        int n = array.length;
        if (n <= 0 )return;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= array[i];
        }

        // 2. 找到异或结果中 第一个为 1 的位
        int indexbit = findIndexBitIs1(sum);
        // 3. 根据为1的位置，分分别异或
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < n; i++) {
            // 判断 第index位上 分为 0 1
            if (isBit1(array[i],indexbit)){
                num1[0] ^= array[i];
            }
            else {
                num2[0] ^= array[i];
            }
        }
    }
    public int findIndexBitIs1(int num){
        int index = 0;
        while ((num&1) == 0 && index <= Integer.SIZE){
            num = num>>1;
            index++;
        }
        return index;
    }
    public boolean isBit1(int num,int index){
        num = num >> index;
        if ((num&1) == 0){
            return false;
        }
        else return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.SIZE);
    }

}
