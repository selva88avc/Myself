### Stream Collectors
-----------------------
- Define a POJO class Country with countryId and CountryName as member variables
- Define a POJO class Player with playerName, matchesPlayed, runs, highestScore, Country as member variables

- Create a class StreamCollectorsExercise as below
	- Create a List of Players, as an instance variable. Initialize the List with some player objects in the constructor.
		Define the following methods using Java 8 stream Collectors
	
	From the List of Players, extract data in the following methods
	
	- getPlayersByCountry
		- Return a map with key as country name and value as List of players
	
	- getPlayerNamesByCountry
		- Return a map with key as country name and value as List of player Names who have played more than 100 matches
	
	- getTotalPlayersByCountry
		- Return a LinkedHashMap with key as country name and value as number of players in each country
	
	- getTotalRunsByCountry
		- Return a map with key as country name and value as sum total runs of all players
	
	- getMaxScoreByCountry
		- Return a map with key as country name and value as maximum of the runs scored by players in that country
		
	- getPlayerNamesStringByCountry
		- Return a map with key as country name and value as String of player Names separated by comma


### Special Streams
---------------------
- Create a class SpecialStreamExercise with the following methods

 	- getSquaresOfThree()
    	Use IntStream to generate a range of numbers from 20 to 50 inclusive. From the stream, store the square of odd multiples of 3 in an LinkedList and return it

