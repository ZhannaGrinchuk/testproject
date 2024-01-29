package com.example.data;

public class CreatingUserData {

    private String name;
    private String job;


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public CreatingUserData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static CreatingUserData getData() {
        final String name = "morpheus";
        final String job = "leader";
        return new CreatingUserData(name, job);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
