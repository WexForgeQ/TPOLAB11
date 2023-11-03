package TPO_Lab06.Strings;

import java.util.*;

public class SentenceAnalyzer_2 {
    public static void printSentencesInAscendingOrder(String text) {
        String[] sentences = text.split("(?<=[.!?])\\s*");
        List<String> sentenceList = new ArrayList<>(Arrays.asList(sentences));

        sentenceList.sort(Comparator.comparingInt(sentence -> sentence.split("\\s+").length));

        for (String sentence : sentenceList) {
            System.out.print(sentence);
        }
    }

    public static void main(String[] args) {
        String text = "Каждый точный бросок знаменитого крюка вселяет страх во врагов Pudge, ведь, притянув жертву, он душит её ядовитым газом и расчленяет её своим тесаком. С каждым убийством его здоровье и урон увеличиваются, и вскоре погибель от его рук становится неизбежной.";
        printSentencesInAscendingOrder(text);
    }
}