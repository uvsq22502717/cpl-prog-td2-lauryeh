package fr.uvsq.cprog.mvnjunit;

public class ChaineCryptee {
    private String texteCrypte;
    private int decalage;

    private ChaineCryptee(String texteCrypte, int decalage) {
        this.texteCrypte = texteCrypte;
        this.decalage = decalage;
    }

    public static ChaineCryptee deEnClair(String texte, int decalage) {
        if (texte == null) throw new IllegalArgumentException("Texte null interdit");
        if (decalage < 0) throw new IllegalArgumentException("Décalage négatif interdit");
        String crypte = crypterTexte(texte, decalage);
        return new ChaineCryptee(crypte, decalage);
    }

    public static ChaineCryptee deCryptee(String texteCrypte, int decalage) {
        if (texteCrypte == null) throw new IllegalArgumentException("Texte null interdit");
        if (decalage < 0) throw new IllegalArgumentException("Décalage négatif interdit");
        return new ChaineCryptee(texteCrypte, decalage);
    }

    public String decrypte() {
        return decrypterTexte(texteCrypte, decalage);
    }

    public String crypte() {
        return texteCrypte;
    }

    // Fonctions utilitaires privées
    private static String crypterTexte(String texte, int decalage) {
        StringBuilder result = new StringBuilder();
        for (char c : texte.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char) ('A' + (c - 'A' + decalage) % 26));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String decrypterTexte(String texte, int decalage) {
        return crypterTexte(texte, 26 - (decalage % 26));
    }
}










