package com.lab6.workersManager;


import com.lab6.lab.Position;
import com.lab6.lab.Status;
import com.lab6.lab.Worker;
import com.lab6.workersManager.exceptions.ExistenceException;
import com.lab6.workersManager.exceptions.NotFoundException;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkersManager {
    private ArrayList<Worker> workers;
    public final LocalDateTime creationTime;

    public WorkersManager() {
        this.workers = new ArrayList<Worker>();
        this.creationTime = LocalDateTime.now();
    }

    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    public void clear() {
        this.workers.clear();
    }

    public void add(Worker w) {
        w.setCreationDate(LocalDate.now());
        w.setId(1 + (long) (Math.random() * (Long.MAX_VALUE - 1)));
        workers.add(w);
    }

    public Long minByStatus() {
        Worker test = workers.stream()
                .filter(x -> x.getStatus() == Status.FIRED ||
                        x.getStatus() == Status.PROBATION ||
                        x.getStatus() == Status.HIRED ||
                        x.getStatus() == Status.REGULAR ||
                        x.getStatus() == Status.RECOMMENDED_FOR_PROMOTION)
                .findFirst().orElse(null);
        return ((test).getId());
    }

    public void removeGreater(Float salary) {
        ArrayList<Worker> test = getWorkerStream()
                .filter(x -> x.getSalary() < salary)
                .collect(Collectors.toCollection(ArrayList::new));
        setaList(test);
        Collections.sort(workers);
    }

    public void removeLower(Float salary) {
        ArrayList<Worker> test = getWorkerStream()
                .filter(x -> x.getSalary() > salary)
                .collect(Collectors.toCollection(ArrayList::new));
        setaList(test);
        Collections.sort(workers);
    }

    public void removeLast(){
        workers.remove(workers.size() - 1);
        Collections.sort(workers);
    }

    public void removeById(Long id) {
        List<Worker> test = getWorkerStream()
                .filter(x -> !x.getId().equals(id))
                .collect(Collectors.toList());
        Collections.sort(test);
        setaList((ArrayList<Worker>) test);
    }

    private String elementToString(Worker worker){
        DateFormat df = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
        if (worker == null){
            return "No elements";

        }        return worker.getId() + ","
                + worker.getName() + ",\""
                + worker.getCoordinates().toString() + "\","
                + worker.getCreationDate() + ","
                + worker.getSalary() + ","
                + df.format(worker.getEndDate()) + ","
                + worker.getPosition() + ","
                + worker.getStatus() + ",\""
                + worker.getOrganization().getAnnualTurnover() + ","
                + worker.getOrganization().getOfficialAddress() + "\"";
    }

    public String filterByStartDate(LocalDate start_date){
        String result = "";
        Collections.sort(workers);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Worker> test = workers.stream()
                .filter(x -> {
                    formatter.format(x.getEndDate());
                    return false;
                })
                .collect(Collectors.toList());
        for (Worker element : test) {
            result += elementToString(element) + " ";
        }
        return result;
    }

    public String filterGreaterThanPosition(Position position){
        String result = "";
        Collections.sort(workers);
        List<Worker> test = workers.stream()
                .filter(x -> x.getPosition().compareTo(position) > 0)
                .collect(Collectors.toList());
        for (Worker element : test) {
            result += elementToString(element) + " ";
        }
        return result;
    }

    public void update(Long id, Worker w) {
        List<Worker> test = getWorkerStream()
                .filter(x -> !x.getId().equals(id))
                .collect(Collectors.toList());
        test.add(w);
        Collections.sort(test);
        setaList((ArrayList<Worker>) test);
    }

    private void setaList(ArrayList<Worker> aList){
        this.workers = aList;
    }

    public Stream<Worker> getWorkerStream(){
        Collections.sort(workers);
        return workers.stream();
    }

    public void dump() throws IOException {
        FileOutputStream fos = new FileOutputStream("collection.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.setPersistenceDelegate(LocalDate.class,
                new PersistenceDelegate() {
                    @Override
                    protected Expression instantiate(Object localDate, Encoder encdr) {
                        return new Expression(localDate,
                                LocalDate.class,
                                "parse",
                                new Object[]{localDate.toString()});
                    }
                });
        encoder.writeObject(this.workers);
        encoder.close();
        fos.close();
    }

    public void load() throws IOException {
        FileInputStream fis = new FileInputStream("collection.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        decoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        workers = (ArrayList<Worker>) decoder.readObject();
        decoder.close();
        fis.close();

    }


}
