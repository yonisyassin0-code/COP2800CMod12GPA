// DataWrapper.java
// Yonis yassin
// 4/12/26
// Generic data wrapper utility class

package edu.fscj.cop2800c.util;

import java.util.List;

public class DataWrapper<T> {

    private T value;

    // Default constructor
    public DataWrapper() {
        this.value = null;
    }

    // Overloaded constructor
    public DataWrapper(T value) {
        this.value = value;
    }

    // Getter
    public T getValue() {
        return value;
    }

    // Static generic display method
    public static <T> void displayList(List<DataWrapper<T>> list) {
        for (DataWrapper<T> element : list) {
            System.out.println(element.getValue());
        }
    }
}