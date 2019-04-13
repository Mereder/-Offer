


import java.util.Arrays;

    /**
     * Created by chengxiao on 2016/12/17.
     * 堆排序demo
     */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        // 大根堆， 把最大的 调整到最后
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int a[]){
        int n = a.length;
        // 第一个非叶结点 从下向上  是 建堆
        for (int i = n/2-1; i>=0;i--) {
            // 实际上是 调用一次 只会调整 i 为根的树
            adjustHeap(a,i,n);
        }
        // 每次排出来一个
        for (int i = n-1; i >=0  ; i--) {
            // 同一个i 在两个地方 含义不同
            // sawp 是把 0 和 第 i 位置交换
            swap(a,0,i);
            // 调整，只需要调整 前 i 棵数
            // 此处调整是 从根向下 全面调整
            adjustHeap(a,0,i);
        }
    }
    public static void adjustHeap(int a[],int i,int len ){
        int temp = a[i];
        // k 是i的左孩子 k=k*2+1 是 下一次调整的结点
        for (int k = i*2+1;k<len;k=k*2+1){
            // 右孩子大
            if(a[k] < a[k+1] && k+1 < len){
                k++;
            }
            // 将大的孩子给 i 结点
            if( a[k] > temp ){
                a[i] = a[k];
                i = k;
            }
            // 如果左右孩子都比 i 小 直接 break;
            else break;
        }
        a[i] = temp; // 赋值给 子结点
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}

