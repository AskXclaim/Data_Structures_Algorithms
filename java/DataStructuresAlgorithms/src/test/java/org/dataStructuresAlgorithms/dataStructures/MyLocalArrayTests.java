package org.dataStructuresAlgorithms.dataStructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        assertEquals(1, array.itemLength());
    }

    @Test
    public void insert_WhenCalledWithMoreItemsThanSize_ShouldAddItemsSuccessfully() {
        var array = new MyLocalArray<Integer>(Integer.class, 1);
        array.insert(1);
        array.insert(2);
        assertEquals(2, array.itemLength());
    }

    @Test
    public void insert_WhenCalledWithNull_ShouldNotBeAddedSuccessfully() {
        var array = new MyLocalArray<Integer>(Integer.class, 1);
        array.insert(null);
        assertEquals(0, array.itemLength());
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "1,0", "2,1"})
    public void removeAt_WhenCalledWithInvalidIndex_ShouldThrowException(int size, int index) {
        var array = new MyLocalArray<>(Integer.class, size);
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(index));
    }
}
