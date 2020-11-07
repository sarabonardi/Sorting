import java.util.*;
import java.lang.*;

public class LomutoQuickSort {
    public static void main(String args[]) {
        Random random = new Random();
        int[] Data = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            Data[i] = random.nextInt();
        }
        int start = 0;
        int finish = Data.length - 1;
        long time = System.currentTimeMillis();
        Lomuto(start, finish, Data);
        System.out.println(System.currentTimeMillis() - time);
    }
    public static void Lomuto(int L, int U, int[] Data) {
        if (L >= U) {
            return;
        }
        int pivot = Data[L];
        int little = L;
        int big = little;
        int buffer = 0;
        for (int i = L + 1; i <= U; i++) {
            if (Data[i] < pivot) {
                buffer = Data[i];
                Data[i] = Data[little + 1];
                Data[little + 1] = buffer;
                little += 1;
            }
            else {
                big += 1;
            }
        }
        buffer = Data[L];
        Data[L] = Data[little];
        Data[little] = buffer;
        Lomuto(L, (little- 1), Data);
        Lomuto((little + 1), U, Data);
    }
}