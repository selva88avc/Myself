package com.stackroute.collections;

import java.util.Comparator;

public class PlayerScoreComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		int value = o2.getPlayerScore() - o1.getPlayerScore();
		if (value == 0) {
			return o1.getPlayerId() - o2.getPlayerId();
		} else {
			return value;
		}
	}

}
