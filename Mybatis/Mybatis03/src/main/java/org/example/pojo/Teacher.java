package org.example.pojo;

public class Teacher {
    private int tid;
    private String name;

    public Teacher() {
    }

    public Teacher(int tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public String getName() {
        return name;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                '}';
    }
}
