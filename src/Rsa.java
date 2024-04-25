import java.util.List;
import java.util.Random;

public class Rsa {
    public Rsa() throws Exception {
        Random rand = new Random();
        while (true) {
            long e = rand.nextLong(2, pfiN);
            List<Long> test = Euclides.Extended(e, pfiN);
            if (test.get(0) == 1 && test.get(1) > 0) {
                this.e = e;
                this.d = test.get(1);
                break;
            }
        }
    }

    public long p = 3061;
    public long q = 3559;
    public long n = p*q;
    public int m = 128;
    public long pfiN = (p-1) * (q-1);
    public long e;
    public long d;
    public long Encrypt(long msg) throws Exception {
        return FastExponential.DoIt(msg, e, n);
    }
    public long Decrypt(long msg) throws Exception {
//        return FastExponential.DoIt(msg, d, n);
        var c1 = FastExponential.DoIt(msg, d%(p-1), p);
        var c2 = FastExponential.DoIt(msg, d%(q-1), q);
        return ChineseRemainder.Calculate(new long[]{c1, c2}, new long[]{p, q});

    }
}
