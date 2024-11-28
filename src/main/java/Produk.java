public class Produk {
    private String produkId;
    private String produkNama;
    private String produkDeskripsi;
    private double harga;
    private int stok;

    public Produk(String produkId, String produkName, String produkDeskripsi, double harga) {
        this.produkId = produkId;
        this.produkNama = produkName;
        this.produkDeskripsi = produkDeskripsi;
        this.harga = harga;
        this.stok = 0;
    }
    public String getProdukId() {
        return produkId;
    }
    public void setProdukId(String produkId) {
        this.produkId = produkId;
    }
    public String getProdukNama() {
        return produkNama;
    }
    public void setProdukNama(String produkName) {
        this.produkNama = produkName;
    }
    public String getProdukDeskripsi() {
        return produkDeskripsi;
    }
    public void setProdukDeskripsi(String produkDeskripsi) {
        this.produkDeskripsi = produkDeskripsi;
    }
    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
}
