package CardFlight.Bowling.Model;

public class Frames {
	private String[] rolls;
	
	public Frames() {
		
	}
	public Frames(String[] rolls) {
		this.rolls = rolls;
	}
	
	public String[] getRolls() {
		return this.rolls;
	}
	
	public void setRolls(String[] rolls) {
		this.rolls = rolls;
	}
	
	public int getNumericValueOfRoll(String roll) {
		if(roll.equals("X")) {
			return 10;
		}else if(roll.equals("/")) {
			return 10 - Integer.parseInt(this.rolls[0]);
		}else if(roll.equals("-")) {
			return 0;
		}else {
			return Integer.parseInt(roll);
		}
	}
	
	public boolean isStrikeFrame() {
		if(this.rolls[0].equals("X")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isSpareFrame() {
		if(this.rolls[1].equals("/")) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getFrameScoreWithNoSpareNoStrike(int i ) {
		return this.getNumericValueOfRoll(this.rolls[0]) + this.getNumericValueOfRoll(this.rolls[1]);
	}
}
