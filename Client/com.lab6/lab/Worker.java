package com.lab6.lab;


import com.lab6.parameters.EnumParameter;
import com.lab6.parameters.LocalDateParameter;
import com.lab6.parameters.Parameter;
import com.lab6.parameters.StringParameter;
import com.lab6.parameters.numericalParameters.FloatParameter;
import com.lab6.parameters.numericalParameters.LongParameter;

import java.io.Serializable;
import java.time.LocalDate;

public class Worker implements Serializable, Comparable<Worker> {
    private static final long serialVersionUID = 554565365356L;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    private LocalDate endDate; //Поле может быть null
    private Position position; //Поле не может быть null
    private Status status; //Поле может быть null
    private Organization organization; //Поле может быть null

    @Override
    public int compareTo(Worker worker){
        int result = Float.compare(salary, worker.salary);
        if (result != 0){
            return result;
        }
        return Long.compare(id, worker.id);
    }

    public static class Params {
        public static StringParameter name = new StringParameter("").setMinLength(1);
        public static FloatParameter salary = new FloatParameter(0F).setLowerBound(0F);
        public static LocalDateParameter endDate = new LocalDateParameter(LocalDate.MAX);
        public static EnumParameter<Position> position = new EnumParameter<>(Position.class, Position.NONE);
        public static EnumParameter<Status> status = new EnumParameter<>(Status.class, Status.NONE);
        public static LongParameter id = new LongParameter(0L).setLowerBound(0L);
    }

    public Worker(String name, float salary, LocalDate endDate, Status status, Position position, Organization organization, Coordinates coordinates) {
        this.name = name;
        this.salary = salary;
        this.creationDate = LocalDate.now();
        this.endDate = endDate;
        this.organization = organization;
        this.coordinates = coordinates;
        this.status = status;
        this.position = position;
        this.id = 0L;

    }

    public Worker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }


    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int compareTo(float salary) {
        double dv = Math.floor(this.salary - salary);
        return (int) dv;
    }


}