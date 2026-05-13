class Pesanan {
    int    kodePesanan;
    String namaPesanan;
    int    harga;
    String namaPembeli; // siapa yang memesan
 
    // Node DLL untuk daftar pesanan
    Pesanan prev;
    Pesanan next;
 
    // Konstruktor: inisialisasi data pesanan
    Pesanan(int kodePesanan, String namaPesanan, int harga, String namaPembeli) {
        this.kodePesanan  = kodePesanan;
        this.namaPesanan  = namaPesanan;
        this.harga        = harga;
        this.namaPembeli  = namaPembeli;
        this.prev         = null;
        this.next         = null;
    }
}