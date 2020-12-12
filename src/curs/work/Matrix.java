package curs.work;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
    Scanner in = new Scanner(System.in);
    int rows = -1;
    int columns = -1;
    String name;
    static int counter = 0;
    double[][] matrix;

    Matrix() {
        matrix = new double[0][0];
    }

    Matrix(String name) {
        this.name = name;
        while (rows <= 0) {
            System.out.print("Введіть кількість рядків матриці " + name + " (ціле число більше 0): ");
            int oldRows = rows;
            try {
                rows = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Сталася помилка при спробі вводу");
            }
            if (rows == oldRows) break;
        }

        while (rows > 0 && columns <= 0) {
            System.out.print("Введіть кількість колонок матриці " + name + " (ціле число більше 0): ");
            int oldColumns = columns;
            try {
                columns = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Сталася помилка при спробі вводу");
            }
            if (columns == oldColumns) break;
        }

        matrix = new double[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Введіть елемент a[" + (i + 1) + "]" + "[" + (j + 1) + "]" + " матриці  " + name + ": ");
                try {
                    matrix[i][j] = in.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("Сталася помилка при спробі вводу");
                }
                //System.out.print(matrix[i][j] + " ");
            }
            //System.out.println();
        }
        System.out.print("Ваша матриця " + name + ":\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        counter++;
    }

    void multiplyOnNUmber(double number) {
        System.out.printf("Результат множення матриці %s на число %.2f\n", name, number);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * number;
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void devideOnNUmber(double number) {
        System.out.printf("Результат ділення матриці %s на число %.2f\n", name, number);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] / number;
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
