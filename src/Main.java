/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import layanan.EksporKatalog;
import model.BukuCetak;
import model.Majalah;
import model.BerkasDigital;
import eksepsi.PustakaException;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Mengisi katalog dengan data uji wajib
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "rak A-12", false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "rak B-04", true); // sedang diperbaiki
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, "edisi 88", "Agustus", "rak C-01", true); // edisi terbaru
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, "edisi 87", "Juli", "rak C-02", false); // bukan terbaru
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002");

        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(bd1);
        katalog.tambah(bd2);

        // 1. Uji Cetak Status Polimorfik
        System.out.println("=== STATUS SELURUH KOLEKSI ===");
        katalog.cetakStatus();

        // 2. Uji Comparator Berlapis (Urut Layak Lalu Judul)
        System.out.println("\n=== PENGURUTAN (LAYAK DULU, LALU JUDUL) ===");
        for (model.Koleksi k : katalog.urut(new UrutLayakLaluJudul())) {
            System.out.println(k.getKodeKoleksi() + " - " + k.getJudul() + " [Layak: " + k.layakPinjam() + "]");
        }

        // 3. Uji Penanganan Eksepsi Peminjaman
        System.out.println("\n=== PENGUJIAN TRANSAKSI PEMINJAMAN ===");
        try {
            katalog.pinjam("BK-001"); // Berhasil
            System.out.println("Peminjaman BK-001 BERHASIL.");
            
            katalog.pinjam("BK-002"); // Gagal karena tidak layak (sedang diperbaiki)
        } catch (PustakaException e) {
            System.out.println("Peminjaman DITOLAK: " + e.getMessage());
        }

        try {
            katalog.pinjam("BK-001"); // Gagal karena sedang dipinjam
        } catch (PustakaException e) {
            System.out.println("Peminjaman DITOLAK: " + e.getMessage());
        }

        // 4. Uji Ekspor ke Berkas Teks (katalog.txt)
        System.out.println("\n=== EKSPOR BERKAS TEKS ===");
        EksporKatalog.simpanKeTeks(katalog, "katalog.txt");
    }
}
