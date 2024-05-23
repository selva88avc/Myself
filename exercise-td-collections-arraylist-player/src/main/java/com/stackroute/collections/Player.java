package com.stackroute.collections;

public class Player {
	private int playerId;
	private String playerName;
	private int playerScore;
	private String playerMatch;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public String getPlayerMatch() {
		return playerMatch;
	}

	public void setPlayerMatch(String playerMatch) {
		this.playerMatch = playerMatch;
	}

	public Player(int playerId, String playerName, int playerScore, String playerMatch) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.playerMatch = playerMatch;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", playerScore=" + playerScore
				+ ", playerMatch=" + playerMatch + "]";
	}

}
