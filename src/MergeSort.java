public class MergeSort {

    public static void divide(int a[],int as[],int lo,int hi){
        if (lo >= hi) return;
        int mid = lo + (hi-lo) / 2;
        // 自顶向下  先划分  2 个一对 然后 merge  merge
        divide(a,as,lo,mid);
        divide(a,as,mid+1,hi);
        merge(a,as,lo,mid,hi);
    }

    public static void merge(int a[],int as[],int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        int k = lo;
        while(i<=mid && j <= hi){
            if (a[i] <= a[j]){
                as[k++] = a[i++];
            }
            else {
                as[k++] = a[j++];
            }
        }
        while (i <= mid) as[k++] = a[i++];
        while (j <= hi ) as[k++] = a[j++];
        for (int z = lo; z <= hi; z++){
            a[z] = as[z];
        }
    }

    public static void main(String[] args) {
//        int a[] = {5,4,8,7,6,3,2,1};
//        int n = a.length;
//        int assist[] = new int[n];
//        MergeSort.divide(a,assist,0,n-1);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
        double test = 0.03;
        System.out.println(Double.compare(test, 0.02));
        int a = 9;
        System.out.println(a<<1);
    }
}
