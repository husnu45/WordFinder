import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentWordFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        String mostFrequentWord = findMostFrequentWord(text);

        System.out.println("Most frequent word: " + mostFrequentWord);
    }

    private static String findMostFrequentWord(String text) {
        // Split the text into words
        String[] words = text.split("\\s+");

        // Use a HashMap to count the words
        Map<String, Integer> wordCounts = new HashMap<>();

        // Iterate through the words and add them to the HashMap
        for (String word : words) {
            word = word.toLowerCase();
            if (wordCounts.containsKey(word)) {
                // If the word is already in the map, increment its count
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                // If the word is not in the map, add it with a count of 1
                wordCounts.put(word, 1);
            }
        }

        // Find the word with the highest count
        String mostFrequentWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        return mostFrequentWord;
    }
}
