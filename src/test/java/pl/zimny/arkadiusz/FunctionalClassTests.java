package pl.zimny.arkadiusz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import static pl.zimny.arkadiusz.FunctionalClass.handleTimeSeries;

public class FunctionalClassTests {

    List<SensorData> sensorDataArrayList = new ArrayList<>();
    List<SensorData> returnStreamData = new ArrayList<>();

    @BeforeEach
    public void prepareData() {
        sensorDataArrayList.add(new SensorData(1615560000, 1));
        sensorDataArrayList.add(new SensorData(1615560005, 1));
        sensorDataArrayList.add(new SensorData(1615560013, 1));
        sensorDataArrayList.add(new SensorData(1615560018, 1));
        sensorDataArrayList.add(new SensorData(1615560024, 0));
        sensorDataArrayList.add(new SensorData(1615560030, 1));
        sensorDataArrayList.add(new SensorData(1615560037, 0));
        sensorDataArrayList.add(new SensorData(1615560042, 0));

        returnStreamData.add(new SensorData(1615560000, 1));
        returnStreamData.add(new SensorData(1615560024, 0));
        returnStreamData.add(new SensorData(1615560030, 1));
        returnStreamData.add(new SensorData(1615560037, 0));
    }

    @Test
    public void should_get_properly_size() {
        //when
        List<SensorData> actualListData = handleTimeSeries(sensorDataArrayList);
        //then
        assertTrue(actualListData.size() == returnStreamData.size());
    }

    @Test
    public void should_get_properly_first_item(){
        //when
        List<SensorData> actualListData = handleTimeSeries(sensorDataArrayList);
        //then
        assertTrue(returnStreamData.get(0).equals(actualListData.get(0)));
    }

    @Test
    public void should_get_properly_list() {
        //when
        List<SensorData> actualListData = handleTimeSeries(sensorDataArrayList);
        //then
        assertTrue(returnStreamData.equals(actualListData) && actualListData.equals(returnStreamData));
    }

    @Test
    public void should_include_same_content() {
        //when
        List<SensorData> actualListData = handleTimeSeries(sensorDataArrayList);
        //then
        assertTrue(returnStreamData.containsAll(actualListData) && actualListData.containsAll(returnStreamData));
    }

}
