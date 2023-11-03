package TPO_Lab06.Strings;

import java.util.*;

public class SentenceAnalyzer_1 {
    public static int findMaxSentencesWithSameWords(String text) {
        String[] sentences = text.split("[.!?]\\s*");
        int maxCount = 0;

        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");

            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

            if (uniqueWords.size() < words.length) {
                maxCount++;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        String text = "Каждый точный бросок знаменитого крюка вселяет страх во врагов Pudge, ведь, притянув жертву, он душит её ядовитым газом и расчленяет её своим тесаком. С каждым убийством его здоровье и урон увеличиваются, и вскоре погибель от его рук становится неизбежной.";
        int maxSentences = findMaxSentencesWithSameWords(text);
        System.out.println("Max count of sentences with same words: " + maxSentences);
    }
}