package com.schema;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class ReadCSV {

    //public String csvFileName = "data/payId_Location.csv";
    //public String csvFileName = "data/payId_Amount.csv";
    public String csvFileName = "data/payId_Amount_Location.csv";


    public List Paylist;
    public List ReadCSVFile()  {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFileName));

            CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                    .withType(Payment.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            //This method is not recommended for large CSV File
            Paylist = csvToBean.parse();

            csvReader.close();
        }catch(Exception FileNotFoundException){
            //e.printStackTrace();
            System.out.println("File is not available...");
        }


        return Paylist;
    }
}
