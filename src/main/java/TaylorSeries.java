public class TaylorSeries {
    private static int addendumNum = 11;

    private TaylorSeries() {}

    public static void setAddendumNum(int num) {
        if (num >= 0) addendumNum = num;
    }

    public static int getAddendumNum() {
        return addendumNum;
    }

    // a != (2k + 1) Pi/2
    // (-inf, -1) (1, +inf)
    public static double sec(double a) throws FunctionIrrelevantException {

        if (((a / Math.PI) - 0.5) % 1 == 0) {
            throw new FunctionIrrelevantException("Function value is irrelevant in point " + a);
        }

        double cos = 1;
        try {
            for (int i = 1; i < addendumNum; i++) {
                cos += Math.pow(-1, i) * Math.pow(a, 2 * i) / Mathematics.factorial(2 * i);
            }

        } catch (FactorialOverflowException e) {
            System.out.println(e.getMessage());
        }

        return 1 / cos;
    }

}
