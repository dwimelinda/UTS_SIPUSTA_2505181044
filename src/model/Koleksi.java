/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */

public abstract class Koleksi {
    private String kodeKoleksi;
    private String judul;
    private int tahunTerbit;

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeKoleksi() { return kodeKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }

    // Method abstrak untuk aturan kelayakan pinjam
    public abstract boolean layakPinjam();

    // Method deskripsi yang diperluas memakai super
    public String deskripsi() {
        return "[" + kodeKoleksi + "] " + judul + " (" + tahunTerbit + ")";
    }
}
