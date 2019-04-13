public class Power {
    public static boolean isValid = false;

    public static double Power(double base, int exponent) {
        isValid = false;

        if (Double.compare(base,0.0) == 0){
            isValid = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0){
            absExponent = Math.abs(exponent);
        }
        double result = getResult(base,absExponent);
        if (exponent < 0 ){
            result = 1.0 / result;
        }
        return result;
    }

    public static double getResult(double base, int absExponent){
        double result = 1;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        double base = 2;
        int exponent = 3;
        Power.Power(base,exponent);
    }

}
