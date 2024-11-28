public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String alamatPelanggan;
    private String teleponPelanggan;
    private String emailpelanggan;

    public Pelanggan(String customerId, String customerName, String customerAddress, String customerPhone, String customerEmail) {
        this.idPelanggan = customerId;
        this.namaPelanggan = customerName;
        this.alamatPelanggan = customerAddress;
        this.teleponPelanggan = customerPhone;
        this.emailpelanggan = customerEmail;
    }
    public String getIdPelanggan() {
        return idPelanggan;
    }
    public void setIdPelanggan(String customerId) {
        this.idPelanggan = customerId;
    }
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
    public void setNamaPelanggan(String customerName) {
        this.namaPelanggan = customerName;
    }
    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }
    public void setAlamatPelanggan(String customerAddress) {
        this.alamatPelanggan = customerAddress;
    }
    public String getTeleponPelanggan() {
        return teleponPelanggan;
    }
    public void setTeleponPelanggan(String customerPhone) {
        this.teleponPelanggan = customerPhone;
    }
    public String getEmailpelanggan() {
        return emailpelanggan;
    }
    public void setEmailpelanggan(String customerEmail) {
        this.emailpelanggan = customerEmail;
    }
}