package com.streamflow;

import com.streamflow.model.SalesInfo;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReadWithBufferedReader readWithBufferedReader = new ReadWithBufferedReader();
        List<SalesInfo> salesInfoList = readWithBufferedReader.readData("src/main/resources/sales_data.csv");
        System.out.println(salesInfoList.size());
    }
}
