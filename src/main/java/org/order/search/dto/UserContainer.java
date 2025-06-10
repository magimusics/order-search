package org.order.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class UserContainer {
    @JsonProperty("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



