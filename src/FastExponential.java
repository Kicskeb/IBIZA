public class FastExponential {
    public static long DoIt(long base, long index, long modulo) throws Exception {
        if (index < 1 || base < 0 || modulo < 0)
            throw new Exception("Rossz szam " + base + ' ' + index + ' ' + modulo);

        long result = 1;
        for (var i = 0; i < 64; i++) {
            if (((1L << i) & index) != 0) {
                var jjj = base;
                for (var j = 0; j < i; j++) {
                    jjj *= jjj;
                    jjj %= modulo;
                }
                result *= jjj;
                result %= modulo;
            }
        }
        return result;
    }
}
