package com.streamflow.service;

import com.streamflow.commons.Constants;
import com.streamflow.model.SalesInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

    public List<String> first5ElectronicsCustomerIdsWithHigherAmount() {
        return salesInfoList.stream()
                .filter(salesInfo -> salesInfo.getCategory().equalsIgnoreCase("Electronics"))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .limit(5)
                .map(SalesInfo::getCustomerId)
                .toList();
    }

    public List<SalesInfo> getTop10Sales() {
        return salesInfoList.stream()
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .limit(10)
                .toList();
    }

    public List<String> getRandom2Category() {
        return salesInfoList.stream()
                .map(SalesInfo::getCategory)
                .limit(2)
                .distinct().toList();

    }

    public void exploreCreatingStreams() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Set<Integer> integers1 = Set.of(1, 3, 5, 7, 9);
        int[] values = {10, 11, 12, 13, 14};

        integers.stream().forEach(System.out::println);
        integers1.stream().forEach(System.out::println);
        Arrays.stream(values).forEach(System.out::println);
    }
}
