package org.dataStructuresAlgorithms.dataStructures;

import org.dataStructuresAlgorithms.dataStructures.interfaces.CustomArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MyLocalArrayTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void MyLocalArray_WhenInitializedWithValidValues_ShouldNotThrowException(int size) {
        assertDoesNotThrow(() -> new MyLocalArray<>(Integer.class, size));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    public void MyLocalArray_WhenInitializedWithInvalidValues_ShouldThrowException(int size) {
        assertThrows(IllegalArgumentException.class, () -> new MyLocalArray<>(Integer.class, size));
    }

    @Test
    public void insert_WhenCalledWithValidItem_ShouldAddSingleItemSuccessfully() {
        var array = new MyLocalArray<>(Integer.class, 1);
        array.insert(1);
        assertEquals(1, array.itemLength());
    }

    @Test
    public void insert_WhenCalledWithMoreItemsThanSize_ShouldAddItemsSuccessfully() {
        var array = new MyLocalArray<>(Integer.class, 1);
        array.insert(1);
        array.insert(2);
        assertEquals(2, array.itemLength());
    }

    @Test
    public void insert_WhenCalledWithNull_ShouldNotBeAddedSuccessfully() {
        var array = new MyLocalArray<>(Integer.class, 1);
        array.insert(null);
        assertEquals(0, array.itemLength());
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "1,0", "2,1", "1,-1"})
    public void removeAt_WhenCalledWithInvalidIndex_ShouldThrowException(int size, int index) {
        var array = new MyLocalArray<>(Integer.class, size);
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(index));
    }

    @ParameterizedTest
    @CsvSource({"1,0,0", "2,1,1", "2,0,1"})
    public void removeAt_WhenCalledWithValidIndex_ShouldRemoveItemAtSpecifiedIndex(int size, int index, int expectedResult) {
        var array = new MyLocalArray<>(Integer.class, size);
        for (int i = 0; i < size; i++) array.insert(i + 1);

        assertDoesNotThrow(() -> array.removeAt(index));
        assertEquals(expectedResult, array.itemLength());
    }

    @ParameterizedTest
    @CsvSource({"1,1,0", "2,1,0", "2,2,1", "1,0,-1", "2,3,-1"})
    public void indexOf_WhenCalled_ShouldReturnExpectedIndex(int size, int item, int expectedResult) {
        var array = new MyLocalArray<>(Integer.class, size);
        for (int i = 0; i < size; i++) array.insert(i + 1);

        var result = array.indexOf(item);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,false,null", "2,false,null", "1,true,1", "2,true,2"}, nullValues = "null")
    public void max_WhenCalled_ShouldReturnExpectedValue(int size, boolean shouldAddItem, Integer expectedResult) {
        var array = new MyLocalArray<>(Integer.class, size);
        if (shouldAddItem) {
            for (int i = 0; i < size; i++) array.insert(i + 1);
        }

        var result = array.max();

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("intersectArrayProvider")
    public void intersect_WhenCalled_ShouldReturnExpectedValue(CustomArray<Integer> myLocalArray, Integer[] arrayToCompare, Integer[] expectedResult) {
        var result = myLocalArray.intersect(arrayToCompare);

        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> intersectArrayProvider() {
        var array = new MyLocalArray<>(Integer.class, 3);
        array.insert(1);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        return Stream.of(
                Arguments.of(array, new Integer[0], new Integer[0]),
                Arguments.of(array, new Integer[]{4, 5}, new Integer[0]),
                Arguments.of(array, new Integer[]{1, 4}, new Integer[]{1}),
                Arguments.of(array, new Integer[]{1, 4,4}, new Integer[]{1}),
                Arguments.of(array, new Integer[]{1, 2}, new Integer[]{1, 2}),
                Arguments.of(array, new Integer[]{1,1, 2}, new Integer[]{1, 2}),
                Arguments.of(array, new Integer[]{2, 3}, new Integer[]{2, 3})
        );
    }

}
