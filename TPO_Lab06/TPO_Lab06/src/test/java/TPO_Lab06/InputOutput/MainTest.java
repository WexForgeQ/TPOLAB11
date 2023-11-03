package TPO_Lab06.InputOutput;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.AssertJUnit.assertTrue;


public class MainTest {

    @Test
    public void testAnalyzeDirectoryStructureFromFile() {
        String filePath = "test_input.txt";
        createTestFile(filePath);

        Main.analyzeDirectoryStructureFromFile(filePath);

        deleteTestFile(filePath);
    }

    @Test
    public void testAnalyzeDirectoryStructureAndWriteToFile() {
        String directoryPath = "test_directory";
        createTestDirectory(directoryPath);

        String outputPath = "test_output.txt";
        Main.analyzeDirectoryStructureAndWriteToFile(directoryPath, outputPath);

        assertTrue(Files.exists(Path.of(outputPath)));

        deleteTestDirectory(directoryPath);
        deleteTestFile(outputPath);
    }

    private void createTestFile(String filePath) {
        try {
            Files.writeString(Path.of(filePath), "|-----Folder1\n" +
                    "|         file1.txt\n" +
                    "|         file2.txt\n" +
                    "|-----Folder2\n" +
                    "          file3.txt\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFile(String filePath) {
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTestDirectory(String directoryPath) {
        try {
            Files.createDirectories(Path.of(directoryPath));
            Files.createFile(Path.of(directoryPath, "file1.txt"));
            Files.createFile(Path.of(directoryPath, "file2.txt"));
            Files.createDirectories(Path.of(directoryPath, "Subfolder1"));
            Files.createFile(Path.of(directoryPath, "Subfolder1", "file3.txt"));
            Files.createDirectories(Path.of(directoryPath, "Subfolder2"));
            Files.createFile(Path.of(directoryPath, "Subfolder2", "file4.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestDirectory(String directoryPath) {
        try {
            Files.walk(Path.of(directoryPath))
                    .sorted((a, b) -> b.toString().length() - a.toString().length())
                    .map(Path::toFile)
                    .forEach(java.io.File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}