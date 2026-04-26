package com.streamflow.service;

import com.streamflow.commons.Constants;
import com.streamflow.model.SalesInfo;

import java.util.List;

public class StreamBeginner {

    private List<SalesInfo> salesInfoList;

    public StreamBeginner() {
        this.salesInfoList = new ReadWithBufferedReader().readData(Constants.DATA_PATH);
    }

    public long getSalesCount() {
        return salesInfoList.stream().count();
    }

    public long salesGreaterThan500() {
        return salesInfoList.stream()
                .filter(salesInfo -> salesInfo.getAmount() > 500)
                .count();
    }

    public List<String> extractProductNames() {
        return salesInfoList.stream()
                .map(SalesInfo::getProduct)
                .toList();
    }

    public List<String> extractElectronicsCustomerIds() {
        return salesInfoList.stream()
                .filter(salesInfo -> salesInfo.getCategory().equalsIgnoreCase("Electronics"))
                .map(SalesInfo::getCustomerId)
                .toList();
    }
}
