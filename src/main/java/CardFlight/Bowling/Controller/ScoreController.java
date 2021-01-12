package CardFlight.Bowling.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CardFlight.Bowling.Model.Frames;
import CardFlight.Bowling.Model.Game;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@EnableAutoConfiguration
public class ScoreController {
	
		
	@PostMapping(value="/score")
	public ResponseEntity<?> getScore(@RequestBody Frames frame){
		this.addFrameToGame(frame);
		Game game = Game.getGameInstance();
		int[] score = game.getScore();
		return ResponseEntity.ok(score);
		
	}
	
	@PostMapping(value="/newgame")
	public ResponseEntity<String> newGame() {
		Game game = Game.getGameInstance();
		game.resetSingleton();
		return ResponseEntity.ok("New Game Has been created");
	}
	
	private void addFrameToGame(Frames frame) {
		Game game = Game.getGameInstance();
		game.setFrames(frame);
		game.setFrameIndex(game.getFrameIndex()+1);
	}

}
