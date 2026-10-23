/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */

// Berkas Digital tidak mengimplementasikan Terarsip karena tidak memiliki lokasi fisik di rak
public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean layakPinjam() {
        // Selalu layak dipinjam
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " - Berkas Digital (" + ukuranMB + " MB, Unduh: " + tautanUnduh + ")";
    }
}
