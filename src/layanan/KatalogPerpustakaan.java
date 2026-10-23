/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author ASUS
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

public class KatalogPerpustakaan {
    private final List<Koleksi> daftarKoleksi = new ArrayList<>();
    private final List<String> koleksiDipinjam = new ArrayList<>(); // Simulasi status pinjam

    public void tambah(Koleksi k) {
        daftarKoleksi.add(k);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return Collections.unmodifiableList(daftarKoleksi);
    }

    // Pemrosesan polimorfik murni tanpa instanceof (Soal No. 3)
    public void cetakStatus() {
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi() + " | Layak Pinjam: " + (k.layakPinjam() ? "Ya" : "Tidak"));
        }
    }

    // Method urut dengan Comparator (Soal No. 4)
    public List<Koleksi> urut(Comparator<Koleksi> pembanding) {
        List<Koleksi> salinan = new ArrayList<>(daftarKoleksi);
        salinan.sort(pembanding);
        return salinan;
    }

    // Method pinjam yang melempar custom exception (Soal No. 5)
    public void pinjam(String kodeKoleksi) throws KoleksiSedangDipinjamException, KoleksiTidakLayakException {
        if (koleksiDipinjam.contains(kodeKoleksi)) {
            throw new KoleksiSedangDipinjamException(kodeKoleksi);
        }

        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equals(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target != null && !target.layakPinjam()) {
            throw new KoleksiTidakLayakException(kodeKoleksi, "Kondisi koleksi tidak memenuhi syarat pinjam.");
        }

        koleksiDipinjam.add(kodeKoleksi);
    }
}
