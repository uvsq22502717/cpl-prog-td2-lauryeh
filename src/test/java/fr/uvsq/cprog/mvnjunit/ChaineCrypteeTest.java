package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.api.Test;

import fr.uvsq.cprog.mvnjunit.ChaineCryptee;

import static org.junit.jupiter.api.Assertions.*;

public class ChaineCrypteeTest {

    @Test
    public void testInitialisation() {
        ChaineCryptee c = ChaineCryptee.deEnClair("ABC", 3);
        assertNotNull(c);  // creation de object
    }

    @Test
    public void testCrypteDecrypte() {
        ChaineCryptee c = ChaineCryptee.deEnClair("ABC", 3);
        assertEquals("ABC", c.decrypte());
        assertEquals("ABC", c.crypte());
    }

    // 1. Test de chiffrement
    @Test
    void testCrypteProgrammation() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("PROGRAMMATION JAVA", 3);
        assertEquals("SURJUDPPSDWRQ MDYD", cc.crypte());
    }

    // 2. Test de déchiffrement
    @Test
    void testDecrypteProgrammation() {
        ChaineCryptee cc = ChaineCryptee.deCryptee("SURJUDPPSDWRQ MDYD", 3);
        assertEquals("PROGRAMMATION JAVA", cc.decrypte());
    }

    // 3. Test avec décalage nul
    @Test
    void testDecalageNul() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("PROGRAMMATION JAVA", 0);
        assertEquals("PROGRAMMATION JAVA", cc.crypte());
    }

    // 4. Test avec décalage maximal
    @Test
    void testDecalageMax() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("Z", 1);
        assertEquals("A", cc.crypte());
    }

    // 5. Vérification des espaces
    @Test
    void testEspaces() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("PROGRAMMATION JAVA", 1);
        assertEquals("QSPHSBNNBUPUJPO KBWB", cc.crypte());
    }

    // 6. Vérification des caractères aux limites
    @Test
    void testLimites() {
        ChaineCryptee ccA = ChaineCryptee.deEnClair("A", 1);
        assertEquals("B", ccA.crypte());

        ChaineCryptee ccZ = ChaineCryptee.deEnClair("Z", 1);
        assertEquals("A", ccZ.crypte());
    }

    // 7. Test avec chaîne null
    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ChaineCryptee.deEnClair(null, 3);
        });
    }

    // 8. Test avec chaîne vide
    @Test
    void testEmpty() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("", 5);
        assertEquals("", cc.crypte());
        assertEquals("", cc.decrypte());
    }
    
}

