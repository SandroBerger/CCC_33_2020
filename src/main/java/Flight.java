import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
class Flight implements Comparable<Flight> {
    @EqualsAndHashCode.Exclude private Integer timestamp;
    @EqualsAndHashCode.Exclude private Float longitude;
    @EqualsAndHashCode.Exclude private Float latitude;
    @EqualsAndHashCode.Exclude private Float altitude;
    private String start;
    private String destination;
    @EqualsAndHashCode.Exclude private Integer takeoff;

    @Override
    public int compareTo(Flight o) {
        if (this.start.equals(o.getDestination()) && this.destination.equals(o.getDestination())) {
            return 0;
        }

        return this.start.compareTo(o.getStart());
    }
}
