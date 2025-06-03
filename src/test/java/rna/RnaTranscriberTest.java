package rna;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RnaTranscriberTest {

    @Test
    void testValidTranscription() {
        RnaTranscriber transcriber = new RnaTranscriber();
        assertEquals("CGAU", transcriber.transcribe("GCTA"));
        assertEquals("GCGC", transcriber.transcribe("CGCG"));
    }

    @Test
    void testNullInput() {
        RnaTranscriber transcriber = new RnaTranscriber();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            transcriber.transcribe(null);
        });
        assertEquals("DNA string cannot be null", ex.getMessage());
    }

    @Test
    void testInvalidCharacter() {
        RnaTranscriber transcriber = new RnaTranscriber();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            transcriber.transcribe("GXTA");
        });
        assertTrue(ex.getMessage().contains("Invalid DNA nucleotide"));
    }
}
