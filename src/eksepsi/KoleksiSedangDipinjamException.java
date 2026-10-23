/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author ASUS
 */

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String kode) {
        super("Koleksi dengan kode " + kode + " sedang dipinjam oleh pengguna lain.");
    }
}
