/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author ASUS
 */

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String kode, String alasan) {
        super("Koleksi " + kode + " tidak layak dipinjam. Alasan: " + alasan);
    }
}
