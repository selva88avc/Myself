package com.stackroute.collections;

import java.util.Comparator;

public class PlayerNameComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return o1.getPlayerName().compareToIgnoreCase(o2.getPlayerName());
	}

}
