public class Admin {
    private String adminId;
    private String adminNama;
    private String adminEmail;


    public Admin(String AdminId, String AdminName, String AdminEmail) {
        this.adminId = AdminId;
        this.adminEmail = AdminEmail;
        this.adminNama = AdminName;
    }

    public void tambahProduk(Produk produk){
        //logika untuk menambahkan produk ke database
        String sql = "INSERT INTO produk (produkId, produkName, produkDeskripsi, harga, stok) VALUE (?, ?, ?, ?, ?)";
        //ekseskusi query dengan prepared statement
        System.out.println("Produk " + produk.getProdukNama() + " berhasil ditambahkan.");
    }

    public void editProduk(Produk produk, String namaBaru, String deskripsiBaru, double hargaBaru, int stokBaru){
        //logika untuk mengedit informasi produk di database
        String sql = "UPDATE TABLE ";
        System.out.println("Produk " + namaBaru + " berhasil ditambahkan.");

    }

    public void hapusProduk(Produk produk){
        //logika
        System.out.println("Produk " + produk.getProdukNama() + " berhasil dihapus.");
    }

    public void perbaruiStokProduk(Produk produk, int stokBaru){
        //logika
        produk.setStok(stokBaru);
        System.out.println("Stok produk " + produk.getProdukNama() + " berhasil diperbarui.");
    }

    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getAdminName() {
        return adminNama;
    }
    public void setAdminName(String adminName) {
        this.adminNama = adminName;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
