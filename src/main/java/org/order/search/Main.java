package org.order.search;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.order.search.dto.UserContainer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("users_data.json")) {
            if (inputStream == null) {
                System.out.println("Файл не найден");
                return;
            }
            ObjectMapper mapper = new ObjectMapper();
            List<UserContainer> userContainers = mapper.readValue(
                    inputStream,
                    new TypeReference<List<UserContainer>>() {}
            );
            for (UserContainer container : userContainers) {
                UserContainer.User user = container.getUser();
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
            }

        } catch (Exception e) {
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
