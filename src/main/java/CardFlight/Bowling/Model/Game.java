package CardFlight.Bowling.Model;

import java.util.Arrays;

public class Game {
	
	private Frames[] frames;
	
	private int frameIndex;
	
	private static Game game;
	
	private Game() {
		this.frames = new Frames[10];
		Arrays.fill(this.frames, null);
		this.frameIndex = 0;
	}
	
	public static Game getGameInstance() {
		if(game == null) {
			game = new Game();
		}
		return game;
	}
		
	public void setFrames(Frames frames) {
		this.frames[this.frameIndex] = frames;
	}
	
	public void setFrameIndex(int frameIndex) {
		this.frameIndex = frameIndex;
	}
	
	public int getFrameIndex() {
		return this.frameIndex;
	}
	
	public Frames[] getFrames() {
		Frames[] temp = new Frames[this.frameIndex];
		for(int i = 0 ; i< temp.length;i++) {
			temp[i] = this.frames[i];
		}
		return temp;
	}
	
	public void resetSingleton() {
		if(game != null) {
			game = new Game();
		}
	}
	
	public int[] getScore() {
		int[] frameScore = new int[this.frameIndex];
		for(int i = frameScore.length-1 ; i >= 0;i--) {
			if(i == 9) {
				String[] rolls  = this.frames[i].getRolls();
				frameScore[i] = this.frames[i].getNumericValueOfRoll(rolls[0])
								+this.frames[i].getNumericValueOfRoll(rolls[1]);
				if(this.frames[i].isSpareFrame() || this.frames[i].isStrikeFrame()) {
					frameScore[i] += this.frames[i].getNumericValueOfRoll(rolls[2]);
				}
						
			}else if(this.frames[i].isStrikeFrame()) {
				frameScore[i] = 10 + this.getStrikeScore(i);
			}else if(this.frames[i].isSpareFrame()) {
				frameScore[i]= 10+ this.getSpareScore(i);
			}else {
				frameScore[i] = this.frames[i].getFrameScoreWithNoSpareNoStrike(i);
			}
		}
		return frameScore;
	}
	
	public int getSpareScore(int i) {
		if(this.frames[i+1] == null) {
			return Integer.MIN_VALUE;
		}else {
			return this.frames[i+1].getNumericValueOfRoll(this.frames[i+1].getRolls()[0]);
		}
	}
	
	public int getStrikeScore(int i) {
		int total = 0;
		int rollsCounted = 0;
		int index = i+1;
		while(rollsCounted < 2) {
			if(this.frames[index] == null && rollsCounted != 2) {
				return Integer.MIN_VALUE;
			}else {
				String[] rolls = this.frames[index].getRolls();
				if(this.frames[index].isStrikeFrame()) {
					if(index == 9) {
						for(int x = 0 ; x< 2-rollsCounted;x++) {
							total += this.frames[index].getNumericValueOfRoll(rolls[x]);
						}
						break;
					}else {
						total +=10;
						rollsCounted++;
						index++;
					}
				}else {
					for(int x = 0 ; x< 2-rollsCounted;x++) {
						total += this.frames[index].getNumericValueOfRoll(rolls[x]);
					}
					break;
				}
			}
		}
		return total;
	}
}
