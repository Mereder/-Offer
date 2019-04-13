public class QuickSort {
    public static void quicksort(int a[],int lo,int hi){
        if (lo >= hi) return;
        int mid = partation(a,lo,hi);
        quicksort(a,lo,mid-1);
        quicksort(a,mid+1,hi);
    }

    public static int partation(int []a,int lo,int hi){
        int i = lo;
        int j = hi + 1;
        while(true){
            // 若一趟有序则 退出
            while(a[++i] < a[lo]) if (i == hi) break;
            while(a[--j] > a[lo]) if( j == lo) break;
            if (i >= j) break;
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = {5,4,8,7,6,3,2,1};
        int len = a.length;
        QuickSort.quicksort(a,0,len-1);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
    }
}
