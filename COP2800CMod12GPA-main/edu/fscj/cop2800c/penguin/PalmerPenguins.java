package edu.fscj.cop2800c.penguin;

// PalmerPenguins.java
// D. Singletary
// 3/14/25
// Palmer Penguins application

import edu.fscj.cop2800c.util.DataWrapper;
import java.util.ArrayList;



public class PalmerPenguins {
    public static void main(String[] args) {
        int numPenguins = 0;
        
        // Create an instance of PenguinAnalyzer
        PenguinAnalyzer analyzer = new PenguinAnalyzer();
    
        // Read CSV data
        numPenguins = analyzer.readPenguins();
        
        // Check if any penguins were read, exit if none
        if (numPenguins == 0) {
            System.err.println(
                "Error: No penguins were read from the file. Exiting program.");
            System.exit(1); // Exit with a non-zero status to indicate an error
        }
    
        if (numPenguins > 1) {
            // Test the compareTo method
            System.out.println("Testing compareTo method:");
        
            Penguin p1 = analyzer.getPenguinBySampleNum(1);
            Penguin p2 = analyzer.getPenguinBySampleNum(2);
        
            if (p1 != null && p2 != null) {
                int comparisonResult = p1.compareTo(p2);
                System.out.println(
                    "Comparison result between first two penguins: " + comparisonResult);
        
                // Test compareTo for equality condition (p1 compared to itself)
                int selfComparison = p1.compareTo(p1);
                System.out.println(
                    "Comparison result of p1 to itself (should be 0): " + selfComparison);
            } else {
                System.out.println("Could not find both penguins for comparison.");
            }
        } else {
            System.out.println("Not enough penguins to test compareTo.");
        }
    
        // Test the toString methods
        analyzer.showRawData();
    
        // Print formatted output
        analyzer.printPenguins();
    
        // Save results to a file
        analyzer.writePenguins();
        
        // Test the custom exception
        System.out.println("Testing Custom Exception");
        // iterate on sample number, call various tests.
        // sample number can be used to correlate with results.
        for (int sample = 0; sample < 7; sample++) {
        
            try {
                switch (sample) {
                    case 0:
                        // negative sample number
                        Penguin pNegSample = new Penguin(
                            -1, "Adelie", 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 1:
                        // empty species
                        Penguin pEmptySpecies = new Penguin(
                            1000 + sample, "", 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 2:
                        // null species
                        Penguin pNullSpecies = new Penguin(
                            1000 + sample, null, 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    // add more test cases here
                    case 3:
                        // negative flipper value
                        Penguin pNegFlipper = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, "Male", -1.0);
                        break;
                    case 4:
                        // empty sex
                        Penguin pEmptySex = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, "", 1.0);
                        break;
                    case 5:
                        // null sex
                        Penguin pNullSex = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, null, 1.0);
                        break;
                    case 6:
                        // negative culmen length
                        Penguin pNegCulmenLen = new Penguin(
                            1000 + sample, "Adelie", -1.0, 1.0, 1.0, null, 1.0);
                        break;
                }
            } catch (InvalidBirdDataException e) {
                System.out.println(e + ": sample = " + sample);
            }
              System.out.println("\nData Wrapper List:\n");

    ArrayList<DataWrapper<Penguin>> wrappedPenguins = new ArrayList<>();

    for (int i = 1; i <= 8; i++) {
        Penguin p = analyzer.getPenguinBySampleNum(i);
        DataWrapper<Penguin> wrapped = new DataWrapper<>(p);
        wrappedPenguins.add(wrapped);
    }

    if (!wrappedPenguins.isEmpty()) {
        DataWrapper.displayList(wrappedPenguins);
    }
}
        }
        
    }

   
 