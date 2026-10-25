public class DiskonService {

    public static final double BATAS_BELANJA = 500_000;

    public record HasilDiskon(int persenDiskon, boolean gratisOngkir) {}

    public static HasilDiskon hitung(boolean member, double totalBelanja, boolean voucher) {
        boolean besar = totalBelanja >= BATAS_BELANJA;
        int diskon;

        if (member && besar && voucher)        diskon = 20;
        else if (member && besar)              diskon = 15;
        else if (member && voucher)            diskon = 10;
        else if (member)                       diskon = 5;
        else if (besar && voucher)             diskon = 10;
        else if (besar)                        diskon = 5;
        else if (voucher)                      diskon = 5;
        else                                   diskon = 0;

        return new HasilDiskon(diskon, besar);
    }
}
