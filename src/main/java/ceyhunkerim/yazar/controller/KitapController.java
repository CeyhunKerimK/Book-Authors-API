package ceyhunkerim.yazar.controller;

import ceyhunkerim.yazar.model.Kitap;
import ceyhunkerim.yazar.repository.KitapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class KitapController {

    @Autowired
    private KitapRepository kitapRepository;

    @GetMapping("/show-kitaplar")
    public List<Kitap> getKitaplar() {
        return kitapRepository.findAll();
    }

    @PostMapping("/add-kitap")
    public String kitapEkle(@RequestBody Kitap kitap) {
        try {
            kitapRepository.save(kitap);
            return "Kitap başarıyla eklendi.";
        } catch (Exception e) {
            return "Kitap ekleme işlemi başarısız oldu. Hata: " + e.getMessage();
        }
    }

    @PutMapping("/update-kitap/{kitapAdi}")
    public String updateKitap(@PathVariable String kitapAdi, @RequestBody Kitap kitapDetails) {
        Kitap kitap = kitapRepository.findByKitapAdi(kitapAdi);
        if (kitap != null) {
            try {
                kitap.setKitapAdi(kitapDetails.getKitapAdi());
                kitap.setYayinlanmaYili(kitapDetails.getYayinlanmaYili());
                kitap.setSayfaSayisi(kitapDetails.getSayfaSayisi());
                kitap.setYazar(kitapDetails.getYazar());
                kitap.setTur(kitapDetails.getTur());
                kitapRepository.save(kitap);
                return "Kitap başarıyla güncellendi.";
            } catch (Exception e) {
                return "Kitap güncelleme işlemi başarısız oldu. Hata: " + e.getMessage();
            }
        } else {
            return "Kitap bulunamadı.";
        }
    }


    @DeleteMapping("/delete-kitap/{kitapAdi}")
    public String deleteKitap(@PathVariable String kitapAdi) {
        Kitap kitap = kitapRepository.findByKitapAdi(kitapAdi);
        if (kitap != null) {
            try {
                kitapRepository.delete(kitap);
                return "Kitap başarıyla silindi.";
            } catch (Exception e) {
                return "Kitap silme işlemi başarısız oldu. Hata: " + e.getMessage();
            }
        } else {
            return "Kitap bulunamadı.";
        }
    }

    @GetMapping("/show-kitaplar/{yazar}")
    @ResponseBody
    public List<Kitap> getKitaplarByYazar(@PathVariable String yazar) {
        return kitapRepository.findByYazar(yazar);
    }
    @GetMapping("/show-kitaplar/{tur}")
    public List<Kitap> getKitaplarByTur(@PathVariable String tur) {
        return kitapRepository.findByTur(tur);
    }
}
