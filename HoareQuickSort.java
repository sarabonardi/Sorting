import java.util.*;
import java.lang.*;

public class HoareQuickSort {
    public static void main(String args[]) {
        Random random = new Random();
        int[] Data = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            Data[i] = random.nextInt();
        }
        int start = 0;
        int finish = Data.length - 1;
        long time = System.currentTimeMillis();
        Hoare(start, finish, Data);
        System.out.println(System.currentTimeMillis() - time);
    }
    public static void Hoare(int L, int U, int[] Data) {
        if (L >= U) {
            return;
        }
        int buffer = 0;
        if (Data[L] < Data[U]) {
            buffer = Data[L];
            Data[L] = Data[U];
            Data[U] = buffer;
        }
        int pivot = Data[U];
        int B = L;
        int T = U;
        do {
            buffer = Data[B];
            Data[B] = Data[T];
            Data[T] = buffer;
            do {
                B = B + 1;
            } while (Data[B] < pivot);
            do {
                T = T - 1;
            } while (Data[T] > pivot);
        } while (B < T);
        buffer = Data[L];
        Data[L] = Data[T];
        Hoare(L, (T - 1), Data);
        Hoare((T + 1), U, Data);
    }
}
