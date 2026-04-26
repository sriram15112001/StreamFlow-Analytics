package com.streamflow.service;

import com.streamflow.commons.Constants;
import com.streamflow.model.SalesInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
