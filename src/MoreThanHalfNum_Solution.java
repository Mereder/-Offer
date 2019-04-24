public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        if(n <= 0) return 0;
        int mid = n / 2;
        int beg = 0;
        int end = n-1;
        int index = partition(array,beg,end);
        while(index != mid){

            if(index < mid){
                beg = index+1;
            }
            else{
                end = index-1;
            }
            index = partition(array,beg,end);
        }
        int result = array[mid];
        if(check(array,result,mid)) return result;

        return 0;
    }
    public boolean check(int []array,int res,int mid){
        int times = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == res){
                times++;
            }
        }
        if(times > mid) return true;

        return false;
    }
    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){ // 从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    public void swap(int []array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int []array = {1};
        MoreThanHalfNum_Solution rest = new MoreThanHalfNum_Solution();
        int result =   rest.MoreThanHalfNum_Solution(array);
        System.out.println(result);
    }
}
