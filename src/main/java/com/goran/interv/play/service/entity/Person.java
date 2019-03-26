package com.goran.interv.play.service.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Document
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, property = "_class")
public class Person {

    @Id
    private String id;

    @Indexed(unique = true)
    private String jmbg;

    private String name;

    private String surname;

    public void setId(String id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(jmbg, person.jmbg) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override public int hashCode() {
        return Objects.hash(id, jmbg, name, surname);
    }

    @Override public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
