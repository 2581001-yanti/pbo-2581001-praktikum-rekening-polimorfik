public class BankPolimorfik {
    public static void main(String[] args) {
        /*
         * Catatan Ketentuan No. 8:
         * Saat baris berikut dijalankan:
         * Rekening r = new Rekening("999", "Eko", 0);

         *
         * Muncul error kompilasi:
         * "java: Rekening is abstract; cannot be instantiated"
         */

        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        Rekening[] semua = { ani, citra, budi };
        Berbunga[] berbunga = { ani, citra };

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening rek : semua) {
            rek.tampilkanInfo();
        }

        System.out.println("========== AKHIR BULAN ============");
        // 1. Potong biaya admin semua rekening terlebih dahulu
        for (Rekening rek : semua) {
            int admin = rek.potongBiayaAdmin();
            System.out.println(rek.getNomor() + " biaya admin : " + Rekening.formatRupiah(admin));
        }
        // 2. Tambahkan bunga khusus rekening berbunga
        for (Berbunga rekBunga : berbunga) {
            int bunga = rekBunga.tambahBunga();
            System.out.println(rekBunga.getNomor() + " bunga       : " + Rekening.formatRupiah(bunga));
        }

        System.out.println("========== REKENING AKHIR =========");
        int totalDanaBank = 0;
        for (Rekening rek : semua) {
            rek.tampilkanInfo();
            totalDanaBank += rek.getSaldo();
        }

        System.out.println("-----------------------------------");
        System.out.println("Total dana bank: " + Rekening.formatRupiah(totalDanaBank));
    }
}