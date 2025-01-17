package com.stackroute.streams;

public class Player {
	private String playerName;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public int getRuns() {
		return runs;
	}
	public Player(String playerName, int matchesPlayed, int runs, int highestScore, Country country) {
		super();
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.runs = runs;
		this.highestScore = highestScore;
		this.country = country;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	@Override
	public String toString() {
		return "[playerName=" + playerName + ", matchesPlayed=" + matchesPlayed + ", runs=" + runs
				+ ", highestScore=" + highestScore + ", country=" + country + "]";
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	private int matchesPlayed;
	private int runs;
	private int highestScore;
	private Country country;
	

}
