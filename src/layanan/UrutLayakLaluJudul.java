/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author ASUS
 */

import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi a, Koleksi b) {
        // Lapis pertama: layak pinjam tampil lebih dulu (Boolean.compare dibalik agar true di atas)
        int bandingLayak = Boolean.compare(b.layakPinjam(), a.layakPinjam());
        if (bandingLayak != 0) {
            return bandingLayak;
        }
        // Lapis kedua: urut berdasarkan judul secara alfabetis
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}
