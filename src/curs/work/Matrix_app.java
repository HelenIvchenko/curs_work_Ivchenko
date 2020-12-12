package curs.work;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

//Матричні перетворення: складання, перемноження, ділення, піднесення до степеня, пошук зворотної матриці та ін.

public class Matrix_app {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int rows1 = -1;
        int columns1 = -1;

        while (rows1 <= 0) {
            System.out.print("Введіть кількість рядків матриці А (ціле число більше 0): ");
            int oldRows = rows1;
            try {
                rows1 = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Сталася помилка при спробі вводу");
            }
            if (rows1 == oldRows) break;
        }

        while (rows1 > 0 && columns1 <= 0) {
            System.out.print("Введіть кількість колонок матриці А (ціле число більше 0): ");
            int oldColumns = columns1;
            try {
                columns1 = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Сталася помилка при спробі вводу");
            }
            if (columns1 == oldColumns) break;
        }


        System.out.println(rows1 + " " + columns1);
    }

}
