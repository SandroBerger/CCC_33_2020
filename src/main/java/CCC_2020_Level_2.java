import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class CCC_2020_Level_2 {
    private final FileReader fileReader = new FileReader();
    private PrintWriter outputPrintWriter;

    void run() throws IOException {
        for (int i = 1; i <= 5; i++) {
            final var lines =
                    fileReader.fileReader("./src/main/resources/data_level_2/level2_" + i + ".in");
            final var outputFileWrite =
                    new FileWriter("./src/main/resources/data_level_2/level2_" + i + "_out.txt");
            outputPrintWriter = new PrintWriter(outputFileWrite);

            final var flightsBetweenAirports = new HashMap<Flight, Set<Integer>>();

            lines.forEach(
                    stringLine -> {
                        Optional<Flight> flight = extractFileFromString(stringLine);
                        flight.ifPresent(value -> getUniqueFlights(flightsBetweenAirports, value));
                    });

            writeToOutputFile(flightsBetweenAirports);

            outputPrintWriter.close();
        }
    }

    private void writeToOutputFile(Map<Flight, Set<Integer>> flightsBetweenAirports) {
        flightsBetweenAirports.entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getKey().getDestination()))
                .sorted(Comparator.comparing(o -> o.getKey().getStart()))
                .forEach(
                        entry ->
                                outputPrintWriter.println(
                                        entry.getKey().getStart()
                                                + " "
                                                + entry.getKey().getDestination()
                                                + " "
                                                + entry.getValue().size()));
    }

    private void getUniqueFlights(Map<Flight, Set<Integer>> flightsBetweenAirports, Flight flight) {
        Set<Integer> flightTimes = flightsBetweenAirports.get(flight);

        if (flightTimes != null) {
            flightTimes.add(flight.getTakeoff());
            flightsBetweenAirports.put(flight, flightTimes);
        } else {
            Set<Integer> flightTimes1 = new HashSet<>();
            flightTimes1.add(flight.getTakeoff());
            flightsBetweenAirports.put(flight, flightTimes1);
        }
    }

    private Optional<Flight> extractFileFromString(String stringLine) {
        String[] split = stringLine.split(",");

        if (split.length < 7) {
            return Optional.empty();
        }

        Flight flight = new Flight();
        flight.setTimestamp(Integer.valueOf(split[0]));
        flight.setLatitude(Float.valueOf(split[1]));
        flight.setLongitude(Float.valueOf(split[2]));
        flight.setAltitude(Float.valueOf(split[3]));
        flight.setStart(split[4]);
        flight.setDestination(split[5]);
        flight.setTakeoff(Integer.valueOf(split[6]));
        return Optional.of(flight);
    }
}
