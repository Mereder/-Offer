public class ReorderOddEven {
    //
    public void reOrderArray(int [] array) {
        int n = array.length;
        if (n <= 0 || array == null) return;
        int i = 0;
        int j = n-1;
        while (true){
            while ((array[i] & 0x1) != 0 && i<j) i++;
            while((array[j]&0x1)==0 && i<j) j--;
            if (i >= j) break;
            swap(array,i,j);
        }
    }

    public void swap(int array[],int i,int j){
        int temp = array[i];
        array[j] = array[i];
        array[i] = temp;
    }

    public void reOrderArray_buble(int array[]){
        int n = array.length;
        if (n <= 0 || array == null) return;

        for (int i = 0; i < n-1; i++) {
            boolean isExch = false;
            for (int j = 0; j < n-1; j++) {
                if((array[j]&0x1) == 0 && (array[j+1]&0x1) != 0){
                    swap(array,j,j+1);
                    isExch = true;
                }
            }
            if (!isExch){
                break;
            }
        }
    }
}
