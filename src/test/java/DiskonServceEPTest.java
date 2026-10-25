import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiskonServiceEPTest {

    // Baseline: bukan member, tanpa voucher

    @Test
    void ep1_totalNegatif_invalid() {
        assertThrows(IllegalArgumentException.class,
                () -> DiskonService.hitung(true, -100_000, true));
    }

    @Test
    void ep2_totalKecil_bukanMember_tanpaVoucher() {
        assertEquals(new DiskonService.HasilDiskon(0, false),
                DiskonService.hitung(false, 100_000, false));
    }

    @Test
    void ep3_totalBesar() {
        assertEquals(new DiskonService.HasilDiskon(5, true),
                DiskonService.hitung(false, 600_000, false));
    }

    @Test
    void ep4_member() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(true, 100_000, false));
    }

    @Test
    void ep5_pakaiVoucher() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(false, 100_000, true));
    }
}
