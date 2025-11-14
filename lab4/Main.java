import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Enter your text:");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\p{L}+"); 
        Matcher matcher = pattern.matcher(input);

        Map<String, Integer> sortedWords = new TreeMap<>();

        int totalWords = 0;
        int compWords = 0; 

        while (matcher.find()) {
            String word = matcher.group();
            String lower = word.toLowerCase();

            totalWords++;

            if (lower.startsWith("comp")) {
                compWords++;
            }

            sortedWords.put(lower, lower.length());
        }

        StringBuffer sb = new StringBuffer();
        sb.append("Sorted words with lengths:\n");

        for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            sb.append(entry.getKey())
              .append(" (")
              .append(entry.getValue())
              .append(" letters)\n");
        }

        System.out.println("Total words: " + totalWords);
        System.out.println("Words starting with 'комп': " + compWords);
        System.out.println(sb.toString());
        scanner.close();
    }
}
