package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    private static HashMap<String, Integer> dictionary = new HashMap<>();

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        findWord(tome12Path);
        findWord(tome34Path);

        //return compareAndCheckCount().collect(Collectors.joining("\n"));
        return dictionary.toString();
    }

    private static void findWord(Path path) throws IOException {
        String line = readAllLines(Paths.get("src", "main","resources", "WAPResult.txt")).stream().collect(Collectors.joining("\n"));
        line = line.replaceAll("[^а-яА-Яa-zA-Z]", " ");
        Stream<String> wordsStream = Stream.of(line.split(" "));
        wordsStream.filter(s -> s.length() >= 4).forEach((String s) -> {
            int def = dictionary.getOrDefault(s ,0) + 1;
            dictionary.put(s, def);
        });
    }

    private static Stream<String> compareAndCheckCount() {
        List<Map.Entry<String,Integer>> list = new ArrayList<>(dictionary.entrySet());
        Collections.sort(list, (e1, e2) ->
            (e1.getValue().equals(e2.getValue())) ? e1.getKey().compareTo(e2.getKey()) : e1.getValue().compareTo(e2.getValue()));

        return list.stream().filter(w -> w.getValue() > 9).map(entry -> entry.getKey() + " - " + entry.getValue());
    }
}