package com.company.number2;

import java.util.Scanner;

public class Main {



    public static SumInfo sumAndCountE(double x, double e) {
        double sum = 1;
        double slag = x;
        int i = 1;
        while (Math.abs(slag) > e) {
            slag = slag * x / i;
            sum += slag;
            i++;
        }
        return new SumInfo(sum, i);
    }

    public static double sumN(double x, int n) {
        double sum = 0;
        double slag = -1;
        for (int i = 1; i <= n; i++) {
            slag = slag * x / (i + 1);
            sum += slag;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter x: ");
        double x = scan.nextDouble();
        System.out.print("enter the number of terms n: ");
        int n = scan.nextInt();
        System.out.print("enter the accuracy е: ");
        double e = scan.nextDouble();

        double ideal = Math.log(1-x);
        double resultN = sumN(x, n);
        SumInfo infoE = sumAndCountE(x, e);
        SumInfo infoE10 = sumAndCountE(x, e * 0.1);
        double resultE = infoE.getSum();
        int countE = infoE.getCount();
        double resultE10 = infoE10.getSum();
        int countE10 = infoE10.getCount();

        System.out.printf(" 1. Sum ideal = %.15f;\n", ideal);
        System.out.printf(" 2. Sum n = %.15f;     delta = %e\n ", resultN, Math.abs(ideal - resultN));
        System.out.printf("3. Sum e = %.15f;      delta = %e; count = %d\n ", resultE, Math.abs(ideal - resultE), countE);
        System.out.printf("4. Sum e/10 = %.15f;   delta = %e; count = %d\n ", resultE10, Math.abs(ideal - resultE10), countE10);
    }
}