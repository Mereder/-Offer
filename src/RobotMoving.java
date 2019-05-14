public class RobotMoving {
    public int movingCount(int threshold, int rows, int cols)
    {
        // 初始化完毕
        int[][] map = new int[rows][cols];
        return helper(map,0,0,rows,cols,threshold);
    }

    public int helper(int[][] map,int row,int col,int m,int n,int threshold){
        if (row < m && row >=0 && col < n && col >=0
            && (getDigit(row) + getDigit(col ) <= threshold)
            && map[row][col] == 0)
        {
            map[row][col] = 1;
            return 1 + helper(map,row+1,col,m,n,threshold)
                     + helper(map,row-1,col,m,n,threshold)
                     + helper(map,row,col+1,m,n,threshold)
                     + helper(map,row,col-1,m,n,threshold);
        }
        else return 0;
    }
    public int getDigit(int number){
        int sum = 0;
        while(number != 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}
