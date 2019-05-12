public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int n = sequence.length;
        if(n <= 0 && sequence == null ) return false;
        return helper(sequence,0,n-1);
    }

    public boolean helper(int []sequence,int lo ,int hi){
        if (lo >= hi ) return  true;
        int root = sequence[hi];
        int i = lo;
        while (i < hi){
            if (sequence[i] > root) break;
            i++;
        }
        int j = i;
        while (j < hi){
            if (sequence[j] < root) return false;
            j++;
        }

        return helper(sequence,lo,i-1) && helper(sequence,i,hi-1);
    }

    public static void main(String[] args) {
        int test[] =  {3,7,5,18,15,10};
        new VerifySquenceOfBST().VerifySquenceOfBST(test);
    }
}
