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

    void divideOnNUmber(double number) {
        System.out.printf("Результат ділення матриці %s на число %.2f\n", name, number);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] / number;
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    void exponentMatrix(int k) {
        if (this.columns == this.rows) {
            Matrix result = multiplyMatrices(this, this);
            System.out.printf("Результат піднесення матриці %s до степеня %d\n", this.name, k);
            for (int s = 1; s < +k; s++) {
                for (int i = 0; i < result.matrix.length; i++) {
                    for (int j = 0; j < result.matrix[i].length; j++) {
                        System.out.print(result.matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        } else
            System.out.printf("Для піднесення до степеня матриця %s має бути квадратною\n", this.name);
    }

    public int chooseMatrix() {
        System.out.println("1 - обрати матрицю A, 2 - обрати матрицю В");
        int name = in.nextInt();
        return name;
    }

    void multiplyMatrix(Matrix secondMatrix) {
        if (this.columns == secondMatrix.rows) {
            Matrix result = multiplyMatrices(this, secondMatrix);
            System.out.printf("Результат множення матриці %s на матрицю %s\n", this.name, secondMatrix.name);
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    System.out.print(result.matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else
            System.out.printf("Кількість стовбців матриці %s має дорівнювтаи кількості рядків матриці %s\n", this.name, secondMatrix.name);
    }

    Matrix multiplyMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix result = new Matrix();
        result.matrix = new double[firstMatrix.rows][secondMatrix.columns];
        for (int i = 0; i < firstMatrix.rows; i++) {
            for (int j = 0; j < secondMatrix.columns; j++) {
                for (int k = 0; k < firstMatrix.columns; k++) {
                    result.matrix[i][j] += firstMatrix.matrix[i][k] * secondMatrix.matrix[k][j];
                }
            }
        }
        return result;
    }



    Matrix addMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix result = new Matrix();
        result.matrix = new double[firstMatrix.rows][secondMatrix.columns];
        for (int i = 0; i < firstMatrix.rows; i++) {
            for (int j = 0; j < secondMatrix.columns; j++) {
                result.matrix[i][j] += firstMatrix.matrix[i][j] + secondMatrix.matrix[i][j];
            }
        }
        return result;
    }

    void addMatrices(Matrix secondMatrix) {
        if (this.columns == secondMatrix.columns && this.rows == secondMatrix.rows) {
            Matrix result = addMatrices(this, secondMatrix);
            System.out.printf("Результат додавання матриці %s та матриці %s\n", this.name, secondMatrix.name);
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    System.out.print(result.matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else
            System.out.printf("Кількість рядків і стовбців матриці %s має дорівнювтаи кількості рядків і стовбців матриці %s відповідно\n", this.name, secondMatrix.name);
    }

    void findInvertedMatrix() {
        if (this.columns == this.rows) {
            Matrix result = multiplyMatrices(this, this);
            System.out.printf("Обернена матриця до матриці %s \n", this.name);

                for (int i = 0; i < result.matrix.length; i++) {
                    for (int j = 0; j < result.matrix[i].length; j++) {
                        System.out.print(result.matrix[i][j] + " ");
                    }
                    System.out.println();
                }

        } else
            System.out.printf("Для пошуку оберненої матриці матриця %s має бути квадратною\n", this.name);
    }


    public static Matrix invert(Matrix forInversion) {
        Matrix resultMatrix = new Matrix();
        double matrixArray[][] = forInversion.matrix;
        int n = matrixArray.length;
        double result[][] = new double[n][n];
        double serviceArray[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            serviceArray[i][i] = 1;

        gausMethod(matrixArray, index);

        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    serviceArray[index[j]][k]
                            -= matrixArray[index[j]][i] * serviceArray[index[i]][k];

        for (int i = 0; i < n; ++i) {
            result[n - 1][i] = serviceArray[index[n - 1]][i] / matrixArray[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                result[j][i] = serviceArray[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    result[j][i] -= matrixArray[index[j]][k] * result[k][i];
                }
                result[j][i] /= matrixArray[index[j]][j];
            }
        }
        resultMatrix.matrix = result;
        return resultMatrix;
    }

    public static void gausMethod(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        for (int i = 0; i < n; ++i)
            index[i] = i;

        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }
}
