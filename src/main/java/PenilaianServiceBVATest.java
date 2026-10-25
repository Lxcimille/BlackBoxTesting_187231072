import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PenilaianServiceBVATest {

    // Batas bawah rentang valid
    @Test void bva_minus1_invalid() {
        assertThrows(IllegalArgumentException.class, () -> PenilaianService.tentukanGrade(-1));
    }
    @Test void bva_0_E()  { assertEquals("E", PenilaianService.tentukanGrade(0)); }
    @Test void bva_1_E()  { assertEquals("E", PenilaianService.tentukanGrade(1)); }

    // Batas E / D
    @Test void bva_39_E() { assertEquals("E", PenilaianService.tentukanGrade(39)); }
    @Test void bva_40_D() { assertEquals("D", PenilaianService.tentukanGrade(40)); }
    @Test void bva_41_D() { assertEquals("D", PenilaianService.tentukanGrade(41)); }

    // Batas D / C
    @Test void bva_54_D() { assertEquals("D", PenilaianService.tentukanGrade(54)); }
    @Test void bva_55_C() { assertEquals("C", PenilaianService.tentukanGrade(55)); }
    @Test void bva_56_C() { assertEquals("C", PenilaianService.tentukanGrade(56)); }

    // Batas C / B
    @Test void bva_69_C() { assertEquals("C", PenilaianService.tentukanGrade(69)); }
    @Test void bva_70_B() { assertEquals("B", PenilaianService.tentukanGrade(70)); }
    @Test void bva_71_B() { assertEquals("B", PenilaianService.tentukanGrade(71)); }

    // Batas B / A
    @Test void bva_84_B() { assertEquals("B", PenilaianService.tentukanGrade(84)); }
    @Test void bva_85_A() { assertEquals("A", PenilaianService.tentukanGrade(85)); }
    @Test void bva_86_A() { assertEquals("A", PenilaianService.tentukanGrade(86)); }

    // Batas atas rentang valid
    @Test void bva_99_A()  { assertEquals("A", PenilaianService.tentukanGrade(99)); }
    @Test void bva_100_A() { assertEquals("A", PenilaianService.tentukanGrade(100)); }
    @Test void bva_101_invalid() {
        assertThrows(IllegalArgumentException.class, () -> PenilaianService.tentukanGrade(101));
    }
}
