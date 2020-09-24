package co.com.sp.two.service;


import co.com.sp.two.domain.Anime;
import co.com.sp.two.repository.AnimeRepository;
import co.com.sp.two.util.Utils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimeService {

    public AnimeService(Utils utils, AnimeRepository animeRepository) {
        this.utils = utils;
        this.animeRepository = animeRepository;
    }

    private final Utils utils;
    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findById(String id) {
        return utils.findAnimeOrThrowNotFound(id, animeRepository);
    }

    public Anime save(Anime anime) {
        return animeRepository.save(anime);
    }

    public void delete(String id) {
        animeRepository.delete(utils.findAnimeOrThrowNotFound(id, animeRepository));
    }

    public void update(Anime anime) {
        animeRepository.save(anime);
    }
}
