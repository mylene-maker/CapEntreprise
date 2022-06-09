package com.hb.capentreprise.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hb.capentreprise.entities.Classification;
import com.hb.capentreprise.entities.EconomicModel;
import com.hb.capentreprise.entities.Editor;
import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.entities.Genre;
import com.hb.capentreprise.entities.Moderator;
import com.hb.capentreprise.entities.Plateform;
import com.hb.capentreprise.service.IClassificationService;
import com.hb.capentreprise.service.IEconomicModelService;
import com.hb.capentreprise.service.IEditorService;
import com.hb.capentreprise.service.IGameService;
import com.hb.capentreprise.service.IGamerService;
import com.hb.capentreprise.service.IGenreService;
import com.hb.capentreprise.service.IModeratorService;
import com.hb.capentreprise.service.IPlateformService;

@Controller
public class InitController {
	
	
	@Autowired
	private IModeratorService moderatorService;
	
	@Autowired
	private IGamerService gamerService;
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IClassificationService classificationService;
	
	@Autowired
	private IEditorService editorService;
	
	@Autowired
	private IPlateformService plateformService;
	
	@Autowired
	private IEconomicModelService economicModelService;
	
	@Autowired
	private IGenreService genreService;
	
	
	
	@GetMapping("/init")
	public void initData() throws NotFoundException {
		
		
		Moderator moderator = new Moderator();
		moderator.setEmail("moderator@mail.com");
		moderator.setPassword("moderator");
		moderator.setPhoneNumber("0678452309");
		moderator.setPseudo("moderator");
		moderatorService.save(moderator);
		
		Moderator moderator2 = new Moderator();
		moderator2.setEmail("moderator2@mail.com");
		moderator2.setPassword("moderator2");
		moderator2.setPhoneNumber("0756227856");
		moderator2.setPseudo("moderator2");
		moderatorService.save(moderator2);
		
		Gamer gamer  =new Gamer();
		LocalDate birthdate =  LocalDate.of(1986, 8, 28);
		gamer.setBirthdate(birthdate);
		gamer.setEmail("gamer@mail.com");
		gamer.setPassword("gamer");
		gamer.setPseudo("gamer");
		gamerService.save(gamer);
		
		Gamer gamer2  =new Gamer();
		LocalDate birthdateGamer2 =  LocalDate.of(2012, 12, 12);
		gamer2.setBirthdate(birthdateGamer2);
		gamer2.setEmail("gamer2@mail.com");
		gamer2.setPassword("gamer2");
		gamer2.setPseudo("gamer2");
		gamerService.save(gamer2);
		
		
		Classification pegi12 = new Classification();
		pegi12.setName("PEGI 12");
		classificationService.save(pegi12);
		
		
		Classification pegi13 = new Classification();
		pegi13.setName("PEGI 13");
		classificationService.save(pegi13);
		
		
		Editor ubisoft = new Editor();
		ubisoft.setName("Ubisoft");
		editorService.save(ubisoft);
		
		
		Editor capcom = new Editor();
		capcom.setName("Capcom");
		editorService.save(capcom);
		
		
		Plateform ps5 = new Plateform();
		ps5.setName("PS5");
		plateformService.save(ps5);
		
		
		Plateform xbox = new Plateform();
		xbox.setName("XBOX");
		plateformService.save(xbox);
		
		
		EconomicModel freeToPlay = new EconomicModel();
		freeToPlay.setName("Free To Play");
		economicModelService.save(freeToPlay);
		
		
		EconomicModel payToPlay =  new EconomicModel();
		payToPlay.setName("Pay to play");
		economicModelService.save(payToPlay);
		
		
		Genre fps = new Genre();
		fps.setName("FPS");
		genreService.save(fps);
		
		
		Genre rpg = new Genre();
		rpg.setName("RPG");
		genreService.save(rpg);
		
		
		Classification classGame = classificationService.getClassification(1L);
		EconomicModel ecoGame = economicModelService.getEconomicModel(1L);
		Editor editGame = editorService.getEditor(1L);
		Genre genreGame = genreService.getGenre(1L);
		Moderator modeGame = moderatorService.getModerator(1L);
		Plateform plateGame = plateformService.getPlateform(1L);
		List<Plateform> plateformsGame = new ArrayList<Plateform>();
		plateformsGame.add(plateGame);
		LocalDate releaseGame = LocalDate.now();
		
		Game game = new Game();
		game.setClassification(classGame);
		game.setDescription("Un super jeu");
		game.setEconomicModel(ecoGame);
		game.setEditor(editGame);
		game.setGenre(genreGame);
		game.setModerator(modeGame);
		game.setName("Call Of Duty");
		game.setPicture("pictureRoot");
		game.setPlateforms(plateformsGame);
		game.setReleaseDate(releaseGame);
		gameService.save(game);
		

		Classification classGame2 = classificationService.getClassification(2L);
		EconomicModel ecoGame2 = economicModelService.getEconomicModel(2L);
		Editor editGame2 = editorService.getEditor(2L);
		Genre genreGame2 = genreService.getGenre(2L);
		Moderator modeGame2 = moderatorService.getModerator(2L);
		Plateform plateGame2 = plateformService.getPlateform(2L);
		List<Plateform> plateformsGame2 = new ArrayList<Plateform>();
		plateformsGame.add(plateGame2);
		LocalDate releaseGame2 = LocalDate.now();
		
		Game game2 = new Game();
		game2.setClassification(classGame2);
		game2.setDescription("Un super jeu");
		game2.setEconomicModel(ecoGame2);
		game2.setEditor(editGame2);
		game2.setGenre(genreGame2);
		game2.setModerator(modeGame2);
		game2.setName("Final Fantasy");
		game2.setPicture("pictureRoot");
		game2.setPlateforms(plateformsGame2);
		game2.setReleaseDate(releaseGame2);
		gameService.save(game2);
		
		
		
		
		
	}
	
	


}
