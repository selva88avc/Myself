package com.stackroute.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerListService {
	private ArrayList<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player playerOne = new Player(1, "Sachin Tendulkar", 38, "India Vs Australia");
		Player playerTwo = new Player(2, "M S Dhoni", 38, "India Vs West Indies");
		Player playerThree = new Player(3, "Rohit Sharma", 68, "India Vs West Indies");
		Player playerFour = new Player(4, "Virat Kohli", 80, "India Vs England");
		PlayerListService playerListService = new PlayerListService();
        playerListService.addPlayersToList(playerOne);
        playerListService.addPlayersToList(playerTwo);
        playerListService.addPlayersToList(playerThree);
        playerListService.addPlayersToList(playerFour);
        System.out.println(playerListService.getPlayerListPlayedInSameMatchSortedByNameInAscendingOrder("India Vs West Indies"));
	}

	public void addPlayersToList(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getPlayerList() {
		return players;
	}

	public List<Player> getPlayerListSortedByNameIgnoringCaseInAscendingOrder() {
		ArrayList<Player> players = getPlayerList();
		players.sort(new PlayerNameComparator());
		return players;
	}

	public List<Player> getPlayerListSortedByScoreInDescendingOrder() {
		ArrayList<Player> players = getPlayerList();
		players.sort(new PlayerScoreComparator());
		return players;
	}

	public List<Player> getPlayerListGreaterThanFiftySortedByScoreInDescendingOrder() {
		List<Player> players = getPlayerList().stream().filter(player -> player.getPlayerScore() > 50)
				.sorted(new PlayerScoreComparator()).collect(Collectors.toList());
		return players;
	}

	public List<Player> getPlayerListPlayedInSameMatchSortedByNameInAscendingOrder(String playerMatch) {
		Iterator<Player> iterator = getPlayerList().iterator();
		List<Player> filteredPlayers = new ArrayList<Player>();
		while (iterator.hasNext()) {
			Player player = (Player) iterator.next();
			if (player.getPlayerMatch().equals(playerMatch)) {
				filteredPlayers.add(player);
			}
		}
		if(filteredPlayers.size()>1) {
			filteredPlayers.sort(new PlayerNameComparator());
			return filteredPlayers;
		} else {
			return new ArrayList<>();
		}
	}		

}
