package com.david.todolist.datamodel;

import java.time.LocalDate;

public class Todoitem {

    private String shortDiscription;
    private String details;
    private LocalDate deadline;

    public Todoitem(String shortDiscription, String details, LocalDate deadline) {
        this.shortDiscription = shortDiscription;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDiscription() {
        return shortDiscription;
    }

    public void setShortDiscription(String shortDiscription) {
        this.shortDiscription = shortDiscription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortDiscription;
    }
}
