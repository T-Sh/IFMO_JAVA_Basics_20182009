package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {
    private int count;

    public BottleSong(int bottleTakenAtOnce) {
        if (bottleTakenAtOnce > 99 || bottleTakenAtOnce <= 0) {
            throw new IllegalArgumentException();
        }
        count = bottleTakenAtOnce;
        System.out.print(getBottleSongLyrics());
    }

    private String transform(int bottles) {
        final String[] numbers = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (bottles > 9 && bottles < 20) {
            return (numbers[bottles]);
        } else {
            return (numbers[bottles/10] + numbers[bottles%10]);
        }
    }

    public String getBottleSongLyrics() {
        int total = 99;
        String lyrics = "";
        while (total - count > 0) {
            String bottles = transform(count);

            lyrics += total + " bottles of beer on the wall, " + total + " bottles of beer.\nTake " + bottles +
                    " down and pass around, ";
            total -= count;
            lyrics += total + " bottles of beer on the wall.\n";

        }
        lyrics += total + " bottles of beer on the wall, " + total + " bottles of beer.\nTake " + transform(total%count) + " down and pass around, no more bottles of beer on the wall.\n" +
                "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.";

        return lyrics;
        //throw new UnsupportedOperationException();
    }
}
