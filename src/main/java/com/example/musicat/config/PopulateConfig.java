package com.example.musicat.config;

import com.example.musicat.service.ArtistService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulateConfig {
    private final ArtistService artistService;

    @Autowired
    public PopulateConfig(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostConstruct
    public void populate() {this.artistService.init();}
}
