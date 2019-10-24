package sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class GroupNumbers {
	
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] res;
        int arr_size = 0;
        arr_size = Integer.parseInt(in.nextLine().trim());

        int[] arr = new int[arr_size];
        for(int i = 0; i < arr_size; i++) {
            int arr_item;
            arr_item = Integer.parseInt(in.nextLine().trim());
            arr[i] = arr_item;
        }

        res = solve(arr);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }


	/*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {

        Random random = new Random();
        int randomIndx = random.nextInt(arr.length);

        //Swamp the PartitionIndex at first place
        int start = 0;
        int tmp = arr[start];
        arr[start] = arr[randomIndx];
        arr[randomIndx] = tmp;

        //Lumoto's partition
        //Find the Even value and swap with right before odd pointer

        int idx_odd = start ;

        for (int idx_even = start + 1; idx_even <= arr.length-1; idx_even++) {
            //Swap the value for even number
            if (arr[idx_even] % 2 == 0) {
                idx_odd++;
                int tmp_even = arr[idx_even];
                arr[idx_even] = arr[idx_odd];
                arr[idx_odd] = tmp_even;
            }
        }
        //Swap back the partition index
        int tmp_partition = arr[start];
        arr[start] = arr[idx_odd];
        arr[idx_odd] = tmp_partition;
        return arr;
    }
}
