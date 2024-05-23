package com.stackroute.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BatsmanService {
	private static List<Batsman> batsmanList;
	private static Batsman batsmanVirat;

	public static void main(String[] args) throws CountryNotFoundException {
		batsmanVirat = new Batsman("Virat", 55, 6000, 150, new Country("IN", "India"));
		batsmanList = List.of(batsmanVirat, new Batsman("Dhoni", 110, 8000, 120, new Country("IN", "India")),
				new Batsman("Ponting", 105, 5500, 55, new Country("AU", "Australia")),
				new Batsman("Hayden", 45, 5000, 105, new Country("AU", "Australia")),
				new Batsman("Jonty", 49, 4000, 60, new Country("SA", "SouthAfrica")),
				new Batsman("Duminy", 75, 4500, 125, new Country("SA", "SouthAfrica")),
				new Batsman("Rahul", 25, 3000, 75, new Country("IN", "India")));
		Optional<Batsman> batsman = new BatsmanService().getBatsman(batsmanList, "Virat", "IN");
		if (batsman.isPresent()) {
			System.out.println(batsman.get().getName());
		}

	}

	public Optional<Batsman> getBatsman(List<Batsman> batsmans, String name, String countryCode)
			throws CountryNotFoundException {
		if (batsmans != null && name != null && countryCode != null) {

			List<Batsman> intermediateList = batsmans.stream()
					.filter(batsman -> batsman.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

			if (intermediateList.isEmpty()) {
				return Optional.empty();
			} else {
				return Optional.ofNullable(intermediateList.stream()
						.filter(batsman -> batsman.getCountry().getCountryCode().equalsIgnoreCase(countryCode))
						.findFirst().orElseThrow(() -> new CountryNotFoundException("Error")));
			}
		} else {
			return Optional.empty();
		}
	}

	public String getBatsmanNamesForCountry(List<Batsman> batsmans, String countryCode) {
		if (batsmans != null && !batsmans.isEmpty() && countryCode != null) {
			return "[" + batsmans.stream()
					.filter(batsman -> batsman.getCountry().getCountryCode().equalsIgnoreCase(countryCode))
					.map(bats -> bats.getName()).sorted().collect(Collectors.joining(",")) + "]";

		} else {
			return null;
		}
	}

	public Map<String, Integer> getPlayerNameWithTotalRuns(List<Batsman> batsmans) {
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().collect(Collectors.toMap(Batsman::getName, Batsman::getTotalRuns));
		} else {
			return Collections.emptyMap();
		}
	}

	public int getHighestRunsScoredByBatsman(List<Batsman> batsmans, String country) {
		if (batsmans != null && !batsmans.isEmpty()) {
			return batsmans.stream().filter(batsman -> batsman.getCountry().getName().equalsIgnoreCase(country))
					.map(batsman -> batsman.getMatchesPlayed()).max(Integer::compare).get();
		} else {
			return 0;
		}
	}

	public Optional<List<String>> getPlayerNamesByCountry(List<Batsman> batsmans, String country) {
		if (batsmans != null && !batsmans.isEmpty() && country != null) {
			List<String> list = batsmans.stream()
					.filter(batsman -> batsman.getCountry().getName().equalsIgnoreCase(country)
							&& batsman.getTotalRuns() > 5000)
					.map(Batsman::getName).collect(Collectors.toCollection(LinkedList::new));
			if (list.isEmpty()) {
				return Optional.empty();
			} else {
				return Optional.ofNullable(list);
			}
		} else {
			return Optional.empty();
		}
	}

}
