public class isNumeric {
    static int p = 0;
    static int  n = 0;
    public static boolean isNumeric(char[] str) {
        if(str == null) return false;
        boolean isNum = false;
        n = str.length;
        // 判断有无正负号，有的话p会移动到下一位
        if(str[p] == '+' || str[p] == '-'){
            p++;
        }
        // 再判断是否是个整数
        isNum = isUnsignInte(str);
        // 当返回时 p可能==n  也可能遇到了非数字的字符
        // p<n 一定在前，否则 str[p]会出现越界现象。
        if(p < n &&  str[p] == '.'){
            p++;
            // 参考剑指，这个地方三种情况  小数点前为有数 或者 小数点后有数
            isNum =  isUnsignInte(str) || isNum;
        }
        // p<n ！ 判断是否存在指数部分
        if(p < n && (str[p] == 'e' || str[p] == 'E') ){
            p++;
            if(p<n && str[p] == '+' || str[p] == '-'){
                p++;
            }
            isNum =  isUnsignInte(str) && isNum;
        }

        return isNum && p==n ;
    }
    public static boolean isUnsignInte(char[] str){
        int before = p;
        while(p < n && Character.isDigit(str[p])){
            p++;
        }
        return p > before;
    }

    public static void main(String[] args) {
        String test = "12e";
        boolean result =  isNumeric(test.toCharArray());
        System.out.println(result);
    }
}
