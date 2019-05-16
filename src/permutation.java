import java.util.*;

public class permutation {
    public static void main(String[] args) {
        String str = "abc";

        for (String a:new permutation().Permutation(str)
             ) {
            System.out.println(a);
        }

    }
    public TreeSet<String> treeSet = new TreeSet<>();
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if( str == null) return result;
        int n = str.length();
        TreeSet<String> set = new TreeSet<>();
        char[] chars = str.toCharArray();
        permutation(chars,0);
        result.addAll(treeSet);
        return result;
    }


    public void permutation(char[] chs,int i){
        if(chs == null || i<0 || i>chs.length-1) return;
        if(i == chs.length-1){
            treeSet.add(String.valueOf(chs));
        }
        else{
            for(int j =i;j<chs.length;j++){
                swap(chs,i,j);

                permutation(chs,i+1);

                swap(chs,i,j);
            }
        }

    }
    public void swap(char[] chs,int i,int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
