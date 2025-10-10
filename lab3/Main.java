package lab3;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String text = "Hello 123, Java 456, regex 789!";
        System.out.println("Original text: " + text);

        StringBuffer sb = new StringBuffer(text);
        sb.reverse();
        System.out.println("Reversed text (StringBuffer): " + sb);

        String[] words = text.split("\\s+"); 
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println("List of words: " + wordList);

        Pattern p = Pattern.compile("\\d+"); 
        Matcher m = p.matcher(text);
        System.out.print("Numbers in text: ");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }
        System.out.println("Letter counts: " + charCount);
    }
}
