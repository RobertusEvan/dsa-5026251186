package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = sc.nextInt();
        int[] parcels = new int[n];
        for (int i = 0; i < n; i++) {
            parcels[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        // Bubble Sort (DESCENDING)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (parcels[j] < parcels[j + 1]) {
                    int temp = parcels[j];
                    parcels[j] = parcels[j + 1];
                    parcels[j + 1] = temp;
                }
            }
        }

        // Simpan copy array setelah 2 pass
        int[] setelah = new int[n];
        for (int i = 0; i < n; i++) {
            setelah[i] = parcels[i];
        }

        // Lanjutkan sorting
        for (int i = 2; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (parcels[j] < parcels[j + 1]) {
                    int temp = parcels[j];
                    parcels[j] = parcels[j + 1];
                    parcels[j + 1] = temp;
                }
            }
        }

        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < n; i++) {
            System.out.print(setelah[i] + (i < n - 1 ? " " : ""));
        }
        System.out.println();
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < n; i++) {
            System.out.print(parcels[i] + (i < n - 1 ? " " : ""));
        }
        System.out.println();
        System.out.println();

        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++) {
            int target = targets[i];
            int low = 0;
            int high = n - 1;
            int steps = 0;
            boolean found = false;
            int foundIndex = -1;

            while (low <= high) {
                steps++;
                int mid = (low + high) / 2;

                if (parcels[mid] == target) {
                    found = true;
                    foundIndex = mid;
                    break;
                } else if (parcels[mid] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (found) {
                System.out.println(target + ": FOUND at index " + foundIndex + " (steps: " + steps + ")");
            } else {
                System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
}