public class PenilaianService {

    public static String tentukanGrade(int nilai) {
        if (nilai < 0 || nilai > 100) {
            throw new IllegalArgumentException("Nilai harus antara 0 - 100");
        }
        if (nilai >= 85) return "A";
        if (nilai >= 70) return "B";
        if (nilai >= 55) return "C";
        if (nilai >= 40) return "D";
        return "E";
    }
}
