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
        assertEquals(products, strings);
    }
}
