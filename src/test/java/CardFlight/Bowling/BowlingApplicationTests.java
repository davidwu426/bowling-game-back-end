package CardFlight.Bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import CardFlight.Bowling.Controller.ScoreController;

@SpringBootTest
class BowlingApplicationTests {
	
	@Autowired
	private ScoreController scoreController;

	@Test
	void contextLoads() throws Exception{
		assertThat(scoreController).isNotNull();
	}
	
}
