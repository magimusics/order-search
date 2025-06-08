package org.order.search;

//import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ClassLoader classLoader = Main.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("users_data.json")) {
            if (inputStream == null) {
                System.out.println("Файл не найден");
                return;
            }
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




//        String path = "D:\\Games\\ID.txt";
//        List<String> list = Order.readIDs(path);
//
//
//
//
//        String result = "1234";
//        for (int j = 0; j < list.size(); j++) {
//            String fullId = list.get(j);
//            String lastForDigit = Order.getForDigits(fullId);
//            if (lastForDigit.equals(result)) {
//                System.out.println("Заказ найден: " + fullId);
//            }
//        }
//    }
