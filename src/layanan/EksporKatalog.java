/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author ASUS
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Koleksi;

public class EksporKatalog {
    public static void simpanKeTeks(KatalogPerpustakaan katalog, String namaFile) {
        // Try-with-resources untuk otomatis menutup aliran berkas
        try (PrintWriter writer = new PrintWriter(new FileWriter(namaFile))) {
            writer.println(String.format("%-10s | %-35s | %-12s | %-15s", "KODE", "JUDUL", "TAHUN", "STATUS LAYAK"));
            writer.println("----------------------------------------------------------------------------------");
            for (Koleksi k : katalog.getDaftarKoleksi()) {
                writer.println(String.format("%-10s | %-35s | %-12d | %-15s",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        (k.layakPinjam() ? "Layak" : "Tidak Layak")));
            }
            System.out.println("Ekspor katalog berhasil disimpan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}
