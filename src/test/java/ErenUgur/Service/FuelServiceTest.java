package ErenUgur.Service;

import ErenUgur.DAO.FuelDAO;
import ErenUgur.Strategy.FuelStrategy;
import ErenUgur.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class FuelServiceTest {

    private FuelService fuelService;
    private FuelDAO mockFuelDAO;
    private FuelStrategy mockStrategy;
    private Vehicle testVehicle;

    @BeforeEach
    void setUp() throws Exception {
        fuelService = new FuelService();

        // Mock FuelDAO and inject it via reflection since FuelService creates it internally
        mockFuelDAO = mock(FuelDAO.class);
        java.lang.reflect.Field field = FuelService.class.getDeclaredField("fuelDAO");
        field.setAccessible(true);
        field.set(fuelService, mockFuelDAO);

        // Prepare mock strategy
        mockStrategy = mock(FuelStrategy.class);

        // Create vehicle with required constructor params (int, String, String, double)
        testVehicle = new Vehicle(123, "ModelX", "TypeA", 10.0);
    }

    @Test
    void testLogFuelUsage() {
        // Arrange mock behavior: strategy returns 25.0 fuel used
        when(mockStrategy.calculateFuelUsage(testVehicle, 100.0)).thenReturn(25.0);

        // Act
        fuelService.logFuelUsage(testVehicle, 100.0, mockStrategy);

        // Assert: fuelDAO.saveFuelLog called with expected values
        verify(mockFuelDAO).saveFuelLog(eq(123), eq(25.0), eq(100.0), any(Timestamp.class));

        // No exceptions expected, no explicit asserts required unless you want more coverage
    }
}
