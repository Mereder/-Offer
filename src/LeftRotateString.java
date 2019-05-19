public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str == null) return null;
        int len = str.length();
        char[] arr = str.toCharArray();
        reverse(arr,0,n-1);
        reverse(arr,n,len-1);
        reverse(arr,0,len-1);

        String result = String.copyValueOf(arr);
        System.out.println(result);
        System.out.println(arr.toString());

        return result;
    }

    public void reverse(char[] arr,int i,int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        LeftRotateString test = new LeftRotateString();
        test.LeftRotateString(str,2);

    }
}
