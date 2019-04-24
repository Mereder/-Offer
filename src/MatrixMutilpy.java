import java.lang.reflect.Array;
import java.util.ArrayList;

public class MatrixMutilpy {
    public static int  p[] = {30,35,15,5,10,20};
    // n 是数字的长度  而实际矩阵个数为 n-1
    public static int n = p.length;
    public static int m[][] = new int[n][n];
    public static int s[][] = new int [n][n];
    // 递归形式
    // 递推方程为： m[i][j] = min{m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j]}  i<= k <j
    public static int recurMatrixChain(int []p,int i,int j){
        if(j == i) {
            m[i][j] = 0;
            s[i][j] = i;
            return m[i][j];
        }
        for (int k = i; k < j; k++) {
            int q = recurMatrixChain(p,i,k)+recurMatrixChain(p,k+1,j)
                    + p[i-1]*p[k]*p[j];
            if (q < m[i][j]){
                m[i][j] = q;
                s[i][j] = k;
            }
        }
        return m[i][j];
    }
    // 迭代实现
    public static int IteratorMatrixChain(int p[]){
        // 提前都 m[][] = 0 相当于 处理了r=1 的情况
        // r 取值 为 2 3 4 5  < n=6 r 表示矩阵链规模，r=2 表示 A1*A2  A2*A3 r=3 表示 A1*A2*A3
        for (int r = 2; r < n;r++){
            // 以 r=2 为例  n-r+1 = 6-2+1 = 5   i取值为 1 2 3 4
            // 含义就是 第几个链 r=2时： i=1 表示  A1*A2  i=2 表示A2*A3
            for (int i = 1; i < n-r+1 ; i++) {
                int j = i+r-1;
                // 先计算一个  填到 m[k][l] 上 之后填的时候 比较大小
                // 比如 r=3 i=1时j=3 A1*A2*A3 下面先计算了 A1（A2*A3）
                // m[i][i] = 0  可以省去不写
                m[i][j] = m[i][i] + m[i+1][j] + p[i-1]*p[i]*p[j];
                s[i][j] = i;
                // 上边相等于计算了 k=i的情况  下面k 从i+1开始;
                // 到j-1
                for (int k = i+1; k < j; k++) {
                    int temp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(temp < m[i][j]){
                        m[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m[1][n-1];
    }

    public static ArrayList<Integer> find(){
        ArrayList<Integer> result = new ArrayList<>();
        int i = 1;
        int j = n-1;
        while(true){
            int t = s[i][j];
            result.add(t);
            j = t;
            if(i == j) break;
        }
        return result;
    }
    public static void main(String[] args) {
        MatrixMutilpy test = new MatrixMutilpy();
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n ; l++) {
                m[k][l] = Integer.MAX_VALUE;
                s[k][l] = 0;
            }
        }
        int result = test.recurMatrixChain(p,1,p.length-1);
        System.out.println(result);

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n ; l++) {
                m[k][l] = 0;
                s[k][l] = k;
            }
        }
        MatrixMutilpy test1 = new MatrixMutilpy();
        int result2 = test1.IteratorMatrixChain(p);
        System.out.println(result2);

        ArrayList<Integer> res = find();
        System.out.println(res);
    }
}
