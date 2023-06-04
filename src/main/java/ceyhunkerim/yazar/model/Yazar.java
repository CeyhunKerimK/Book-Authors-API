package ceyhunkerim.yazar.model;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "yazarlar")
public class Yazar {
    @Id
    private String id;
    private String isim;
    private List<String> kitaplar;
    private int yas;
    // getters and setters
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<String> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(List<String> kitaplar) {
        this.kitaplar = kitaplar;
    }
    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
