import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class ArrayStuff
{

    static int[] dataPoints = new int[100];

    public static void main(String[] args)
    {
        Random rand = new Random();
        int sum = 0;
        int low = 100;
        int high = 0;
        ArrayList<Integer> lowArrayIndex = new ArrayList<>();
        ArrayList<Integer> highArrayIndex = new ArrayList<>();
        for (int i = 0; i < dataPoints.length; i++)
        {
            dataPoints[i] = rand.nextInt(100) + 1;
            sum = sum + dataPoints[i];
            if (dataPoints[i] < low)
            {
                low = dataPoints[i];
                lowArrayIndex.clear();
                lowArrayIndex.add(i);
            }
            else if (dataPoints[i] == low)
            {
                lowArrayIndex.add(i);
            }

            if (dataPoints[i] > high)
            {
                high = dataPoints[i];
                highArrayIndex.clear();
                highArrayIndex.add(i);
            }
            else if (dataPoints[i] == high)
            {
                lowArrayIndex.add(i);
            }
        }



        System.out.print("DataPoints values: ");
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.println();



        double average = (double) sum / dataPoints.length;

        System.out.println("The sum of the values in dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);







        int input = LinearScan();
        int count = countOccurrences(input);

        System.out.println("The number " + input + " appears " + count + " time(s) in the dataPoints array.");
        System.out.println("The high was "+high+" at index(s)"+ highArrayIndex);
        System.out.println("The low was "+low+" at index(s)"+ lowArrayIndex);

        input = LinearScan();
        count = breakerCode(input);



    }

    public static int LinearScan()
    {
        Scanner in = new Scanner(System.in);
        return SafeInput.getRangedInt(in, "Input number between 0-100", 0, 100);
    }

    public static int countOccurrences(int target)
    {
        int count = 0;
        int i = 0;
        for (int dataPoint : dataPoints)
        {

            if (dataPoint == target)
            {
                count++;
            }
            i++;
        }
        return count;
    }

    public static int breakerCode(int target)
    {
        int count = 0;
        int i = 0;
        for (int dataPoint : dataPoints) {

            if (dataPoint == target) {
                System.out.println("The Number was Found at Index " + i);
                count++;

                System.exit(0);
            }
            i++;
        }
        return count;
    }

    public static double getAverage(int[] values)
    {
        double sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        return sum / values.length;
    }

}