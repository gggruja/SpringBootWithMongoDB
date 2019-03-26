package com.goran.interv.play.api.dto;

import java.util.Objects;

public class PersonDTO {

    private String jmbg;

    private String name;

    private String surname;

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
        PersonDTO personDTO = (PersonDTO) o;
        return
                Objects.equals(jmbg, personDTO.jmbg) &&
                        Objects.equals(name, personDTO.name) &&
                        Objects.equals(surname, personDTO.surname);
    }

    @Override public int hashCode() {
        return Objects.hash(jmbg, name, surname);
    }

    @Override public String toString() {
        return "PersonDTO{" +
                ", jmbg='" + jmbg + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
