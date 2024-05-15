import java.util.List;
import java.util.Random;

public class Rsa {

    public long p;
    public long q;
    public long n;
    public long pfiN;
    public long e;
    public long d;

    public Rsa(long p, long q) {
        this.p = p;
        this.q = q;
        this.n = p*q;
        this.pfiN = (p-1) * (q-1);

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

    public long Encrypt(long msg) throws Exception {
        return FastExponential.Calculate(msg, e, n);
    }
    public long Decrypt(long msg) throws Exception {
        var c1 = FastExponential.Calculate(msg, d%(p-1), p);
        var c2 = FastExponential.Calculate(msg, d%(q-1), q);
        return ChineseRemainder.Calculate(new long[]{c1, c2}, new long[]{p, q});

    }
}
