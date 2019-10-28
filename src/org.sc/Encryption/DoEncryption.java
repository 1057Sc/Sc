package Encryption;

import org.junit.Test;

import java.security.KeyPair;

public class DoEncryption {

    @Test
    public void generateKey() throws Exception{
        KeyPair keyPair = RsaExample.generateKeyPair();
        System.out.println();
    }
}
