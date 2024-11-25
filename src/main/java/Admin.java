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

}
