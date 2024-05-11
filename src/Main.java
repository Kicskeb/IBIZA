public class Main {
    public static void main(String[] args) throws Exception {

        Rsa Test = new Rsa(3061, 3559);
        var encrypted = Test.Encrypt(128);
        var decrypted = Test.Decrypt(encrypted);
        System.out.println(decrypted);

//        System.out.println(Euclides.Simple());
//        System.out.println(Euclides.Extended());
//        System.out.println(FastExponential.Calculate());
//        System.out.println(ChineseRemainder.Calculate());
//        System.out.println(MillerRabin.IsPrime());

    }
}