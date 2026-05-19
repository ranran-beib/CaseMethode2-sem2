import java.util.Scanner;

public class RoyalDelish {
 
    static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
        AntreanDLL antrean = new AntreanDLL();
        PesananDLL pesanan = new PesananDLL();
 
        // Pre-load data sampel untuk demo (sesuai catatan soal: gunakan konstruktor)
        antrean.tambahAntrian("Ainra", "08224500000");
        antrean.tambahAntrian("Danra", "08224511111");
        antrean.tambahAntrian("Sanri", "08224522222");
        antrean.tambahAntrian("Rakha", "08278022222"); //Menambahkan data pembeli ke-4 untuk demo laporan pesanan
        System.out.println(); // spasi setelah pre-load
 
        int pilihan;
 
        do {
            tampilkanMenu();
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine(); // bersihkan buffer newline
            System.out.println();
 
            switch (pilihan) {
                case 1: // ---- Tambah Antrian ----
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();
                    antrean.tambahAntrian(nama, hp);
                    break;
 
                case 2: // ---- Cetak Antrian ----
                    antrean.cetakAntrian();
                    break;
 
                // MODIFIKASI: Gabungkan proses hapus antrean dan input pesanan dalam satu menu
                case 3: // ---- Hapus Antrian & Input Pesanan ----
                if (antrean.isEmpty()) {
                    System.out.println("Antrean kosong, tidak ada yang bisa dilayani.");
                    break;
                }
                antrean.cetakAntrian();
                System.out.print("\nMasukkan No. Antrian yang dipanggil : ");
                int noA = sc.nextInt();
                sc.nextLine();

                Pembeli dilayani = antrean.hapusAntrian(noA);
                if (dilayani != null) {
                    String lanjut;
                    int    jumlahPesanan = 0;

                    do {
                        // Input satu item pesanan
                        System.out.print("Kode Pesanan  : ");
                        int kode = sc.nextInt(); sc.nextLine();
                        System.out.print("Nama Pesanan  : ");
                        String namaMakanan = sc.nextLine();
                        System.out.print("Harga         : ");
                        int harga = sc.nextInt(); sc.nextLine();

                        pesanan.tambahPesanan(kode, namaMakanan, harga, dilayani.namaPembeli);
                        jumlahPesanan++;
                        System.out.println("Pesanan \"" + namaMakanan + "\" berhasil ditambahkan.");

                        // Tanya apakah ingin menambah item lagi
                        System.out.print("Tambah pesanan lagi? (y/n) : ");
                        lanjut = sc.nextLine().trim().toLowerCase();

                    } while (lanjut.equals("y"));

                    System.out.println(dilayani.namaPembeli + " telah memesan "
                            + jumlahPesanan + " item.");
                }
                break;
 
                case 4: // ---- Laporan Pesanan ----
                    pesanan.laporan();
                    break;
 
                case 0:
                    System.out.println("Terima kasih telah menggunakan Sistem Antrean Royal Delish!");
                    break;
 
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
 
            System.out.println();
 
        } while (pilihan != 0);
 
        sc.close();
    }
 
    /** Cetak menu utama */
    static void tampilkanMenu() {
        System.out.println("==============================");
        System.out.println("SISTEM ANTRIAN ROYAL DELISH");
        System.out.println("==============================");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian dan Pesan");
        System.out.println("4. Laporan Pesanan");
        System.out.println("0. Keluar");
    }
}