package com.streamflow;

import com.streamflow.commons.Constants;
import com.streamflow.model.SalesInfo;
import com.streamflow.service.ReadWithBufferedReader;

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
        List<SalesInfo> salesInfoList = readWithBufferedReader.readData(Constants.DATA_PATH);
        System.out.println(salesInfoList.size());
    }
}
