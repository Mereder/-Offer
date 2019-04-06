public class duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int temp = 0;
        boolean exchange = false;
        int i = 0;

        while(i < length){
            if (numbers[i] == i){
                i++;
            }
            else {
                if (numbers[numbers[i]] == numbers[i] ){
                    duplication[0] = numbers[i];
                    exchange = true;
                    break;
                }
                else {
                    temp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[temp] = temp;
                    // 注意点
                }
            }
        }
        return exchange;
    }

    public static void main(String[] args) {
        int [] num = {2,1,3,1,4};
        int len = 5;
        int [] re = new int[2];
        boolean result = duplicate(num,len,re);
        System.out.println(result);
    }
}
