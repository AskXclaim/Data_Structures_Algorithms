package org.dataStructuresAlgorithms.dataStructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MyLocalArrayTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void MyLocalArray_WhenInitializedWithValidValues_ShouldNotThrowException(int size) {
        assertDoesNotThrow(() -> new MyLocalArray<Integer>(Integer.class, size));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    public void MyLocalArray_WhenInitializedWithInvalidValues_ShouldThrowException(int size) {
        assertThrows(IllegalArgumentException.class, () -> new MyLocalArray<Integer>(Integer.class, size));
    }

    @Test
    public void insert_WhenCalledWithValidItem_ShouldAddSingleItemSuccessfully() {
        var array = new MyLocalArray<Integer>(Integer.class, 1);
        array.insert(1);
        assertEquals(1, array.length());
    }

    @Test
    public void insert_WhenCalledWithMoreItemsThanSize_ShouldAddItemsSuccessfully() {
        var array = new MyLocalArray<Integer>(Integer.class, 1);
        array.insert(1);
        array.insert(2);
        assertEquals(2, array.length());
    }
}
