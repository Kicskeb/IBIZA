public class MillerRabin {

    public static boolean IsPrime(long number, long[] bases) throws Exception {

        if (number % 2 == 0) return false;

        int S = 0;
        var d = number;
        while ((d - 1) % 2 == 0) {
            S ++;
            d = d / 2;
        }
        for (var base : bases) {
            if (Euclides.Simple(base, number) != 1) continue;
            if (FastExponential.Calculate(base, d, number) == 1) return true;
            for (var i = 0; i < S; i++) {
                if (FastExponential.Calculate(base, (long) (d*Math.pow(2, i)), number) == -1) return true;
            }
        }
        return false;
    }
}
