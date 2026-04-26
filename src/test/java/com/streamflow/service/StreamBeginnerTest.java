package com.streamflow.service;

import com.streamflow.commons.Constants;
import com.streamflow.model.SalesInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamBeginnerTest {
    private List<SalesInfo> salesInfoList;
    private StreamBeginner streamBeginner;

    @BeforeEach
    public void loadData() {
        salesInfoList = new ReadWithBufferedReader().readData(Constants.DATA_PATH);
        streamBeginner = new StreamBeginner();
    }

    @Test
    public void countTest() {
        assertEquals(streamBeginner.getSalesCount(), 10000L);
    }

    @Test
    public void countAmountGreaterThan500() {
        assertEquals(streamBeginner.salesGreaterThan500(), 9072);
    }

    @Test
    public void extractProductName() {
        List<String> products = new ArrayList<>();
        for(SalesInfo s: salesInfoList) {
            products.add(s.getProduct());
        }
        List<String> strings = streamBeginner.extractProductNames();
        assertEquals(strings, products);
    }

    @Test
    public void extractElectronicsCustomerIds() {
        List<String> electronicsCustomerId = new ArrayList<>();
        for (SalesInfo s: salesInfoList) {
            if (s.getCategory().equalsIgnoreCase("Electronics")) {
                electronicsCustomerId.add(s.getCustomerId());
            }
        }
        List<String> strings = streamBeginner.extractElectronicsCustomerIds();
        assertEquals(strings, electronicsCustomerId);
    }

    @Test
    public void first5ElectronicsCustomerIdsWithHigherAmount() {
        List<SalesInfo> electronicsCustomer = new ArrayList<>();
        for (SalesInfo s: salesInfoList) {
            if (s.getCategory().equalsIgnoreCase("Electronics")) {
                electronicsCustomer.add(s);
            }
        }
        electronicsCustomer.sort((a, b) -> Double.compare(b.getAmount(), a.getAmount()));
        List<String> top5ElectronicsCustId = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            top5ElectronicsCustId.add(electronicsCustomer.get(i).getCustomerId());
        }
        List<String> customerIds = streamBeginner.first5ElectronicsCustomerIdsWithHigherAmount();
        assertEquals(customerIds, top5ElectronicsCustId);
    }

    @Test
    public void getTop10Sales() {
        List<SalesInfo> top10Sales = new ArrayList<>();
        salesInfoList.sort((a, b) -> Double.compare(b.getAmount(), a.getAmount()));
        for (int i = 0; i < 10; i++) {
            top10Sales.add(salesInfoList.get(i));
        }
        List<SalesInfo> top10Sales1 = streamBeginner.getTop10Sales();
        assertEquals(top10Sales1, top10Sales);

    }

    @Test
    public void getRandom2Category() {
        List<String> random2Category = new ArrayList<>();
        int count = 0;
        for (SalesInfo s: salesInfoList) {
            if (!random2Category.contains(s)) {
                random2Category.add(s.getCategory());
                count++;
            }
            if(count >= 2) break;
        }
        List<String> random2Category1 = streamBeginner.getRandom2Category();
        assertEquals(random2Category1, random2Category);
    }

    @Test
    public void exploreCreatingStreams() {
        streamBeginner.exploreCreatingStreams();
    }
}
