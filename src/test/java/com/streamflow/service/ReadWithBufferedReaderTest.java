package com.streamflow.service;

import com.streamflow.model.SalesInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadWithBufferedReaderTest {

    @Test
    public void readData() {
        ReadWithBufferedReader reader = new ReadWithBufferedReader();
        List<SalesInfo> salesInfos = reader.readData("src/main/resources/sales_data.csv");
        assertEquals(salesInfos.size(), 10000);
    }
}
