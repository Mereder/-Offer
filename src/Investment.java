public class Investment {
    public static int[][] mem;
    public static int[][] tag;
    private static int compute_max_invest(int[][] invest,int n,int k) {
        // i 表示 前 i个 项目  i=0是第一个项目，已经初始化 所以从i=1开始
        for (int i = 1; i < k; i++) { // 1 2 3
            // j 来表示 分配j万元
            for (int j = 1; j < n; j++) { // 0 1 2 3 4 5
                // 当分配j万元时候 在各种组合中的求最大
                int max = Integer.MIN_VALUE;
                for (int l = 0; l <= j; l++) {
                    // F_k(x) = max{ f_k(x_k) + F_{k-1}(x-x_k) }
                    // temp = 第i个项目投入l万元 + 前i-1个项目投入j-l万元
                    int temp = invest[l][i]+mem[j-l][i-1];
                    if (temp >= max){
                        mem[j][i] = temp;
                        max = temp;
                        tag[j][i] = l;
                    }
                }
            }
        }
        return mem[n-1][k-1];
    }

    public static void trace_result(int res[],int k,int n){
        int total = n-1;
        // k 是项目数
        for (int i = k-1; i >= 0; i--) {
            int temp = tag[total][i];
            total -= temp;
            res[i] = temp;
        }
    }

    public static void main(String[] args) {
        // 输入是一个n*k的矩阵
        int invest[][] ={{0,0,0,0},{11,0,2,20},{12,5,10,21},{13,10,30,22},{14,15,32,23},{15,20,40,24}};
        int n = invest.length; // 行数  表示投入 n万元 n=6 实际上是 0 1 2 3 4 5
        int k = invest[0].length; // 列数  表示 共多少个项目
        mem = new int[n][k];
        tag = new int[n][k];
        System.out.println("输入数据为");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.printf("%d ",invest[i][j]);
            }
            System.out.println();
        }
        // 初始化 将 第一个项目的资金 放入 备忘录。
        // 标记函数
        for (int i = 0; i < n; i++) {
            mem[i][0] = invest[i][0];
            tag[i][0] = i;
        }

        int result[] = new int[k];
        int max_invest = compute_max_invest(invest,n,k);
        System.out.printf("max_investion:%d\n",max_invest);
        System.out.println("备忘录如下：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.printf("%d ",mem[i][j]);
            }
            System.out.println();
        }
        System.out.println("追踪解如下：");
        trace_result(result,k,n);
        for (int i = 0; i < k; i++) {
            System.out.println(result[i]);
        }
    }
}
