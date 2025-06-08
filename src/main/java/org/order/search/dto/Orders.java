package org.order.search.dto;

import java.util.List;

class Orders {
    private List<String> lastOrderIds;

    public List<String> getLastOrderIds() {
        return lastOrderIds;
    }

    public void setLastOrderIds(List<String> lastOrderIds) {
        this.lastOrderIds = lastOrderIds;
    }
}
