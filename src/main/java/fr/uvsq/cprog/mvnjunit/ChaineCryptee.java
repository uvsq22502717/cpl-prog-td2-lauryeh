package fr.uvsq.cprog.mvnjunit;

public class ChaineCryptee {
    private final String clair;
    private final String crypte;
    private final int decalage;

    private ChaineCryptee(String clair, String crypte, int decalage) {
        this.clair = clair;
        this.crypte = crypte;
        this.decalage = decalage;
    }

    // Fabrique à partir d’une chaîne claire
    public static ChaineCryptee deEnClair(String clair, int decalage) {
        if (clair == null || decalage < 0)
            throw new IllegalArgumentException("Chaîne nulle ou décalage négatif");
        return new ChaineCryptee(clair.toUpperCase(), crypter(clair.toUpperCase(), decalage), decalage);
    }

    // Fabrique à partir d’une chaîne déjà chiffrée
    public static ChaineCryptee deCryptee(String crypte, int decalage) {
        if (crypte == null || decalage < 0)
            throw new IllegalArgumentException("Chaîne nulle ou décalage négatif");
        return new ChaineCryptee(decrypter(crypte.toUpperCase(), decalage), crypte.toUpperCase(), decalage);
    }

    public String crypte() {
        return crypte;
    }

    public String decrypte() {
        return clair;
    }

    private static String crypter(String texte, int decalage) {
        StringBuilder sb = new StringBuilder();
        for (char c : texte.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + decalage) % 26));
            } else if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String decrypter(String texte, int decalage) {
        StringBuilder sb = new StringBuilder();
        for (char c : texte.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' - decalage + 26) % 26));
            } else if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}









