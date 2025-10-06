package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChaineCrypteeTest {

    @Test
    public void testInitialisation() {
        ChaineCryptee c = ChaineCryptee.deEnClair("ABC", 3);
        assertNotNull(c);
    }

    @Test
    public void testCrypteDecrypte() {
        ChaineCryptee c = ChaineCryptee.deEnClair("ABC", 3);
        assertEquals("ABC", c.decrypte());
        assertEquals("DEF", c.crypte());
    }

    @Test
    void testCrypteProgrammation() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("PROGRAMMATION JAVA", 3);
        assertEquals("SURJUDPPDWLRQ MDYD", cc.crypte()); // исправлено
    }

    @Test
    void testDecrypteProgrammation() {
        ChaineCryptee cc = ChaineCryptee.deCryptee("SURJUDPPDWLRQ MDYD", 3); // исправлено
        assertEquals("PROGRAMMATION JAVA", cc.decrypte());
    }


    // 3️⃣ Test avec décalage nul
    @Test
    void testDecalageNul() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("PROGRAMMATION JAVA", 0);
        assertEquals("PROGRAMMATION JAVA", cc.crypte());
    }

    // 4️⃣ Test avec décalage maximal (Z→A)
    @Test
    void testDecalageMax() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("Z", 1);
        assertEquals("A", cc.crypte());
    }

    // 5️⃣ Vérification des espaces
    @Test
    void testEspaces() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("PROGRAMMATION JAVA", 1);
        assertEquals("QSPHSBNNBUJPO KBWB", cc.crypte());
    }

    // 6️⃣ Vérification des caractères aux limites
    @Test
    void testLimites() {
        ChaineCryptee ccA = ChaineCryptee.deEnClair("A", 1);
        assertEquals("B", ccA.crypte());

        ChaineCryptee ccZ = ChaineCryptee.deEnClair("Z", 1);
        assertEquals("A", ccZ.crypte());
    }

    // 7️⃣ Test avec chaîne null
    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ChaineCryptee.deEnClair(null, 3);
        });
    }

    // 8️⃣ Test avec chaîne vide
    @Test
    void testEmpty() {
        ChaineCryptee cc = ChaineCryptee.deEnClair("", 5);
        assertEquals("", cc.crypte());
        assertEquals("", cc.decrypte());
    }

    // 9️⃣ Test décalage négatif
    @Test
    void testDecalageNegatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            ChaineCryptee.deEnClair("ABC", -1);
        });
    }
}


