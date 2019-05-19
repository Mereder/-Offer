import java.util.ArrayList;

public class ReverseSentence {
    // Java 中 String 不可变，只能更换为别的类型进行修改然后再改回来。
    /*
    //String 转换成char[]
　　strToChars= str.toCharArray();

　　//char[] 转换成String
　　str= String.valueOf(strToChars);
　　str=new String(strToChars);

    注：这里char[]转换成String时不能直接使用strToChar.toString()，
    因调用toString()方法实际是调用Object类的toString()方法，往往得不出想要的结果。
　　public String toString() {
　　　　return getClass().getName() + "@" + Integer.toHexString(hashCode());
　　}
　　而需要进一步使用toString()还需将其重载。
     */
    public String ReverseSentence(String str) {
        int n = str.length();
        if(n <= 0) return str;
        char[] arr = str.toCharArray();
        reverse(arr,0,n-1);
        int i = 0,j=0;
        while(i < n ){
            if (j == n){
                reverse(arr,i,j-1);
                break;
            }
            else if (arr[j] == ' ' || arr[j] == '\n'){
                reverse(arr,i,j-1);
                i = j+1;
                j = i;
            }
            else {
                j++;
            }
        }
        return new String(arr);
    }
    public void reverse(char[] str,int lo,int hi){
        while(lo < hi) {
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        String test = "i am a student.";
        ReverseSentence reverseSentence = new ReverseSentence();
        String resulut = reverseSentence.ReverseSentence(test);
        System.out.println(resulut);
    }
}
