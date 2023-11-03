package TPO_Lab06.Strings;

import java.util.*;

public class SentenceAnalyzer_3 {
    public static String findUniqueWordInFirstSentence(String text) {
        String[] sentences = text.split("(?<=[.!?])\\s*");
        String[] words = sentences[0].split("\\s+");
        Set<String> uniqueWords = new HashSet<>();
        Set<String> repeatedWords = new HashSet<>();

        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            } else {
                repeatedWords.add(word);
            }
        }

        for (String word : uniqueWords) {
            if (!repeatedWords.contains(word)) {
                return word;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String text = "Каждый Каждый точный бросок знаменитого крюка вселяет страх во врагов Pudge, ведь, притянув жертву, он душит её ядовитым газом и расчленяет её своим тесаком. С каждым убийством его здоровье и урон увеличиваются, и вскоре погибель от его рук становится неизбежной.";
        String uniqueWord = findUniqueWordInFirstSentence(text);

        if (uniqueWord != null) {
            System.out.println("Unique word in the first sentence: " + uniqueWord);
        } else {
            System.out.println("No unique word found in the first sentence.");
        }
    }
}