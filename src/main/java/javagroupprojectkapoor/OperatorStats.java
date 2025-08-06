package javagroupprojectkapoor;

/**
 * Represents performance statistics for a transit operator.
 */
public class OperatorStats {
    private final String operatorId;
    private final double onTimeRate;
    private final int tripsCompleted;

    /**
     * Creates a new OperatorStats object.
     *
     * @param operatorId the ID of the operator
     * @param onTimeRate the on-time rate percentage
     * @param tripsCompleted the number of completed trips
     */
    public OperatorStats(String operatorId, double onTimeRate, int tripsCompleted) {
        this.operatorId = operatorId;
        this.onTimeRate = onTimeRate;
        this.tripsCompleted = tripsCompleted;
    }

    /**
     * Gets the operator ID.
     *
     * @return the operator ID
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Gets the operator's on-time rate.
     *
     * @return the on-time rate
     */
    public double getOnTimeRate() {
        return onTimeRate;
    }

    /**
     * Gets the number of trips completed.
     *
     * @return number of completed trips
     */
    public int getTripsCompleted() {
        return tripsCompleted;
    }
}