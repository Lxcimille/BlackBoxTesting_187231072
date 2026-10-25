import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiskonServiceDecisionTableTest {

    private static final double BESAR = 600_000;
    private static final double KECIL = 100_000;

    @Test
    void r1_member_besar_voucher() {
        assertEquals(new DiskonService.HasilDiskon(20, true),
                DiskonService.hitung(true, BESAR, true));
    }

    @Test
    void r2_member_besar_tanpaVoucher() {
        assertEquals(new DiskonService.HasilDiskon(15, true),
                DiskonService.hitung(true, BESAR, false));
    }

    @Test
    void r3_member_kecil_voucher() {
        assertEquals(new DiskonService.HasilDiskon(10, false),
                DiskonService.hitung(true, KECIL, true));
    }

    @Test
    void r4_member_kecil_tanpaVoucher() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(true, KECIL, false));
    }

    @Test
    void r5_nonMember_besar_voucher() {
        assertEquals(new DiskonService.HasilDiskon(10, true),
                DiskonService.hitung(false, BESAR, true));
    }

    @Test
    void r6_nonMember_besar_tanpaVoucher() {
        assertEquals(new DiskonService.HasilDiskon(5, true),
                DiskonService.hitung(false, BESAR, false));
    }

    @Test
    void r7_nonMember_kecil_voucher() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(false, KECIL, true));
    }

    @Test
    void r8_nonMember_kecil_tanpaVoucher() {
        assertEquals(new DiskonService.HasilDiskon(0, false),
                DiskonService.hitung(false, KECIL, false));
    }

    // Tambahan: batas kondisi C2
    @Test
    void batas_tepat500rb_dianggapBesar() {
        assertEquals(new DiskonService.HasilDiskon(15, true),
                DiskonService.hitung(true, 500_000, false));
    }

    @Test
    void batas_499999_dianggapKecil() {
        assertEquals(new DiskonService.HasilDiskon(5, false),
                DiskonService.hitung(true, 499_999, false));
    }
}
