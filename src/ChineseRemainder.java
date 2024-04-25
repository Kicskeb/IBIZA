import java.util.ArrayList;
import java.util.Arrays;

public class ChineseRemainder {
    public static long Calculate(long[] num, long[] rem) {
        long returnResult = 0;
        var M = Arrays.stream(rem).reduce((x, y) -> x * y).getAsLong();
        var Mi = Arrays.stream(rem).map(x -> M / x).toArray();
        var Yi = new ArrayList<Long>();
        for (var i = 0; i < rem.length; i++) {
            var counted = Euclides.Extended(Mi[i], rem[i]);
            var result = counted.get(1);
            Yi.add(result);
        }
        for (var i = 0; i < num.length; i ++) {
            returnResult += num[i] * Mi[i] * Yi.get(i);
        }
        return returnResult;

//        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex();
    }
}
