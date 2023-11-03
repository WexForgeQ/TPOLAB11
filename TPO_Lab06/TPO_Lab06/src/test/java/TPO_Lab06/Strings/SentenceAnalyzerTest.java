package TPO_Lab06.Strings;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SentenceAnalyzerTest {
    @Test
    public void testFindMaxSentencesWithSameWords() {
        String text = "test test. test. test test.";
        int maxSentences = SentenceAnalyzer_1.findMaxSentencesWithSameWords(text);
        assertEquals(2, maxSentences);
    }

    @Test
    public void testPrintSentencesInAscendingOrder() {
        String text = "This is a test. A sentence with more words. Another longer sentence. Short.";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SentenceAnalyzer_2.printSentencesInAscendingOrder(text);

        String expectedOutput = "Short." +
                "Another longer sentence." +
                "This is a test." +
                "A sentence with more words.";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testFindUniqueWordInFirstSentence() {
        String text = "This is test.";
        String uniqueWord = SentenceAnalyzer_3.findUniqueWordInFirstSentence(text);
        assertEquals("This", uniqueWord);
    }

    @Test
    public void testPrintDistinctWordsOfLengthInQuestions() {
        String text = "What is your name? How old are you? Where do you live? What is your favorite color?";
        int wordLength = 3;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SentenceAnalyzer_4.printDistinctWordsOfLengthInQuestions(text, wordLength);

        String expectedOutput = "how are old you ";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testSwapFirstAndLastWordsInSentences() {
        String text = "This is a test. Another sentence. Short.";
        String swappedText = SentenceAnalyzer_5.swapFirstAndLastWordsInSentences(text);
        String expectedOutput = "test is a This . sentence Another . Short .";
        assertEquals(expectedOutput, swappedText);
    }
}