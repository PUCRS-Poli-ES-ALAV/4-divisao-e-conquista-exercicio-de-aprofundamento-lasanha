package br.pucrs;

import java.util.Random;
import java.util.Scanner;

public class Multiplicacao2{

    static int it = 0;

    public static void main (String [] args){  
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        int bits = sc.nextInt();
        Random r = new Random();
        String x = String.format("%" + bits + "s", Long.toBinaryString(r.nextLong() & ((1L << bits) - 1))).replace(' ', '0');
        String y = String.format("%" + bits + "s", Long.toBinaryString(r.nextLong() & ((1L << bits) - 1))).replace(' ', '0');
        System.out.println("x: "+x+"| y: "+y);
        long startTime = System.currentTimeMillis();
        long f = multiply(x,y);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(f);
        System.out.println("duracao: "+duration);
        System.out.println("iteracoes: "+it);
    }

    public static long multiply (String x, String y){
        it++;
        if (y.isEmpty()){
            return 0;
        }
        else{
            if(y.charAt(y.length()-1) =='1'){
                return soma(Long.parseLong(x, 2),multiply(x.concat("0"), y.substring(0,y.length()-1))); 
            }
            else{
                return soma(0, multiply(x.concat("0"), y.substring(0,y.length()-1)));
            } 
        }
     }
     
    public static long soma(long a, long b) {
        it++;
        if (b == 0) {
            return a;
        }
        if (a == 0){
            return b;
        }
        return soma(a ^ b, (a & b) << 1);
    }
}