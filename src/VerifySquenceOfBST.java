public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int n = sequence.length;
        if(n <= 0 && sequence == null ) return false;
        return helper(sequence,0,n-1,n);
    }

    public boolean helper(int []sequence,int lo ,int hi,int length){
        if (length <= 0 ) return  false;
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
        boolean left = true;
        if (i < hi){
            left = helper(sequence,lo,j-1,j-i);
        }
        boolean right = true;
        if(j < hi){
            right = helper(sequence,j,hi,length-i-1);
        }
        return (left && right);
    }
}
