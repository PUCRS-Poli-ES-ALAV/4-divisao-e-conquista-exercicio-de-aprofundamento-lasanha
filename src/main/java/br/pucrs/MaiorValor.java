package br.pucrs;

import java.util.Random;
import java.util.Scanner;

public class MaiorValor {

    //Para o algoritmo que não utiliza divisão e conquista:
    //O número de iterações é sempre um número menor do que o tamanho do vetor.
    //Para os vetores de tamanho 32 e 2048, nem contabilizou o tempo.
    //Para o de 1.048.576, demorou apenas 6 milisegundos.

    //Para o algoritmo que utiliza divisão e conquista:
    //O tempo é essencialmente o mesmo do algoritmo que não utiliza.
    //O número de iterações também. 👌

    static int it = 0;

    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        Scanner sc = new Scanner(System.in);
        int nro = sc.nextInt();
        long [] a = new long[nro];
        Random r = new Random();
        for (int i = 0;i<nro;i++){
            a[i]= r.nextInt(nro);
        }
        long startTime = System.currentTimeMillis();
        // long f = maxVal1(a,nro);
        long f = maxVal2(a,0,nro-1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(f);
        System.out.println("duracao: "+duration);
        System.out.println("iteracoes: "+it);
    }

    static long maxVal1(long A[], int n) {  
        long max = A[0];
       for (int i = 1; i < n; i++) {  
           if( A[i] > max ) 
              max = A[i];
            it++;
       }
       return max;
   }

   static long maxVal2(long A[], int init, int end) {  
    it++;
       if (end - init <= 1)
           return max(A[init], A[end]);  
       else {
             int m = (init + end)/2;
             long v1 = maxVal2(A,init,m);   
             long v2 = maxVal2(A,m+1,end);  
             return max(v1,v2);
            }
   }

   static long max (long v1, long v2){
    return v1>=v2 ? v1 : v2;
   }



}