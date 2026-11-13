public class Giro extends Rekening  {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this. batasOverdraft = batasOverdraft;
}
@Override
public boolean tarik(int jumlah) {
    if (jumlah > 0 && (saldo + batasOverdraft) >= jumlah) {
        saldo -= jumlah;
        return true;
    }
    return false;
}
    @Override
    public int biayaAdminBulanan() {
        return 15000;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Giro, batas overdraft " + formatRupiah(batasOverdraft));
    }
}