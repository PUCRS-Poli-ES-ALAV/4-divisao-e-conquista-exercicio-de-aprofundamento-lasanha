package br.pucrs;

import java.util.Random;
import java.util.Scanner;

public class Multiplicacao {

    static int it = 0;
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        int bits = sc.nextInt();
        Random r = new Random();
        long x = r.nextLong() & ((1L << bits) - 1);
        long y = r.nextLong() & ((1L << bits) - 1);
        System.out.println("x: "+x+"| y: "+y);
        long startTime = System.currentTimeMillis();
        long f = multiply(x,y,bits);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(f);
        System.out.println("duracao: "+duration);
        System.out.println("iteracoes: "+it);
    }

    static long multiply (long x, long y, long n){
        it++;
        if (n == 1){return x*y;}
        else{
            long m = n/2;
            long a = x/((long)Math.pow(2,m));
            long b = x % ((long)Math.pow(2,m));
            long c = y/((long)Math.pow(2,m));
            long d = y % ((long)Math.pow(2,m));
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            return ((long)Math.pow(2,(2*m)))*e+((long)Math.pow(2,m))*(g+h)+f;
        }
    }
}