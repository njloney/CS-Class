import java.util.Arrays;

public class HolidayBonus {
    
	private static final double HIGH_BONUS = 1000.0;
	private static final double LOW_BONUS = 200.0;
	private static final double OTHER_BONUS = 500.0;

	public static double[] calculateHolidayBonus(double[][] sales) {
	    int numRows = sales.length;
	    double[] bonuses = new double[numRows];
	    
	    for (int i = 0; i < numRows; i++) {
	        double[] row = sales[i];
	        int numCols = row.length;
	        
	        if (numCols == 0) {
	            bonuses[i] = 0.0;
	        } else if (numCols == 1) {
	            bonuses[i] = OTHER_BONUS;
	        } else {
	            double maxSales = TwoDimRaggedArrayUtility.getHighestInArray(sales);
	            double minSales = TwoDimRaggedArrayUtility.getLowestInArray(sales);
	            
	            for (int j = 0; j < numCols; j++) {
	                double salesAmount = row[j];
	                if (salesAmount == maxSales) {
	                    bonuses[i] += HIGH_BONUS;
	                } else if (salesAmount == minSales) {
	                    bonuses[i] += LOW_BONUS;
	                } else {
	                    bonuses[i] += OTHER_BONUS;
	                }
	            }
	        }
	    }
	    
	    return bonuses;
	}

	public static double calculateTotalHolidayBonus(double[][] sales) {
	    double[] bonuses = calculateHolidayBonus(sales);
	    return Arrays.stream(bonuses).sum();
	}
}