import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        int numRows = 0;
        while (in.hasNextLine()) {
            numRows++;
            in.nextLine();
        }
        double[][] arr = new double[numRows][];
        in.close();
        in = new Scanner(file);
        int row = 0;
        while (in.hasNextLine()) {
            String[] line = in.nextLine().trim().split(" ");
            arr[row] = new double[line.length];
            for (int col = 0; col < line.length; col++) {
                arr[row][col] = Double.parseDouble(line[col]);
            }
            row++;
        }
        in.close();
        return arr;
    }
    
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        for (double[] row : data) {
            for (int col = 0; col < row.length; col++) {
                out.print(row[col]);
                if (col != row.length - 1) {
                    out.print(" ");
                }
            }
            out.println();
        }
        out.close();
    }
    
    public static double getTotal(double[][] data) {
        double sum = 0;
        for (double[] row : data) {
            for (double value : row) {
                sum += value;
            }
        }
        return sum;
    }
    
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }
    
    public static double getRowTotal(double[][] data, int row) {
        double sum = 0;
        for (double value : data[row]) {
            sum += value;
        }
        return sum;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (row.length > col) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        for (double val : data[row]) {
            if (val > highest) {
                highest = val;
            }
        }
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.MAX_VALUE;
        for (double val : data[row]) {
            if (val < lowest) {
                lowest = val;
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }
    private TwoDimRaggedArrayUtility() {}

    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length) {
                highest = Math.max(highest, data[row][col]);
            }
        }
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int highestIndex = -1;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] > highest) {
                highest = data[row][col];
                highestIndex = row;
            }
        }
        return highestIndex;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length) {
                lowest = Math.min(lowest, data[row][col]);
            }
        }
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int lowestIndex = -1;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] < lowest) {
                lowest = data[row][col];
                lowestIndex = row;
            }
        }
        return lowestIndex;
    }

        public static double getHighestInArray(double[][] data) {
            double highest = Double.NEGATIVE_INFINITY;
            for (int row = 0; row < data.length; row++) {
                for (int col = 0; col < data[row].length; col++) {
                    if (data[row][col] > highest) {
                        highest = data[row][col];
                    }
                }
            }
            return highest;
        }

        public static double getLowestInArray(double[][] data) {
            double lowest = Double.POSITIVE_INFINITY;
            for (int row = 0; row < data.length; row++) {
                for (int col = 0; col < data[row].length; col++) {
                    if (data[row][col] < lowest) {
                        lowest = data[row][col];
                    }
                }
            }
            return lowest;
        }


    }
