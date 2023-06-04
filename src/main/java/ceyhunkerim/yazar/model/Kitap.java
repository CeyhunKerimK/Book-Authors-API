package ceyhunkerim.yazar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kitaplar")
public class Kitap {

    @Id
    private String id;

    private String kitapAdi;
    private String yayinlanmaYili;
    private int sayfaSayisi;
    private String yazar;
    private String tur;

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYayinlanmaYili() {
        return yayinlanmaYili;
    }

    public void setYayinlanmaYili(String yayinlanmaYili) {
        this.yayinlanmaYili = yayinlanmaYili;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
}
