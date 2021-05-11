package pl.zimny.arkadiusz;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FunctionalClass {

    public static List<SensorData> handleTimeSeries(List<SensorData> dataList) {
        List<SensorData> newDataList = new ArrayList<>();

        while (dataList.size() > 1) {
            try {
                SensorData streamValue = dataList.stream().filter(a -> a.getInputValue() == 1).findFirst().get();
                newDataList.add(streamValue);
                dataList.removeIf(x -> streamValue.getTimeStamp() >= x.getTimeStamp());
                SensorData streamValueSecond = dataList.stream().filter(i -> i.getInputValue() == 0).findFirst().get();
                newDataList.add(streamValueSecond);
                dataList.removeIf(x -> streamValueSecond.getTimeStamp() >= x.getTimeStamp());
            } catch (NoSuchElementException e) {
                System.out.println("End of reading");
                break;
            } finally {
                if (newDataList.size() % 2 == 1) newDataList.remove(newDataList.size() - 1);
            }
        }

        return newDataList;
    }
}
