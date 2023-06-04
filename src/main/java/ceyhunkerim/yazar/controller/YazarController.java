package ceyhunkerim.yazar.controller;

import ceyhunkerim.yazar.model.Yazar;
import ceyhunkerim.yazar.repository.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YazarController {

    @Autowired
    private YazarRepository yazarRepository;

    @GetMapping("/show-yazarlar")
    public List<Yazar> getYazarlar() {
        return yazarRepository.findAll();
    }

    @PostMapping("/add-yazar")
    public String yazarEkle(@RequestBody Yazar yazar) {
        try {
            yazarRepository.save(yazar);
            return "Veri başarıyla kaydedildi.";
        } catch (Exception e) {
            return "Veri kaydetme işlemi başarısız oldu. Hata: " + e.getMessage();
        }
    }


    @PutMapping("/update-yazar/{isim}")
    public String updateYazar(@PathVariable String isim, @RequestBody Yazar yazarDetails) {
        Yazar yazar = yazarRepository.findByIsim(isim);
        if (yazar != null) {
            try {
                yazar.setIsim(yazarDetails.getIsim());
                yazar.setKitaplar(yazarDetails.getKitaplar());
                yazar.setYas(yazarDetails.getYas());
                yazarRepository.save(yazar);
                return "Yazar başarıyla güncellendi.";
            } catch (Exception e) {
                return "Yazar güncelleme işlemi başarısız oldu. Hata: " + e.getMessage();
            }
        } else {
            return "Yazar bulunamadı.";
        }
    }


    @DeleteMapping("/delete-yazar/{isim}")
    public String deleteYazar(@PathVariable String isim) {
        Yazar yazar = yazarRepository.findByIsim(isim);
        if (yazar != null) {
            try {
                yazarRepository.delete(yazar);
                return "Yazar başarıyla silindi.";
            } catch (Exception e) {
                return "Yazar silme işlemi başarısız oldu. Hata: " + e.getMessage();
            }
        } else {
            return "Yazar bulunamadı.";
        }
    }

}
