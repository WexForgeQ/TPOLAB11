package TPO_Lab06.Strings;

import java.util.*;

public class SentenceAnalyzer_4 {
    public static void printDistinctWordsOfLengthInQuestions(String text, int length) {
        String[] sentences = text.split("(?<=[.!?])\\s*");

        for (String sentence : sentences) {
            if (sentence.endsWith("?")) {
                String[] words = sentence.split("\\s+");
                Set<String> distinctWords = new HashSet<>();

                for (String word : words) {
                    if (word.length() == length) {
                        distinctWords.add(word.toLowerCase());
                    }
                }

                for (String distinctWord : distinctWords) {
                    System.out.print(distinctWord + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "Каждый точный бросок знаменитого крюка вселяет страх во врагов Pudge, ведь , притянув жертву, он душит её ядовитым газом и расчленяет её своим тесаком? С каждым убийством его здоровье и урон увеличиваются, и вскоре погибель от его рук становится неизбежной.";
        int wordLength = 5;
        printDistinctWordsOfLengthInQuestions(text, wordLength);
    }
}