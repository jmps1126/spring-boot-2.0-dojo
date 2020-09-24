package co.com.sp.two.repository;

import co.com.sp.two.domain.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimeRepository extends MongoRepository<Anime, String> {

    List<Anime> findByName(String name);
}
