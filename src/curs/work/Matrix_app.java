package curs.work;

import java.util.InputMismatchException;
import java.util.Scanner;

//64.Програма роботи з матрицями. Матричні перетворення: складання, перемноження, ділення, піднесення до степеня, пошук зворотної матриці та ін.

public class Matrix_app {

    public static void main(String args[]) {

        Matrix matrixA = new Matrix();
        Matrix matrixB = new Matrix();
        int command = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("Оберіть пункт меню");

        while (command != 0) {
            System.out.print("1 - ввести матрицю, 2 - множення матриці на число, 3 - піднесення матриці до степеня," +
                    " 4 - складання двох матриць, 5 - множення матриць,\n6 - ділення матриці на число, 7 - пошук оберненої матриці, 8 - транспонування матриці, 9 - віднімання матриці, 0 - вихід:   ");
            try {
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
                        int name = matrixA.chooseMatrix();
                        double n;
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
                        break;
                    }

                    case (3): {
                        int name = matrixA.chooseMatrix();
                        int k;
                        System.out.println("Введіть показник степеня (ціле додатнє число)");
                        k = in.nextInt();
                        switch (name) {
                            case (1): {
                                matrixA.exponentMatrix(k);
                                break;
                            }
                            case (2): {
                                matrixB.exponentMatrix(k);
                                break;
                            }
                        }
                        break;
                    }
                    case (4): {
                        matrixA.addMatrices(matrixB);
                        break;
                    }

                    case (5): {
                        int choice;
                        System.out.println("1 - А*В, 2 - В*А");
                        choice = in.nextInt();
                        switch (choice) {
                            case (1): {
                                matrixA.multiplyMatrix(matrixB);
                                break;
                            }
                            case (2): {
                                matrixB.multiplyMatrix(matrixA);
                                break;
                            }
                        }
                        break;
                    }

                    case (6): {
                        int name = matrixA.chooseMatrix();
                        double n;
                        System.out.println("Введіть дільник:");
                        n = in.nextDouble();
                        switch (name) {
                            case (1): {
                                matrixA.divideOnNUmber(n);
                                break;
                            }
                            case (2): {
                                matrixB.divideOnNUmber(n);
                                break;
                            }
                        }
                        break;

                    }

                    case (7): {
                        int name = matrixA.chooseMatrix();
                        switch (name) {
                            case (1): {
                                matrixA.findInvertedMatrix();
                                break;
                            }
                            case (2): {
                                matrixB.findInvertedMatrix();
                                break;
                            }
                        }
                        break;

                    }

                    case (8): {
                        int name = matrixA.chooseMatrix();
                        switch (name) {
                            case (1): {
                                matrixA.transpose();
                                break;
                            }
                            case (2): {
                                matrixB.transpose();
                                break;
                            }
                        }
                        break;

                    }
                    case (9): {
                        int choice;
                        System.out.println("1 - А-В, 2 - В-А");
                        choice = in.nextInt();
                        switch (choice) {
                            case (1): {
                                matrixA.subtractionMatrices(matrixB);
                                break;
                            }
                            case (2): {
                                matrixB.subtractionMatrices(matrixA);
                                break;
                            }
                        }
                        break;
                    }

                    default: {
                        System.out.println("Оберіть пункт меню");
                        break;

                    }
                }
            } catch (InputMismatchException e) {
                System.out.print("Сталася помилка при спробі вводу");
                break;
            }
        }
    }

}

