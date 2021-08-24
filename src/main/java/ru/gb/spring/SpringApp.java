package ru.gb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
       Cart cart = context.getBean(Cart.class);
       ProductRepository productRepository = context.getBean(ProductRepository.class);
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("Введите команду: ");
            String [] strgs = in.nextLine().split(" ");
            String str ="";
            int id =0;
            if (strgs.length ==0) break;
                else if(strgs.length ==1) {
                    str = strgs[0];}
                else if(strgs.length ==2){
                    str = strgs[0];
                    id = Integer.parseInt(strgs[1]);
            }
            switch (str){
                case "/exit" :
                    System.out.println("Выход");
                    return;
                case "/new": cart = context.getBean("cart",Cart.class);
                            break;
                case "/add": cart.addProduct(id);
                            break;
                case "/del": cart.deleteProduct(id);
                            break;
                case "/list": cart.showProducts();
                            break;
                case "/show": productRepository.showProducts();
                            break;
                default: break;
            }
        }
    }
}
