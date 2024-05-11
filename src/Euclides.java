import java.util.ArrayList;
import java.util.List;

public class Euclides {

    public static long Simple(long a, long b) {
        while (true) {
            var tmp = a % b;
            a = b;
            b = tmp;
            if (tmp == 0) {
                return a;
            }
        }
    }

    public static List<Long> Extended(long a, long b) {

        long[] x = new long[] {1, 0};
        long[] y = new long[] {0, 1};
        long ogA = a;
        long ogB = b;
        long k = 1;
        while (true) {
            long rem = a % b;
            if (rem == 0) break;
            long ful = a / b;
            a = b;
            b = rem;
            k++;
            long newx = ful * x[1] + x[0];
            long newy = ful * y[1] + y[0];
            x = new long[] {x[1], newx};
            y = new long[] {y[1], newy};
        }
        long atimes = (long) (Math.pow(-1, k) * x[1]);
        long btimes = (long) (Math.pow(-1, k+1) * y[1]);
        List<Long> result = new ArrayList<>();
        result.add(atimes * ogA + btimes * ogB);
        result.add(atimes);
        result.add(btimes);
        return result;
    }
}
