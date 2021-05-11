package pl.zimny.arkadiusz;

import java.util.Objects;

public class SensorData {

    private long timeStamp;
    private int inputValue;

    public SensorData(long timeStamp, int inputValue) {
        this.timeStamp = timeStamp;
        this.inputValue = inputValue;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getInputValue() {
        return inputValue;
    }

    @Override
    public String toString() {
        return ""+timeStamp+": "+inputValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorData that = (SensorData) o;
        return timeStamp == that.timeStamp && inputValue == that.inputValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, inputValue);
    }
}
