import com.google.gson.Gson;
import tags.Html;
import util.CreateFile;
import util.ReadFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> files = findFiles(Paths.get("."));
        for (int i = 0; i<files.size(); i++){
            ReadFile file = new ReadFile(files.get(i));
            Html html = new Gson().fromJson(file.getData().substring(4), Html.class);
            CreateFile newFile = new CreateFile(file.getFileName(), html.toString());
            newFile.createHtmlFile();
        }
    }

    public static List<String> findFiles(Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith("json"))
                    .collect(Collectors.toList());
        }
        return result;
    }
}
