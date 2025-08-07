package ErenUGur.Test;
import ErenUgur.DAO.FuelDAO;

public class FuelTest {
    public static void main(String[] args) {
        FuelDAO fuelDAO = new FuelDAO();
        
        // Save a fuel usage log
        fuelDAO.saveFuelLog(101, 12.5);

        // Get total fuel used
        double totalFuel = fuelDAO.getTotalFuelUsed(101);
        System.out.println("Total fuel used for vehicle 101: " + totalFuel + " L");
    }
}
