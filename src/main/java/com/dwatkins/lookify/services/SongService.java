package com.dwatkins.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dwatkins.lookify.models.Song;
import com.dwatkins.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	public List<Song> topTenSongs() {
		return songRepository.findTop10OrderByRatingDesc();
	}
	
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	
	
}
