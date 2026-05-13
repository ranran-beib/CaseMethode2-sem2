class PesananDLL {
    Pesanan head;
    Pesanan tail;
 
    PesananDLL() {
        head = null;
        tail = null;
    }
 
    /**
     * Tambah pesanan baru di belakang DLL pesanan.
     */
    void tambahPesanan(int kode, String nama, int harga, String namaPembeli) {
        Pesanan baru = new Pesanan(kode, nama, harga, namaPembeli);
 
        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail      = baru;
        }
    }
 
    /**
     * Insertion Sort pada DLL pesanan berdasarkan namaPesanan (A-Z).
     *
     * Cara kerja:
     * - Mulai dari node kedua (curr), bandingkan dengan node-node sebelumnya.
     * - Selama node sebelumnya (key.prev) memiliki namaPesanan > namaPesanan curr,
     *   tukar nilai datanya (swap data, bukan pointer) ke kanan.
     * - Tempatkan nilai curr pada posisi yang tepat.
     *
     * Kompleksitas: O(n²) — cocok untuk jumlah data kecil-menengah.
     */
    void insertionSortByNama() {
        if (head == null || head.next == null) return; // 0 atau 1 elemen, sudah terurut
 
        Pesanan curr = head.next; // mulai dari elemen kedua
 
        while (curr != null) {
            // Simpan data curr sebagai "key" yang akan disisipkan
            int    tmpKode  = curr.kodePesanan;
            String tmpNama  = curr.namaPesanan;
            int    tmpHarga = curr.harga;
            String tmpPembeli = curr.namaPembeli;
 
            Pesanan key = curr.prev;
 
            // Geser elemen yang lebih besar dari key ke kanan
            while (key != null && key.namaPesanan.compareToIgnoreCase(tmpNama) > 0) {
                // Salin data key ke posisi key.next (satu posisi ke kanan)
                key.next.kodePesanan  = key.kodePesanan;
                key.next.namaPesanan  = key.namaPesanan;
                key.next.harga        = key.harga;
                key.next.namaPembeli  = key.namaPembeli;
 
                key = key.prev; // mundur ke kiri
            }
 
            // Sisipkan data "curr" pada posisi yang tepat
            Pesanan target = (key == null) ? head : key.next;
            target.kodePesanan  = tmpKode;
            target.namaPesanan  = tmpNama;
            target.harga        = tmpHarga;
            target.namaPembeli  = tmpPembeli;
 
            curr = curr.next; // lanjut ke elemen berikutnya
        }
    }
 
    /**
     * Tampilkan laporan pesanan terurut berdasarkan nama pesanan.
     * Sorting dilakukan sebelum ditampilkan.
     */
    void laporan() {
        if (head == null) {
            System.out.println("Belum ada pesanan masuk.");
            return;
        }
 
        insertionSortByNama(); // urutkan terlebih dahulu
 
        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        System.out.printf("%-14s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
 
        int total = 0;
        Pesanan curr = head;
        while (curr != null) {
            System.out.printf("%-14d %-20s %-10d%n",
                    curr.kodePesanan, curr.namaPesanan, curr.harga);
            total += curr.harga;
            curr = curr.next;
        }
 
        System.out.println("--------------------------------------");
        System.out.printf("%-34s %d%n", "TOTAL PENDAPATAN:", total);
        System.out.println("======================================");
    }
 
    boolean isEmpty() {
        return head == null;
    }
}