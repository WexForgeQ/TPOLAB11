package TPO_Lab06.Fundamentals;

import static org.junit.Assert.assertEquals;

import TPO_Lab06.Fundamentals.Task_01;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class FundamentalTest
{
    @Test
    public void testGreeting() {
        // Prepare input
        String inputName = "Никита";
        InputStream inputStream = new ByteArrayInputStream(inputName.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Task_01.main(new String[]{});

        String actualOutput = outputStream.toString();
        String expectedOutput = "Привет, " + inputName + "\n";

        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");
        actualOutput = actualOutput.replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");

        assertEquals(expectedOutput, actualOutput);
    }
}
