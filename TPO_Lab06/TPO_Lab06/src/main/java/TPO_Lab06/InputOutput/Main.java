package TPO_Lab06.InputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String inputPath = args[0];

            if (inputPath.endsWith(".txt")) {
                // Если входной параметр - путь к txt файлу, читаем файл и выполним анализ
                analyzeDirectoryStructureFromFile(inputPath);
            } else {
                // Если входной параметр - путь к директории, выполним анализ и запишем результат в файл
                String outputPath = "directory_structure.txt";
                analyzeDirectoryStructureAndWriteToFile(inputPath, outputPath);
                System.out.println("Структура папок и файлов записана в файл: " + outputPath);
            }
        } else {
            System.out.println("Необходимо указать путь к директории или txt файлу в качестве аргумента командной строки.");
        }
    }

    public static void analyzeDirectoryStructureFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int folderCount = 0;
            int fileCount = 0;
            int totalFileNameLength = 0;
            int totalFileCountInFolders = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (line.startsWith("|-----")) {
                    folderCount++;
                } else {
                    fileCount++;
                    totalFileNameLength += line.trim().length();
                    totalFileCountInFolders++;
                }
            }

            int averageFilesInFolder = totalFileCountInFolders / folderCount;
            double averageFileNameLength = (double) totalFileNameLength / fileCount;

            System.out.println("Количество папок: " + folderCount);
            System.out.println("Количество файлов: " + fileCount);
            System.out.println("Среднее количество файлов в папке: " + averageFilesInFolder);
            System.out.println("Средняя длина названия файла: " + averageFileNameLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void analyzeDirectoryStructureAndWriteToFile(String directoryPath, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            List<String> lines = new ArrayList<>();
            analyzeDirectoryStructure(directoryPath, "", lines);
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeDirectoryStructure(String directoryPath, String indent, List<String> lines) throws IOException {
        Path path = Path.of(directoryPath);
        String dirName = path.getFileName().toString();
        lines.add(indent + dirName);

        try (var list = Files.list(path)) {
            list.forEach(filePath -> {
                if (Files.isDirectory(filePath)) {
                    try {
                        analyzeDirectoryStructure(filePath.toString(), indent + "    |-----", lines);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    String fileName = filePath.getFileName().toString();
                    lines.add(indent + "    " + fileName);
                }
            });
        }
    }
}