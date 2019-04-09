public class NumberOf1 {
    public int NumberOf1(int n) {
        if(n == 0 ) return 0;
        int count = 0;
        while(n != 0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
