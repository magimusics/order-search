package org.order.search;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.order.search.dto.UserContainer;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        List<UserContainer> userContainers = readUserData();
        if (userContainers == null) return;

        List<String> allOrderIds = extractAllOrderIds(userContainers);
        System.out.println("Все ID заказов: " + allOrderIds);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите заказ: ");
        String zakaz = scanner.nextLine();

        List<String> foundOrders = findOrdersByLastDigits(allOrderIds, zakaz);
        System.out.println("Найденные заказы  " + foundOrders);
    }

    private static List<UserContainer> readUserData() {
        ClassLoader classLoader = Main.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("users_data.json")) {
            if (inputStream == null) {
                System.out.println("Файл не найден");
                return null;
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, new TypeReference<List<UserContainer>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> extractAllOrderIds(List<UserContainer> userContainers) {
        List<String> allOrderIds = new ArrayList<>();
        for (UserContainer container : userContainers) {
            if (container.getUser() != null &&
                    container.getUser().getOrders() != null &&
                    container.getUser().getOrders().getLastOrderIds() != null) {
                allOrderIds.addAll(container.getUser().getOrders().getLastOrderIds());
            }
        }
        return allOrderIds;
    }

    private static List<String> findOrdersByLastDigits(List<String> orderIds, String lastDigits) {
        return orderIds.stream()
                .filter(orderId -> Order.getLastFourDigits(orderId).equals(lastDigits))
                .collect(Collectors.toList());
    }
}
