package co.com.sp.two.util;

import co.com.sp.two.domain.Anime;
import co.com.sp.two.exception.ResourceNotFoundException;
import co.com.sp.two.repository.AnimeRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utils {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public Anime findAnimeOrThrowNotFound(String id, AnimeRepository animeRepository) {
        return animeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anime Not Found"));
    }

}
