package com.example.my10_intentresult;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private String name;
    private int pw;

    public PersonDTO(String name, int pw) {
        this.name = name;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }
}
