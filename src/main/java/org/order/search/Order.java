package org.order.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    public static String getLastFourDigits(String orderId) {
        if (orderId == null || orderId.length() < 4) {
            return "";
        }
        return orderId.substring(orderId.length() - 4);
    }
}





