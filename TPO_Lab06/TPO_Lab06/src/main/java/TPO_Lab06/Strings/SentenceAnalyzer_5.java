package TPO_Lab06.Strings;

public class SentenceAnalyzer_5 {
    public static String swapFirstAndLastWordsInSentences(String text) {
        String[] sentences = text.split("[.!?]\\s*");
        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");

            if (words.length > 1) {
                String firstWord = words[0];
                words[0] = words[words.length - 1];
                words[words.length - 1] = firstWord;
            }
            for (String word : words) {
                result.append(word).append(" ");
            }

            result.append(". "); // Add sentence delimiter
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String text = "Каждый точный бросок знаменитого крюка вселяет страх во врагов Pudge, ведь, притянув жертву, он душит её ядовитым газом и расчленяет её своим тесаком. С каждым убийством его здоровье и урон увеличиваются, и вскоре погибель от его рук становится неизбежной.";
        String swappedText = swapFirstAndLastWordsInSentences(text);
        System.out.println(swappedText);
    }
}

