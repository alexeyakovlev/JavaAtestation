package main.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements Serializable, Comparable<Animal> {
    private String name;
    private String sex;
    private int age;
    private Animal mother;
    private Animal father;
    private List<Animal> children;

    public Animal(String name, String sex, int age, Animal mother, Animal father) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Animal(String name, String sex, int age) {
        this(name, sex, age, null, null);
    }

    public void addChild(Animal child) {
        if (!children.contains(child)) {
            this.children.add(child);
            if (this.sex == "male") {
                child.father = this;
            } else
                child.mother = this;
        }
    }

    public String printChildren() {
        String res = "Children:";
        if (!this.children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                res += children.get(i).name + ",";
            }
        } else
            res += "no";
        return res;
    }

    @Override
    public String toString() {
        String res = "Name: " + name + ",\t Sex: " + sex + ",Age: " + age;
        if (this.mother != null) {
            res += ", Mother: " + mother.name;
        } else
            res += ", Mother: unknown";

        if (this.father != null) {
            res += ", Father: " + father.name + ",";
        } else
            res += ", Father: unknown,";

        res += printChildren();

        return res;
    }

    public String getName() {
        return name;
    }

    public Animal getFather() {
        return father;
    }

    public Animal getMother() {
        return mother;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return name.compareToIgnoreCase(o.name);
    }
}