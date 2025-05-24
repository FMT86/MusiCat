package com.example.musicat.service;

import com.example.musicat.config.exception.NotFoundException;
import com.example.musicat.entity.Artist;
import com.example.musicat.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void init() {
        if (artistRepository.count() == 0) {
            Artist artist = new Artist();
            artist.setName("Jimmy Page");
            save(artist);
            artist = new Artist();
            artist.setName("Robert Plant");
            save(artist);
            artist = new Artist();
            artist.setName("Jhon Paul Jones");
            save(artist);
            artist = new Artist();
            artist.setName("Jhon Bonham");
            save(artist);
        }
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist findById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artist not found with id: " + id));
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

//    public void deleteById(Long id) {
//        if (!artistRepository.existsById(id)) {
//            throw new NotFoundException("Artist not found with id: " + id);
//        }
//        artistRepository.deleteById(id);
//    }
}
