package com.GestionDesBiscuits.Valk.security;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static void main(String[] args) {
        // Créez un objet SecureRandom pour générer des octets aléatoires
        SecureRandom secureRandom = new SecureRandom();

        // Créez un tableau d'octets de 64 octets (512 bits)
        byte[] secretBytes = new byte[64];

        // Remplissez le tableau avec des octets aléatoires
        secureRandom.nextBytes(secretBytes);

        // Encodez les octets en Base64 pour obtenir une clé secrète lisible
        String secretKey = Base64.getEncoder().encodeToString(secretBytes);

        // Affichez la clé secrète
        System.out.println("Clé secrète générée : " + secretKey);
    }
}
