package com.example.demo.Utils;

import com.example.demo.apartment.Apartment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static void writeListToCsv(List<Apartment> apartmentList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header row
            writer.write("webAddress,address,price,PricePerSqaureMeter,numOfRooms,squareMeters\n");

            // Write each apartment object to the file
            for (Apartment apartment : apartmentList) {
                writer.write(apartment.getWebAddress() + ";"
                        + apartment.getAddress() + ";"
                        + apartment.getPrice() + ";"
                        + apartment.getPricePerSquareMeter() + ";"
                        + apartment.getNumOfRooms() + ";"
                        + apartment.getSquareMeters() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Apartment> readListFromCsv(String filePath) {
        List<Apartment> apartmentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip the header row
            reader.readLine();

            // Read each apartment object from the file
            String line;
            int iterator=0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                String webAddress = values[0];
                String address = values[1];
                String price = values[2];
                String pricePerSqaureMeter = values[3];
                String numOfRooms = values[4];
                String squareMeters = values[5];
                Apartment apartment = new Apartment(++iterator,webAddress, address, price, pricePerSqaureMeter, numOfRooms, squareMeters);
                apartmentList.add(apartment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apartmentList;
    }
}
