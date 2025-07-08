package org.order.search;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.order.search.dto.User;
import org.order.search.dto.UserContainer;
import java.io.InputStream;
import java.security.AllPermission;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        List<UserContainer> userContainers = readUserData();
        if (userContainers == null) return;


        Map<String, User> users = new HashMap<>();
        for (UserContainer container  : userContainers) {
            if (container.getUser() != null && container.getUser().getId() != null) {
                users.put(container.getUser().getId(), container.getUser());
            }
        }

        List<String> allOrderIds = extractOrderIds(userContainers);
        System.out.println("Все ID заказов: " + allOrderIds);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите заказ: ");
        String order = scanner.nextLine();


        List<String> foundOrdersIds = findOrdersByLastDigits(allOrderIds, order);
        System.out.println("Найденные заказы  " + foundOrdersIds);
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

    private static List<String> extractOrderIds(List<UserContainer> userContainers) {
        List<String> orderIds = new ArrayList<>();
        for (UserContainer container : userContainers) {
            if (container.getUser() != null &&
                    container.getUser().getId() != null) {
                orderIds.add(container.getUser().getId());
            }
        }
        return orderIds;
    }

    private static List<String> findOrdersByLastDigits(List<String> orderIds, String lastDigits) {
        return orderIds.stream()
                .filter(orderId -> Order.getLastFourDigits(orderId).equals(lastDigits))
                .collect(Collectors.toList());
    }
}
