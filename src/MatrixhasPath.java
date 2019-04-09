import java.util.Arrays;

public class MatrixhasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(rows <=0 || str.length <=0) return true;
        boolean[] visited = new boolean[rows*cols];
        Arrays.fill(visited,false);
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix,visited,rows,cols,i,j,str,index)){
                    return true;
                }
            }
        }
        return  false;
    }

    public boolean hasPathCore(char[] matrix,boolean[] visited,int rows,int cols,int i,int j,char []str,int index){
        if (index == str.length) return true;
        boolean hasPath = false;
        if (i >= 0 && i < rows && j<cols && j >=0 && !visited[i*cols+j] && matrix[i*cols+j] == str[index]){
            index++;
            visited[i*cols + j] = true;

            hasPath = hasPathCore(matrix,visited,rows,cols,i+1,j,str,index) ||
                    hasPathCore(matrix,visited,rows,cols,i-1,j,str,index) ||
                    hasPathCore(matrix,visited,rows,cols,i,j+1,str,index) ||
                    hasPathCore(matrix,visited,rows,cols,i,j-1,str,index);

            if (!hasPath){
                index--;
                visited[i*cols+j] = false;
            }
        }
        return hasPath;
    }
}
