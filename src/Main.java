public class Main {
    public static void main(String[] args) throws Exception {

//        Euklideszi algoritmus
        System.out.printf("Simple Euclidean 45/211%n%d%n%n", Euclides.Simple(45, 211));
//        Kibővített euklideszi algoritmus
        System.out.println("Extended Euclidean 2340/113");
        var result = Euclides.Extended(2340, 113);
        result.forEach(System.out::println);
//        Gyorshatványozás
        System.out.printf("%nFast exponentiation 23^209 = x mod 211%n%d%n%n", FastExponential.Calculate(23, 209, 211));
//        RSA titkosítás (kínai maradéktétellel)
        var rsa = new Rsa(3061, 3559);
        var msg = 128;
        var crypted = rsa.Encrypt(msg);
        System.out.printf("RSA /w ChineseRemainder %nMsg: %d -> crypted: %d%n", msg, crypted);
//        RSA aláírás (kínai maradéktétellel)
        System.out.printf("Decrypted msg: %d%n%n", rsa.Decrypt(crypted));
//        Prímtesztek Fermat teszt
        System.out.printf("Fermat prime test 181 for the base of 7%n%b%n", Fermat.IsPrime(181, 7));
        System.out.printf("Fermat prime test 127 for the bas of 5%n%b%n", Fermat.IsPrime(127, 5));
        System.out.printf("Fermat prime test 129 for the bas of 5%n%b%n", Fermat.IsPrime(129, 5));
//        Prímtesztek Miller-Rabin
        System.out.printf("Miller-Rabin prime test 197 for [12, 7]%n%b%n", MillerRabin.IsPrime(197, new long[]{12, 7}));
        System.out.printf("Miller-Rabin prime test 243 for [11, 15]%n%b%n", MillerRabin.IsPrime(243, new long[]{11, 15}));
//        Kriptográfiai könyvtárral elvégzett RSA aláírás
    }
}