import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class FileReader {
    List<String> fileReader(String pathUrl) throws IOException {
        final List<String> lines = new ArrayList<>();

        try (Stream<String> lineStream = Files.lines(Paths.get(pathUrl))) {
            lineStream.forEach(lines::add);
        }

        return lines;
    }
}
