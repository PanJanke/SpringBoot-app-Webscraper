package com.example.demo.apartment;

import com.example.demo.Utils.CsvUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class ApartmentService {


    public void setApartments(List<Apartment> apartments) {
        this.apartments = new ArrayList<>(apartments);
    }

    private List<Apartment> apartments = new ArrayList<>();

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void deleteById(int id) {
        Predicate<? super Apartment> predicate = apartment -> apartment.getId() == id;
        apartments.removeIf(predicate);
    }

    public Apartment getById(int id) {
        Optional<Apartment> apartment = apartments.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return apartment.orElse(null);
    }

    @PostConstruct
    private void init() throws InterruptedException {
        apartments = CsvUtils.readListFromCsv("apartments.csv");
    }




}
