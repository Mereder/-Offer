import java.util.ArrayList;

public class printMatrix {
    public static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null) return null;
        int n = matrix.length;
        if (n <= 0  ) return result;
        int m = matrix[0].length;
        if (m <=  0 ) return result;

        int start = 0;

        while (n > start*2 && m > start*2){
            travelMatrix(matrix,start,n,m);
            start++;
        }
        return result;
    }

    public static void travelMatrix(int Matrix[][],int start,int n,int m){
        int endX = m-1-start;
        int endY = n-1-start;

        for (int i = start; i <= endX; i++) {
            result.add(Matrix[start][i]);
        }

        if (start<endY){
            for (int i = start+1; i <= endY; i++) {
                result.add(Matrix[i][endX]);
            }
        }
        if (endX > start && endY > start){
            for (int i = endX-1; i >= start ; i--) {
                result.add(Matrix[endY][i]);
            }
        }

        if (endX>start && endY-start>1){
            for (int i = endY-1; i > start ; i--) {
                result.add(Matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int ma[][] = {{1,2,3,4,5}};
        printMatrix.printMatrix(ma);
    }
}
