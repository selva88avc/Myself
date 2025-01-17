package com.stackroute.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerService {

	private static List<Player> playerList;

	public static void main(String[] args) {
		playerList = List.of(new Player("Virat", 55, 6000, 150, new Country("IN", "India")),
				new Player("Dhoni", 110, 8000, 120, new Country("IN", "India")),
				new Player("Ponting", 105, 5500, 55, new Country("AU", "Australia")),
				new Player("Hayden", 45, 5000, 105, new Country("AU", "Australia")),
				new Player("Jonty", 49, 4000, 60, new Country("SA", "SouthAfrica")),
				new Player("Duminy", 75, 4500, 125, new Country("SA", "SouthAfrica")),
				new Player("Rahul", 25, 3000, 75, new Country("IN", "India")));
		Map<String, List<Player>> players = new PlayerService().getPlayersByCountry(playerList);
//		System.out.println(players);
		Map<String, List<String>> playersWithGT100M = new PlayerService().getPlayerNamesByCountry(playerList);
//		System.out.println(playersWithGT100M);
		LinkedHashMap<String, Long> totalPlayersByCountry = new PlayerService().getTotalPlayersByCountry(playerList);
//		System.out.println(totalPlayersByCountry);
		Map<String, Integer> totalRunsByCountry = new PlayerService().getTotalRunsByCountry(playerList);
//		System.out.println(totalRunsByCountry);
		Map<String, Integer> maxScoreByCountry = new PlayerService().getMaxScoreByCountry(playerList);
//		System.out.println(maxScoreByCountry);
		Map<String, String> playerNamesStringByCountry = new PlayerService().getPlayerNamesStringByCountry(playerList);
//		System.out.println(playerNamesStringByCountry);
		System.out.println(new PlayerService().getSquaresOfThree());
	}

	// Return a map with key as country name and value as List of players
	public Map<String, List<Player>> getPlayersByCountry(List<Player> batsmans) {
		Function<Player, String> function = player -> player.getCountry().getCountryName();
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().collect(Collectors.groupingBy(function));
		} else {
			return Collections.emptyMap();
		}
	}

	// Return a map with key as country name and value as List of player Names who
	// have played more than 100 matches

	public Map<String, List<String>> getPlayerNamesByCountry(List<Player> batsmans) {
		Function<Player, String> function = player -> player.getCountry().getCountryName();
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().filter(player -> player.getMatchesPlayed() > 100).collect(
					Collectors.groupingBy(function, Collectors.mapping(Player::getPlayerName, Collectors.toList())));
		} else {
			return Collections.emptyMap();
		}
	}

//    Return a LinkedHashMap with key as country name and value as number of players in each country
	public LinkedHashMap<String, Long> getTotalPlayersByCountry(List<Player> batsmans) {
		Function<Player, String> function = player -> player.getCountry().getCountryName();
		return batsmans.stream().collect(Collectors.groupingBy(function, LinkedHashMap::new, Collectors.counting()));
	}

//    Return a map with key as country name and value as sum total runs of all players
	public Map<String, Integer> getTotalRunsByCountry(List<Player> batsmans) {
		Function<Player, String> function = player -> player.getCountry().getCountryName();
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().collect(Collectors.groupingBy(function, Collectors.summingInt(Player::getRuns)));
		} else {
			return Collections.emptyMap();
		}
	}

//    Return a map with key as country name and value as maximum of the runs scored by players in that country
	public Map<String, Integer> getMaxScoreByCountry(List<Player> batsmans) {
		Function<Player, String> function = player -> player.getCountry().getCountryName();
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().collect(Collectors.groupingBy(function, Collectors.reducing(0, Player::getRuns,
					BinaryOperator.maxBy(Comparator.comparingInt(value -> value)))));
		} else {
			return Collections.emptyMap();
		}
	}

//    Return a map with key as country name and value as String of player Names separated by comma
	public Map<String, String> getPlayerNamesStringByCountry(List<Player> batsmans) {
		Function<Player, String> function = player -> player.getCountry().getCountryName();
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().collect(Collectors.groupingBy(function,
					Collectors.mapping(Player::getPlayerName, Collectors.joining(","))));
		} else {
			return Collections.emptyMap();
		}
	}
	
	public LinkedList<Integer> getSquaresOfThree() {
		return IntStream.range(20, 50).boxed().filter(num -> num%2==1).map(num -> num*3).collect(Collectors.toCollection(LinkedList::new));
	}

}
