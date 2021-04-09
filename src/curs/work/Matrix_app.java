package curs.work;

import java.util.InputMismatchException;
import java.util.Scanner;

//64.Програма роботи з матрицями. Матричні перетворення: складання, перемноження, ділення, піднесення до степеню, пошук зворотної матриці та ін.

public class Matrix_app {


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void main(String args[]) {

        Matrix matrixA = new Matrix();
        Matrix matrixB = new Matrix();
        int command = -1;
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_PURPLE + "Оберіть пункт меню:\n");

        while (command != 0) {
            System.out.print(ANSI_PURPLE + "1 - ввести матрицю\n2 - множення матриці на число\n3 - піднесення матриці до степеню\n" +
                    "4 - складання двох матриць\n5 - множення матриць\n6 - ділення матриці на число\n7 - пошук оберненої матриці\n8 - транспонування матриці\n9 - віднімання матриці\n0 - вихід\n");
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
                        int name = chooseMatrix();
                        double n;
                        System.out.println(ANSI_YELLOW + "Введіть множник:");
                        n = in.nextDouble();
                        switch (name) {
                            case (1): {
                                matrixA.multiplyOnNumber(n);
                                break;
                            }
                            case (2): {
                                matrixB.multiplyOnNumber(n);
                                break;
                            }
                        }
                        break;
                    }

                    case (3): {
                        int name = chooseMatrix();
                        int k;
                        System.out.println(ANSI_YELLOW + "Введіть показник степеня (ціле додатнє число)");
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
                        System.out.println(ANSI_YELLOW + "1 - А*В, 2 - В*А");
                        choice = in.nextInt();
                        switch (choice) {
                            case (1): {
                                matrixA.multiplyMatrices(matrixB);
                                break;
                            }
                            case (2): {
                                matrixB.multiplyMatrices(matrixA);
                                break;
                            }
                        }
                        break;
                    }

                    case (6): {
                        int name = chooseMatrix();
                        double n;
                        System.out.println(ANSI_YELLOW + "Введіть дільник:");
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
                        int name = chooseMatrix();
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
                        int name = chooseMatrix();
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
                        System.out.println(ANSI_YELLOW + "1 - А-В, 2 - В-А");
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
                    case (0): {
                        break;
                    }

                    default: {
                        System.out.println(ANSI_PURPLE + "Оберіть пункт меню");
                        break;

                    }
                }
            } catch (InputMismatchException e) {
                System.out.print(ANSI_RED + "Сталася помилка при спробі вводу");
                break;
            }
        }
    }

    public static int chooseMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_YELLOW + "1 - обрати матрицю A, 2 - обрати матрицю В");
        int name = in.nextInt();
        return name;
    }

}

