import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiskonServiceBVATest {

    // Batas bawah (0): valid vs invalid
    @Test
    void bva_minus1_invalid() {
        assertThrows(IllegalArgumentException.class,
                () -> DiskonService.hitung(true, -1, false));
    }

    @Test
    void bva_0_kecil() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(true, 0, false));
    }

    @Test
    void bva_1_kecil() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(true, 1, false));
    }

    // Batas 500.000: kecil vs besar
    @Test
    void bva_499999_kecil() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(true, 499_999, false));
    }

    @Test
    void bva_500000_besar() {
        assertEquals(new DiskonService.HasilDiskon(15, true),
                DiskonService.hitung(true, 500_000, false));
    }

    @Test
    void bva_500001_besar() {
        assertEquals(new DiskonService.HasilDiskon(15, true),
                DiskonService.hitung(true, 500_001, false));
    }
}
