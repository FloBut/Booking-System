package org.example;

import java.util.ArrayList;
import java.util.List;
//clasa utilizator are un nume si prenume si o lista de rezervari
//utlizatorul poate fi client
public class User {
    private String name;


    public User(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + name + '\'' +
                '}';
    }
}
