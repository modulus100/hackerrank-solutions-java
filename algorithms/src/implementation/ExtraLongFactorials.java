package implementation;

import java.math.BigInteger;

public class ExtraLongFactorials {

    static void extraLongFactorials(int n) {

        BigInteger factorial = new BigInteger("1");

        for(int i = 2; i <= n; i++)
        {
            BigInteger multiplier = new BigInteger(String.valueOf(i));
            factorial = factorial.multiply(multiplier);
        }

        System.out.println(factorial);
    }
}
