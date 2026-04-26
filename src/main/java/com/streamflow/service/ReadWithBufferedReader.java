package com.streamflow.service;

import com.streamflow.enums.Status;
import com.streamflow.model.SalesInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadWithBufferedReader {

    public List<SalesInfo> readData(String filePath) {
        List<SalesInfo> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] values = line.split(",");
                list.add(getSalesInfo(values));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private SalesInfo getSalesInfo(String[] values) {
        SalesInfo salesInfo = new SalesInfo();
        salesInfo.setSalesId(Integer.parseInt(values[0]));
        salesInfo.setCustomerId(values[1]);
        salesInfo.setCustomerName(values[2]);
        salesInfo.setCategory(values[3]);
        salesInfo.setProduct(values[4]);
        salesInfo.setQuantity(Integer.parseInt(values[5]));
        salesInfo.setUnitPrice(Double.parseDouble(values[6]));
        salesInfo.setAmount(Double.parseDouble(values[7]));
        String[] split = values[8].split("-");
        salesInfo.setSaleDate(LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        salesInfo.setRegion(values[9]);
        salesInfo.setStatus(Status.valueOf(values[10]));
        return salesInfo;
    }
}
