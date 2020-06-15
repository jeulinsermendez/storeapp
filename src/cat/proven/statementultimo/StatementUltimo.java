/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.statementultimo;

import cat.proven.statementultimo.model.Model;
import cat.proven.statementultimo.model.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author mati
 */
public class StatementUltimo {

    /**
     * @param args the command line arguments
     */
    Model model;
    public Product run(String action) {
        model = new Model();
        String option;
        Product product = null;
        model.firstStart();

        do {
            option = action ;
            switch (option) {
                case "Q": //exit
                    quit();
                    break;
                case "N":
                    product = next();
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("No hay producto");
                    }

                    break;
                case "P":
                    product = previous();
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("No hay producto");
                    }
                    break;
                case "F'": //move cursor to first registry.
                    product = first();
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("No hay producto");
                    }
                    break;
                case "L": //move cursor to first registry.
                    product = last();
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("No hay producto");
                    }
                    break;
                case "I": //move cursor to first registry.
//                    int result = insertProduct();
//                    if (result == 1) {
//                        System.out.println("Se ha creado el producto");
//                    } else {
//                        System.out.println("No se ha creado el producto");
//                    }

                    break;
                case "U":
                    product = update();
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("No hay producto");
                    }
                    break;
                case "D":
                    int r = deleteProduct();
                    if (r == 1) {
                        System.out.println("Se ha eliminado el producto");
                    } else {
                        System.out.println("No se ha eliminado el producto");
                    }

                    break;
            }

        } while (option != "Q");
        return product;

    }

    private Product productChange() {
        Product product = null;
        String code = "";
        String desc = "";
        double price = 0;
        int stock = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Code");
            code = sc.nextLine();
            System.out.println("Description");
            desc = sc.nextLine();
            System.out.println("Price");
            price = sc.nextDouble();
            System.out.println("Stock");
            stock = sc.nextInt();
            product = new Product(code, desc, price, stock);
        } catch (InputMismatchException e) {
            product = null;
        } catch (NullPointerException e) {
            product = null;
        }
        //String code, String description, double price, int stock

        return product;

    }

    private static char Menu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] options = {"Quit", "First", "Previous", "Next", "Last", "Insert", "Delete",
            "Update"};
        for (String option : options) {
            System.out.println("[" + option.charAt(0) + "]" + " - " + option);
        }

        char op = 'Q';
        try {
            op = ((br.readLine()).toUpperCase()).charAt(0);
        } catch (IOException ioe) {
        }
        return op;
    }

//    private int insertProduct() {
//        int result = 0;
//        result = model.insertRow(productChange());
//        return result;
//    }

    private int deleteProduct() {
        int result = 0;
        result = model.deleteRow();
        return result;
    }

    private void quit() {
        model.quit();
    }

    private Product next() {
        Product product = model.next();
        return product;
    }

    private Product previous() {
        Product product = model.previus();
        return product;
    }

    private Product first() {
        Product product = model.first();
        return product;
    }

    private Product last() {
        Product product = model.last();
        return product;
    }

    private Product update() {
        Product product = model.updateRow(productChange());
        return product;
    }
}
