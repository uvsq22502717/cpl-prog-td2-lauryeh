package fr.uvsq.cprog.mvnjunit;

public class ChaineCryptee {

    private String texte;  //
    private int decalage;  // 

    // Constructeur privee
    private ChaineCryptee(String texte, int decalage) {
        this.texte = texte;
        this.decalage = decalage;
    }

    // Fabric method
    public static ChaineCryptee deEnClair(String texte, int decalage) {
        return new ChaineCryptee(texte, decalage);
    }

    // Fabric method for syphered
    public static ChaineCryptee deCryptee(String texteCrypte, int decalage) {
        return new ChaineCryptee(texteCrypte, decalage);
    }

    // Method decrypte
    public String decrypte() {
        // maintenant juste texte
        return texte;
    }

    // Method texte crypte
    public String crypte() {
        // Maintenant juste texte
        return texte;
    }


}



