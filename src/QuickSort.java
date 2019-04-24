import java.util.Arrays;

public class QuickSort {
    public static void quicksort(int a[],int lo,int hi){
        if (lo >= hi) return;
        int mid = partition2(a,lo,hi);
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


    public void quickSort_1(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort_1(data, start, index - 1);
        }
        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
    }
    // 算法导论的方法
    private int partition(int[] data, int start, int end) {
        int index = start + (int)(Math.random() * (end - start + 1));
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }
    // 引入随机
    public static int partition2(int []a,int lo,int hi){
        // math.random 返回[0.0,1.0)的double 值
        int index = lo + (int)(Math.random()*(hi-lo+1));
        swap(a,lo,index);
        int key = a[lo];
        while(lo < hi ){
            while(a[hi] > key && hi > lo){
                hi--;
            }
            a[lo] = a[hi];
            while(a[lo] < key && hi > lo){
                lo++;
            }
            a[hi] = a[lo];
        }
        a[hi] = key;
        return hi;
    }
    // 三个数 取中值。
    public int partition3(int a[],int lo,int hi){
        int mid = lo+(hi-lo)>>1;
        // 让mid 是 介于  a[hi] 和 a[lo] 之间的数
        if (a[mid] > a[hi]) swap(a,mid,hi);
        if(a[mid] < a[lo]) swap(a,mid,lo);
        // 此时确保a[lo] < a[mid] < a[hi] 再交换给  lo
        if (a[mid] > a[lo]) swap(a,mid,lo);
        int key = a[lo];
        while(lo < hi){
            while(a[hi] > key && hi > lo ) hi--;
            a[lo] = a[hi];
            while(a[lo] < key && hi > lo) lo++;
            a[hi] = a[lo];
        }
        a[hi] = key;
        return hi;
    }
    public static void shuffle(int a[]){
        int n = a.length;
        for (int i = n; i > 0 ; i--) {
            int index =(int)(Math.random()*i);
            swap(a,index, i-1);
        }
    }

    public static void main(String[] args) {
//        int a[] = {5,4,8,7,6,3,2,1};
        int a[] = {1,2,3,4,5,6,7,8};
        int len = a.length;
        shuffle(a);

        QuickSort.quicksort(a,0,len-1);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
        int test= partition2(a,0,len-1);
        System.out.println(test);
        System.out.println(Math.random());
    }
}
