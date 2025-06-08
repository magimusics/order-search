package org.order.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    public static String getForDigits(String str) {
        String result = "";
        for (int i = str.length() - 4; i < str.length(); i++) {
            str.charAt(i);
            result += str.charAt(i);

        }
        return result;

    }

    public static List<String> readIDs(String filePath) {
        List<String> readId = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                readId.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        }
        return readId;
    }
}



