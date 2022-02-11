package com.example.bt2;

public class Contact {
    private int id;
    private String Name;
    private String Number;
    private boolean Status;

    public Contact(int id, String name, String number) {
        this.id = id;
        Name = name;
        Number = number;
        Status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }
}
