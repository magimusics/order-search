package org.order.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class UserContainer {
    @JsonProperty("user")  // важно указать, что поле соответствует "user" в JSON
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User {

        private String id;
        private String username;
        private String email;
        private PersonalInfo personalInfo;
        private Registration registration;
        private Orders orders;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public PersonalInfo getPersonalInfo() {
            return personalInfo;
        }

        public void setPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
        }

        public Registration getRegistration() {
            return registration;
        }

        public void setRegistration(Registration registration) {
            this.registration = registration;
        }

        public Orders getOrders() {
            return orders;
        }

        public void setOrders(Orders orders) {
            this.orders = orders;
        }
    }
}


