package two;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/18 16:00
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class City {
    private String name;
    private String state;
    private int population;

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public String getName() { return name; }
    public String getState() { return state; }
    public int getPopulation() { return population; }
}

public class TestEleven {
    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename)).map(l -> l.split(", ")).map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {


        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        Map<String, List<Locale>> countryToLocales = locales.collect(
                Collectors.groupingBy(Locale::getCountry,Collectors.toList()));
        System.out.println("Swiss locales: " + countryToLocales.get("CH"));

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
                Collectors.partitioningBy(s -> s.getCountry().equals("en"))
                );

        System.out.println("English locales: " + englishAndOtherLocales.get(true));

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(
                Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        System.out.println("countryToLocaleSet: " + countryToLocaleSet);


        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(
                Collectors.groupingBy(Locale::getCountry, counting()));
//        System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

        Stream<City> cities = readCities("cities.txt");
        Map<String, Integer> stateToCityPopulation = cities.collect(
                Collectors.groupingBy(City::getState, summingInt(City::getPopulation)));
//        System.out.println("stateToCityPopulation: " + stateToCityPopulation);

        cities = readCities("cities.txt");
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(
                groupingBy(City::getState,
                        mapping(City::getName,
                                maxBy(Comparator.comparing(String::length)))));

//        System.out.println("stateToLongestCityName: " + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(
                groupingBy(Locale::getDisplayCountry,
                        mapping(Locale::getDisplayLanguage,
                                toSet())));
//        System.out.println("countryToLanguages: " + countryToLanguages);

        cities = readCities("cities.txt");
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
                groupingBy(City::getState,
                        summarizingInt(City::getPopulation)));
//        System.out.println(stateToCityPopulationSummary.get("NY"));

        cities = readCities("cities.txt");
        Map<String, String> stateToCityNames = cities.collect(
                groupingBy(City::getState,
                        reducing("", City::getName,
                                (s, t) -> s.length() == 0 ? t : s + ", " + t)));

//        cities = readCities("cities.txt");
//        stateToCityNames = cities.collect(
//                groupingBy(City::getState,
//                        mapping(City::getName,
//                                joining(", "))));
//        System.out.println("stateToCityNames: " + stateToCityNames);
    }
}


