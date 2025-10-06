package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.api.Test;
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
}

