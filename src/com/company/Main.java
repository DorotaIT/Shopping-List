package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean programRun = true;
    static String newLine;
    static int chooseNumber;
    static List<String> shoppingList = new LinkedList<String>();
    //static Scanner in = new Scanner(System.in);
    static Scanner globalInput = new Scanner(System.in);

    public static void main(String[] args) {

        //print commands: add, delete, show all and edit products on list
        printCommand();

        //main loop
        while (programRun) {
            userInput();
            chooseOption();
        }
    }

    public static void chooseOption() {
        if (chooseNumber == 1) {
           addProduct();
        }
        if (chooseNumber == 2) {
            deleteProduct();
        }
        if (chooseNumber == 3) {
            printProductList();
        }
        if (chooseNumber == 4) {
            editProduct();
        }
        if (chooseNumber == 5) {
            downloadTxt();
        }

    }


    public static void addProduct() {
        System.out.println("Podaj nazwę produktu, który chcesz dodać.");
        String productName = globalInput.next();
        shoppingList.add(productName);

        printProductList();
        printCommand();
    }

    public static void deleteProduct() {
        System.out.println('\n' + "Podaj numer produktu, który chcesz skasować.");
        int productName = globalInput.nextInt();
        shoppingList.remove(productName - 1);

        System.out.println('\n' + "Zaktualizowana lista:");

        printProductList();
        printCommand();
    }

    //show product list
    public static void printProductList() {
        // create an array and copy the list to it
        Object[] array = shoppingList.toArray();

        System.out.println('\n' + "Lista zakupów:");

        // print the array
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println(i + 1 + " [" + array[i] + "]");
        }
    }

    //edit product list
    public static void editProduct() {
        System.out.println("Podaj numer produktu, który chcesz edytować.");
        int productIndex = globalInput.nextInt();

        System.out.println("Podaj nową nazwę produktu.");
        String newProductName = globalInput.next();

        shoppingList.set(productIndex - 1, newProductName);

        printProductList();
    }

    //dowload .txt document

    public static void downloadTxt() {
        String file_name = "listaZakupow.txt";

        try {

            int count = 0;


            FileWriter fstream = new FileWriter(file_name);
            BufferedWriter out = new BufferedWriter(fstream);
           

            Iterator i = shoppingList.iterator();
            while (i.hasNext()) {
                count++;
                out.write(Integer.toString(count) + ". " + i.next() + "\n");
            }

            out.close();
            System.out.println("Plik został utworzony pomyślnie.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        printProductList();
    }


    //print instructions for the user
    public static void printCommand(){
        String newLine = System.getProperty("line.separator");
        System.out.println("Wpisz odpowiednią liczbę, aby móc wykonać jakąś operację:" + newLine + "1 - dodaj produkt do listy." + newLine +
                "2 - usuń produkt z listy." + newLine + "3 - wyświetl wszystkie produkty z listy." + newLine + "4 - edytuj produkt z listy." + newLine +
                "5 - pobierz całą listę do pliku .txt");

    }

    //user input
    public static void userInput() {
        chooseNumber = globalInput.nextInt();
    }
}
