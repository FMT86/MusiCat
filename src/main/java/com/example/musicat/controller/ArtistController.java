package com.example.musicat.controller;

import com.example.musicat.entity.Artist;
import com.example.musicat.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/api/artists")
    public ResponseEntity<List<Artist>> getArtists() {
        List<Artist> artists = artistService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(artists);
    }
    @GetMapping("/api/artist/{id}")
    public ResponseEntity<Artist> getArtist(@PathVariable Long id) {
        Artist artist = artistService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(artist);
    }

    @PostMapping("/api/artists")
    public ResponseEntity<Artist> postArtist(@RequestBody Artist artist) {
        Artist savedArtist = artistService.save(artist);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArtist);
    }


}
