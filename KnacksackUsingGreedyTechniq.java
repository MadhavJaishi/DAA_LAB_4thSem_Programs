import java.util.Arrays;
import java.util.Scanner;
class KnacksackUsingGreedyTechniq
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.println("Enter the no. of items: ");
        n = sc.nextInt();
        int[] weight = new int[n];
        int[] profit = new int[n];
        int[] items = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter Profit and Weight: ");
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            items[i] = i + 1;

        }
        System.out.println("Enter the Knapsack capacity: ");
        m = sc.nextInt();

        double[] p_w = new double[n];
        for(int i = 0; i < n; i++)
        {
            p_w[i] = (double)profit[i] / (double)weight[i];
        }
        System.out.println();
        System.out.println("-------------------");
        System.out.println("-----Data-Set------");
        System.out.print("-------------------");
        System.out.println();
        System.out.print("Items: ");
        for(int i = 1; i <= n; i++)
        {
            System.out.print(i + "    ");
        }
        System.out.println();
        System.out.print("Profit: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(profit[i] + "    ");
        }
        System.out.println();
        System.out.print("Weight: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(weight[i] + "    ");
        }
        System.out.println();
        System.out.print("P/W: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(p_w[i] + "  ");
        }
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(p_w[i] < p_w[j])
                {
                    double temp = p_w[j];
                    p_w[j] = p_w[i];
                    p_w[i] = temp;

                    int temp1 = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp1;

                    int temp2 = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp2;

                    int temp3 = items[i];
                    items[i] = items[j];
                    items[j] = temp3;

                }
            }
        }
        System.out.println();
        System.out.println("-------------------");
        System.out.println("--After Arranging--");
        System.out.print("-------------------");
        System.out.println();
        System.out.print("Items: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(items[i] + "    ");
        }
        System.out.println();
        System.out.print("Profit: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(profit[i] + "    ");
        }
        System.out.println();
        System.out.print("Weight: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(weight[i] + "    ");
        }
        System.out.println();
        System.out.print("P/W: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(p_w[i] + "  ");
        }
        int[] selectedItems = new int[n];
        int k = 0;
        double sum = 0;
        System.out.println();
        while(m > 0)
        {
            if(weight[k] < m)
            {
                sum += profit[k];
                m = m - weight[k];
                selectedItems[k] = items[k];
            }
            else
            {
                double temp = (double) (m * profit[k]) / weight[k];
                sum = sum + temp;
                selectedItems[k] = items[k];
                m = 0;
            }
            k++;
        }
        System.out.println("Final Profit is=" + sum);
        System.out.println("Items considered are: ");
        System.out.print(Arrays.toString(selectedItems));
    }
}

//Sample Output
//Enter the no. of items:
//6
//Enter Profit and Weight:
//10 1
//Enter Profit and Weight:
//15 3
//Enter Profit and Weight:
//7 5
//Enter Profit and Weight:
//8 4
//Enter Profit and Weight:
//9 1
//Enter Profit and Weight:
//4 3
//Enter the Knapsack capacity:
//15
//
//-------------------
//-----Data-Set------
//-------------------
//Items: 1    2    3    4    5    6
//Profit: 10    15    7    8    9    4
//Weight: 1    3    5    4    1    3
//P/W: 10.0  5.0  1.4  2.0  9.0  1.3333333333333333
//-------------------
//--After Arranging--
//-------------------
//Items: 1    5    2    4    3    6
//Profit: 10    9    15    8    7    4
//Weight: 1    1    3    4    5    3
//P/W: 10.0  9.0  5.0  2.0  1.4  1.3333333333333333
//Final Profit is=50.333333333333336
//Items considered are:
//[1, 5, 2, 4, 3, 6]
