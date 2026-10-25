import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PenilaianServiceEPTest {

    @Test
    void ep1_nilaiDiBawahRange_invalid() {
        assertThrows(IllegalArgumentException.class,
                () -> PenilaianService.tentukanGrade(-10));
    }

    @Test
    void ep2_nilai0sd39_gradeE() {
        assertEquals("E", PenilaianService.tentukanGrade(20));
    }

    @Test
    void ep3_nilai40sd54_gradeD() {
        assertEquals("D", PenilaianService.tentukanGrade(47));
    }

    @Test
    void ep4_nilai55sd69_gradeC() {
        assertEquals("C", PenilaianService.tentukanGrade(62));
    }

    @Test
    void ep5_nilai70sd84_gradeB() {
        assertEquals("B", PenilaianService.tentukanGrade(77));
    }

    @Test
    void ep6_nilai85sd100_gradeA() {
        assertEquals("A", PenilaianService.tentukanGrade(92));
    }

    @Test
    void ep7_nilaiDiAtasRange_invalid() {
        assertThrows(IllegalArgumentException.class,
                () -> PenilaianService.tentukanGrade(150));
    }
}
