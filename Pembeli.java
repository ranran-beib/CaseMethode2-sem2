class Pembeli {
    String namaPembeli;
    String noHp;
    int noAntrian;
 
    // Node DLL untuk antrean pembeli
    Pembeli prev;
    Pembeli next;
 
    // Konstruktor: inisialisasi data pembeli
    Pembeli(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian   = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp        = noHp;
        this.prev        = null;
        this.next        = null;
    }
}