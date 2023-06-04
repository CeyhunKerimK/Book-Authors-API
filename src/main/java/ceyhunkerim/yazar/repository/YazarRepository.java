package ceyhunkerim.yazar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ceyhunkerim.yazar.model.Yazar;

public interface YazarRepository extends MongoRepository<Yazar , Long> {
    Yazar findByIsim(String isim);
}
