import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CCC_2020_Level_1 {
    private final FileReader fileReader = new FileReader();
    private PrintWriter outputPrintWriter;

    void run() throws IOException {
        for (int i = 1; i <= 5; i++) {
            final var lines =
                    fileReader.fileReader("./src/main/resources/data_level_1/level1_" + i + ".in");
            final var outputFileWrite =
                    new FileWriter("./src/main/resources/data_level_1/level1_" + i + "_out.txt");
            outputPrintWriter = new PrintWriter(outputFileWrite);

            final var flights = new ArrayList<Flight>();

            lines.forEach(
                    stringLine -> {
                        extractFileFromString(stringLine).ifPresent(flights::add);
                    });

            writeToOutputFile(flights);

            outputFileWrite.close();
            outputPrintWriter.close();
        }
    }

    private void writeToOutputFile(List<Flight> flights) {
        outputPrintWriter.println(getMinMaxTimestamp(flights));
        outputPrintWriter.println(getMinMaxLat(flights));
        outputPrintWriter.println(getMinMaxLong(flights));
        outputPrintWriter.println(
                flights.stream()
                        .map(Flight::getAltitude)
                        .max(Float::compareTo)
                        .map(Float::longValue)
                        .get());
    }

    private String getMinMaxTimestamp(List<Flight> flights) {
        return flights.stream().map(Flight::getTimestamp).min(Integer::compareTo).get()
                + " "
                + flights.stream().map(Flight::getTimestamp).max(Integer::compareTo).get();
    }

    private String getMinMaxLat(List<Flight> flights) {
        return flights.stream().map(Flight::getLatitude).min(Float::compareTo).get()
                + " "
                + flights.stream().map(Flight::getLatitude).max(Float::compareTo).get();
    }

    private String getMinMaxLong(List<Flight> flights) {
        return flights.stream().map(Flight::getLongitude).min(Float::compareTo).get()
                + " "
                + flights.stream().map(Flight::getLongitude).max(Float::compareTo).get();
    }

    private Optional<Flight> extractFileFromString(String stringLine) {
        String[] split = stringLine.split(",");

        if (split.length < 4) {
            return Optional.empty();
        }

        Flight flight = new Flight();
        flight.setTimestamp(Integer.valueOf(split[0]));
        flight.setLatitude(Float.valueOf(split[1]));
        flight.setLongitude(Float.valueOf(split[2]));
        flight.setAltitude(Float.valueOf(split[3]));
        return Optional.of(flight);
    }
}
