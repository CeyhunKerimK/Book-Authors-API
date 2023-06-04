package ceyhunkerim.yazar.repository;

import ceyhunkerim.yazar.model.Kitap;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KitapRepository extends MongoRepository<Kitap, String> {
    Kitap findByKitapAdi(String kitapAdi);

    List<Kitap> findByYazar(String yazar);

    List<Kitap> findByTur(String tur);
}
