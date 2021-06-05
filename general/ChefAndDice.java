package general;

import java.io.*;

class ChefAndDice {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                long n = Long.parseLong(br.readLine());

                int base_dat[] = new int[4];
                base_dat[1] = 20;
                base_dat[2] = 36;
                base_dat[3] = 51;

                long noOfCubesOnTopLayer = n % 4;
                long noOfLayers = n / 4;
                System.out.println("noOfCubesOnTopLayer: " + noOfCubesOnTopLayer + "\tnoOfLayers: " + noOfLayers);
                
                if (noOfCubesOnTopLayer == 0) {
                    System.out.println(11 * n + 16);;
                } else {

                    if (noOfLayers == 0)    System.out.println(base_dat[(int)noOfCubesOnTopLayer]);
                    else {
                        long ans = (noOfLayers - 1) * 44 + 60 - 4 * noOfCubesOnTopLayer + base_dat[(int)noOfCubesOnTopLayer];

                        System.out.println(ans);
                    }
                }
            }

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}