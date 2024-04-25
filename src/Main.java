public class Main {
    public static void main(String[] args) throws Exception {
//        Euclides.Simple(120, 60);
//        System.out.println(Euclides.Extended(845, 68));

//        System.out.println(FastExponential.DoIt(15, 111, 103));

        Rsa Test = new Rsa();
        var encrypted = Test.Encrypt(128);
        var decrypted = Test.Decrypt(encrypted);
        System.out.println(decrypted);

    }
}