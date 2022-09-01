package RootMeanSquare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class rms {

    public static void main(String[] args) throws IOException {
        findCalcNumbers();
    }

    public static void findCalcNumbers() throws IOException {
        //ST to split it into tokens
        StreamTokenizer st = new StreamTokenizer(new FileReader("C:\\Users\\muaad\\Downloads\\input.txt"));
        //List to hold the numbers read
        List<Double> numbers = new ArrayList<>();
        //reads until the end of the file
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            //if a number is read, it is added to the list
            if (st.ttype == StreamTokenizer.TT_NUMBER) {
                numbers.add(st.nval);
                //continues to next line
                continue;
            }
        }

        System.out.println("The number that should show in the 'output.txt' file is: " + calculateRMS(numbers.toArray(new Double[0]), numbers.size()));
        //calculates the rms
        Double rms = calculateRMS(numbers.toArray(new Double[0]), numbers.size());
        FileWriter fw = new FileWriter("C:\\Users\\muaad\\Downloads\\output.txt");
        //writes rms to a new file
        fw.write(String.valueOf(rms));

        //flushes and closes the stream
        fw.flush();
        fw.close();
    }

    public static Double calculateRMS(Double[] numbers, Integer n) {
        Double square = 0.0;
        Double mean = 0.0;
        Double root = 0.0;

        //Calculating square
        for (int i = 0; i < n; i++) {
            square += Math.pow(numbers[i], 2);
        }

        //Calculating mean
        mean = (square / (double) (n));

        //Calculating root
        root = Math.sqrt(mean);

        return root;
    }

}

