package com.budgo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.budgo");
        Scanner scanner = new Scanner(System.in);
        Cart cart = (Cart) context.getBean("cart");

        int id = scanner.nextInt();
        cart.addProduct(id);

        id = scanner.nextInt();
        cart.addProduct(id);

        cart.printCart();
        id = scanner.nextInt();
        cart.removeProduct(id);
        cart.printCart();

        Cart cart1 = (Cart) context.getBean("cart");
        id = scanner.nextInt();
        cart1.addProduct(id);
        cart1.printCart();

    }
}