import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pesanan {
    private String orderId;
    private Date tanggalPemesanan;
    private double jumlahTotal;
    private String customerId; //foreign key ke table pelanggan
    private List<ItemPesanan> items;

    public Pesanan(String orderId, Date tanggalPemesanan, double jumlahTotal, String customerId) {
        this.orderId = orderId;
        this.tanggalPemesanan = tanggalPemesanan;
        this.jumlahTotal = jumlahTotal;
        this.customerId = customerId;
    }

    public void tambahItem(ItemPesanan item){
        this.items.add(item);
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Date getTanggalPemesanan() {
        return tanggalPemesanan;
    }
    public void setTanggalPemesanan(Date tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }
    public double getJumlahTotal() {
        return jumlahTotal;
    }
    public void setJumlahTotal(double jumlahTotal) {
        this.jumlahTotal = jumlahTotal;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
