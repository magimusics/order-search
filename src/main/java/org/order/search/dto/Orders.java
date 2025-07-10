package org.order.search.dto;
import java.util.List;



public class Orders {
    public List<String> lastOrderIds;
    public List<String> getLastOrderIds() {
        return lastOrderIds;
    }
    public void setLastOrderIds(List<String> lastOrderIds) {
        this.lastOrderIds = lastOrderIds;
    }
}
