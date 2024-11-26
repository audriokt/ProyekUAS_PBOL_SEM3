public class ItemPesanan {
    private String orderItemId;//primary key
    private int jumlah;//jumlah berapa banyak yang dibeli
    private String produkId;//foreign key
    private String orderId;//foreign key

    public ItemPesanan(String orderItemId, int jumlah, String produkId, String orderId) {
        this.orderItemId = orderItemId;
        this.jumlah = jumlah;
        this.produkId = produkId;
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }
    public int getJumlah() {
        return jumlah;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public String getProdukId() {
        return produkId;
    }
    public void setProdukId(String produkId) {
        this.produkId = produkId;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
