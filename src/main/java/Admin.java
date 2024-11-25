public class Admin {
    private String adminId;
    private String adminName;
    private String adminEmail;

    public Admin(String AdminId, String AdminName, String AdminEmail) {
        this.adminId = AdminId;
        this.adminEmail = AdminEmail;
        this.adminName = AdminName;
    }

    public void tambahProduk(Produk produk){
        //logika
        System.out.println("Produk " + produk.getName() + " berhasil ditambahkan.");
    }

    public void editProduk(Produk produk, String namaBaru, String deskripsiBaru, double hargaBaru, int stokBaru){
        //logika
        System.out.println("Produk " + namaBaru + " berhasil ditambahkan.");
        produk.setName(namaBaru);
        produk.setDeskripsi(deskripsiBaru);
        produk.setHarga(hargaBaru);
        produk.setStok(stokBaru);
    }

    public void hapusProduk(Produk produk){
        //logika
        System.out.println("Produk " + produk.getName() + " berhasil dihapus.");
    }

    public void perbaruiStokProduk(Produk produk, int stokBaru){
        //logika
        produk.setStok(stokBaru);
        System.out.println("Stok produk " + produk.getName() + " berhasil diperbarui.");
    }

    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
