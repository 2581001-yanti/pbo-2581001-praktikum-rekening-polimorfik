public class Tabungan extends Rekening implements Berbunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        if (saldo >= 1000000) {
            return 0;
        }
        return 5000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * (bungaPersen / 100.0));
        saldo += bunga;
        return bunga;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        String formatPersen = String.format("%.1f", bungaPersen).replace('.', ',');
        System.out.println("  Tabungan, bunga " + formatPersen + "% per bulan");
    }
}