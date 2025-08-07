// FuelTest.java
package ErenUgur.Test;

import ErenUgur.DAO.FuelDAO;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class FuelTest {

    @Test
    public void testSaveFuelLog() {
        FuelDAO dao = new FuelDAO();
        int vehicleId = 1;
        double fuelUsed = 15.5;
        double distance = 80.0;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        dao.saveFuelLog(vehicleId, fuelUsed, distance, timestamp);  // ✅ Correct method
    }
}