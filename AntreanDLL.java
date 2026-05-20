class AntreanDLL {
    Pembeli head; // node pertama (depan antrean)
    Pembeli tail; // node terakhir (belakang antrean)
    int     counter; // nomor antrean otomatis
 
    AntreanDLL() {
        head    = null;
        tail    = null;
        counter = 0;
    }
 
    /**
     * Tambah pembeli baru di belakang antrean (enqueue).
     * Nomor antrean di-increment otomatis setiap kali dipanggil.
     */
    void tambahAntrian(String nama, String noHp) {

    // nomor antrean selalu di akhir
    int nomorBaru = 1;

    if (tail != null) {
        nomorBaru = tail.noAntrian + 1;
    }

    Pembeli baru = new Pembeli(nomorBaru, nama, noHp);

    if (head == null) {
        head = baru;
        tail = baru;
    } else {
        baru.prev = tail;
        tail.next = baru;
        tail = baru;
    }

    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + nomorBaru);
    }
 
    /**
     * Cetak seluruh isi antrean dari head ke tail.
     */
    void cetakAntrian() {
        if (head == null) {
            System.out.println("Antrean kosong.");
            return;
        }
        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        System.out.printf("%-12s %-15s %-15s%n", "No Antrian", "Nama", "No HP");
 
        // Traversal dari head → tail
        Pembeli curr = head;
        while (curr != null) {
            System.out.printf("%-12d %-15s %-15s%n",
                    curr.noAntrian, curr.namaPembeli, curr.noHp);
            curr = curr.next;
        }
    }
 
    /**
     * Hapus pembeli dari antrean berdasarkan nomor antrean (dequeue by number).
     * Mengembalikan objek Pembeli yang dihapus agar bisa diproses pesanannya,
     * atau null jika tidak ditemukan.
     */
    Pembeli hapusAntrian(int noAntrian) {
        if (head == null) {
            System.out.println("Antrean kosong.");
            return null;
        }
 
        // Cari node dengan noAntrian yang sesuai (linear search)
        Pembeli curr = head;
        while (curr != null) {
            if (curr.noAntrian == noAntrian) {
                // Node ditemukan → putus sambungan dari DLL
 
                if (curr.prev != null) {
                    curr.prev.next = curr.next; // sambungkan prev ke next
                } else {
                    head = curr.next; // node ini adalah head, geser head
                }
 
                if (curr.next != null) {
                    curr.next.prev = curr.prev; // sambungkan next ke prev
                } else {
                    tail = curr.prev; // node ini adalah tail, geser tail
                }
 
                // Putus pointer node yang dihapus agar GC bisa bekerja
                curr.prev = null;
                curr.next = null;

                // Geser nomor antrean setelah data dihapus
                Pembeli geser = head;

                int nomor = 1;

                while (geser != null) {
                    geser.noAntrian = nomor;
                    nomor++;
                    geser = geser.next;
                }

                return curr; // kembalikan data pembeli yang dihapus
            }
            curr = curr.next;
        }
 
        System.out.println("Nomor antrean " + noAntrian + " tidak ditemukan.");
        return null;
    }

    int size() {
    int jumlah = 0;

    Pembeli curr = head;

    while (curr != null) {
        jumlah++;
        curr = curr.next;
    }

    return jumlah;
    }
 
    boolean isEmpty() {
        return head == null;
    }
}