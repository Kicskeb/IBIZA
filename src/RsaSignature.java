import org.apache.commons.codec.cli.Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RsaSignature {

    private Rsa myRsa;
    private MessageDigest digester;

    public RsaSignature(Rsa rsa) throws NoSuchAlgorithmException {
        this.myRsa = rsa;
        this.digester = MessageDigest.getInstance("SHA-256");
    }

    public long Sign(String msg) throws Exception {
        this.digester.update(msg.getBytes());
        var digest = Base64.getEncoder().encodeToString(this.digester.digest());
        return myRsa.Encrypt(Long.parseLong(digest));
    }

    public boolean Verify(Long signature, String msg) throws Exception {
        var digest = myRsa.Decrypt(Long.getLong(msg));
        this.digester.update(msg.getBytes());
        var verifySignature = Base64.getEncoder().encodeToString(this.digester.digest());
        return Long.parseLong(verifySignature) == signature;
    }
}
