package com.dwatkins.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwatkins.lookify.models.Song;
import com.dwatkins.lookify.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("songs", allSongs);
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/new")
	public String newSong() {
		return "new.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		if (song != null) {
			model.addAttribute("song", song);
			return "show.jsp";
		}
		else {
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/search")
	public String searchResults(@RequestParam(value="search") String search, Model model) {
		List<Song> results = songService.artistSearch(search);
		model.addAttribute("results", results);
		return "search.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam(value="search") String search, Model model) {
		if (search.isEmpty()) {
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("search", search);
			return "redirect:/search";
		}
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topTen = songService.topTenSongs();
		model.addAttribute("topTen", topTen);
		return "topTen.jsp";
	}
}
