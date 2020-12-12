package curs.work;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

//Матричні перетворення: складання, перемноження, ділення, піднесення до степеня, пошук зворотної матриці та ін.

public class Matrix_app {

    public static void main(String args[]) {

        Matrix matrixA = new Matrix();
        Matrix matrixB = new Matrix();
        int command = -1;
        Scanner in = new Scanner(System.in);

        while (command != 0) {
            System.out.print("1 - ввести матрицю, 2 - множення матриці на число, 3 - піднесення матриці до степеня," +
                    " 4 - складання двох матриць, 5 - множення матриць, 6 - ділення матриці на число, 7 - пошук зворотньої матриці, 0 - вихід:   ");
            command = in.nextInt();
            switch (command) {
                case (1): {
                    if (Matrix.counter % 2 == 0) {
                        matrixA = new Matrix("A");
                        break;
                    }
                    if (Matrix.counter % 2 != 0) {
                        matrixB = new Matrix("B");
                        break;
                    }
                }
                case (2): {
                    int name;
                    double n;
                    System.out.println("1 - обрати матрицю A, 2 - обрати матрицю В");
                    name = in.nextInt();
                    System.out.println("Введіть множник:");
                    n = in.nextDouble();
                    switch (name) {
                        case (1): {
                            matrixA.multiplyOnNUmber(n);
                            break;
                        }
                        case (2): {
                            matrixB.multiplyOnNUmber(n);
                            break;
                        }
                    }
                }

                case (6): {
                    int name;
                    double n;
                    System.out.println("1 - обрати матрицю A, 2 - обрати матрицю В");
                    name = in.nextInt();
                    System.out.println("Введіть дільник:");
                    n = in.nextDouble();
                    switch (name) {
                        case (1): {
                            matrixA.devideOnNUmber(n);
                            break;
                        }
                        case (2): {
                            matrixB.devideOnNUmber(n);
                            break;
                        }
                    }

                }
            }
            //     Matrix matrixA = new Matrix("A");
//        Scanner in = new Scanner(System.in);
//        int rows1 = -1;
//        int columns1 = -1;
//
//        while (rows1 <= 0) {
//            System.out.print("Введіть кількість рядків матриці А (ціле число більше 0): ");
//            int oldRows = rows1;
//            try {
//                rows1 = in.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.print("Сталася помилка при спробі вводу");
//            }
//            if (rows1 == oldRows) break;
//        }
//
//        while (rows1 > 0 && columns1 <= 0) {
//            System.out.print("Введіть кількість колонок матриці А (ціле число більше 0): ");
//            int oldColumns = columns1;
//            try {
//                columns1 = in.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.print("Сталася помилка при спробі вводу");
//            }
//            if (columns1 == oldColumns) break;
//        }


            //    System.out.println(matrixA.rows + " " + matrixA.columns);
        }

    }
}
