package com.streamflow.service;

import com.streamflow.commons.Constants;
import com.streamflow.model.SalesInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadWithBufferedReaderTest {

    @Test
    public void readData() {
        ReadWithBufferedReader reader = new ReadWithBufferedReader();
        List<SalesInfo> salesInfos = reader.readData(Constants.DATA_PATH);
        assertEquals(salesInfos.size(), 10000);
    }
}
