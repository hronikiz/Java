package lab3;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        input = input.trim();

        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(input);

        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        if (words.isEmpty()) {
            System.out.println("The string does not contain any words.");
            scanner.close();
            return;
        }

        System.out.println("\nNumber of words: " + words.size());

        System.out.println("\nNumber of letters in each word:");
        for (String word : words) {
            System.out.println(word + " -> " + word.length());
        }

        List<String> sortedWords = new ArrayList<>(words);
        sortedWords.sort(String.CASE_INSENSITIVE_ORDER);

        System.out.println("\nWords in alphabetical order:");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        long countKomp = words.stream()
                .filter(w -> w.toLowerCase().startsWith("comp"))
                .count();

        System.out.println("\nNumber of words starting with \"comp\": " + countKomp);
        scanner.close();
    }
}
