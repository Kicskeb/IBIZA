public class Fermat {

    public static boolean IsPrime(long number, long base) throws Exception {
        var remainder = FastExponential.Calculate(base, number-1, number);
        return remainder == 1;
    }
}
