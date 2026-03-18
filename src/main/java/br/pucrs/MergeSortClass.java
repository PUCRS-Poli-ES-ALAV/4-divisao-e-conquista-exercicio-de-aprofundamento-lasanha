package br.pucrs;

import java.util.Arrays;
import java.util.Random;

public class MergeSortClass 
{
    private static long interations;
    public static void main( String[] args ) throws Exception
    {
        Random rn = new Random();
        int[] arr1 = new int[32];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rn.nextInt();
        }
        interations = 0;

        arr1 = mergeSort(arr1);
        boolean verify = true;
        for (int i = 0; i < arr1.length-1; i++) {
            if(arr1[i] > arr1[i+1]){
                verify = false;
                break;
            }
        }

        System.out.printf("Sort bem sucedido: %b\nIterações: %d\n", verify, interations);

        int[] arr2 = new int[2048];
        
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rn.nextInt();
        }
        interations = 0;

        arr2 = mergeSort(arr2);
        verify = true;
        for (int i = 0; i < arr2.length-1; i++) {
            if(arr2[i] > arr2[i+1]){
                verify = false;
                break;
            }
        }

        System.out.printf("Sort bem sucedido: %b\nIterações: %d\n", verify, interations);

        int[] arr3 = new int[1048576];
         for (int i = 0; i < arr3.length; i++) {
            arr3[i] = rn.nextInt();
        }
        interations = 0;

        arr3 = mergeSort(arr3);
        verify = true;
        for (int i = 0; i < arr3.length-1; i++) {
            if(arr3[i] > arr3[i+1]){
                verify = false;
                break;
            }
        }

        System.out.printf("Sort bem sucedido: %b\nIterações: %d\n", verify, interations);
    }

    public static int[] mergeSort(int[] list) throws Exception{
        if(list.length == 0){
            throw new Exception("Lista Vazia");
        }
        interations++;
        if(list.length == 1){
            return list;
        }
        int[] esq = mergeSort(Arrays.copyOfRange(list, 0, list.length/2));
        int[] dir = mergeSort(Arrays.copyOfRange(list, list.length/2, list.length));

        return merge(esq, dir);
    }

    public static int[] merge(int[] a, int[] b){
        int[] response = new int[a.length+b.length];
        int counterA = 0;
        int counterB = 0;
        /* for (int i = 0; i < response.length; i++) {
            if(counterA >= a.length){
                return response;
            }
            while(counterB < b.length && a[counterA] >= b[counterB]){
                response[i] = b[counterB];
                counterB++;
                i++;
            }
            response[i] = a[counterA];
            counterA++;
        } */
       while(counterA < a.length && counterB < b.length){
            interations++;
            if(a[counterA] < b[counterB]){
                response[counterA+counterB] = a[counterA++];
            }else{
                response[counterA+counterB] = b[counterB++];
            }
        }
        return response;
    }
}
