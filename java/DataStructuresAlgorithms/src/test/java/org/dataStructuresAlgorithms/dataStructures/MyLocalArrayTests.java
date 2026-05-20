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
import static org.assertj.core.api.Assertions.assertThat;

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
    @MethodSource("maxProvider")
    public void max_WhenCalled_ShouldReturnExpectedValue(CustomArray<Integer> array, Integer expectedResult) {
        var result = array.max();

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("intersectArrayProvider")
    public void intersect_WhenCalled_ShouldReturnExpectedValue(CustomArray<Integer> myLocalArray, Integer[] arrayToCompare, Integer[] expectedResult) {
        var result = myLocalArray.intersect(arrayToCompare);

        assertArrayEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("reverseArrayProvider")
    public void reverse_WhenCalled_ShouldHaveItemsReversed(CustomArray<Integer> integerCustomArray, Integer[] expectedResult) {
        integerCustomArray.reverse();

        assertArrayEquals(expectedResult, integerCustomArray.items());
    }

    @ParameterizedTest
    @MethodSource("reverseArrayProvider")
    public void reverseTo_WhenCalled_ShouldReturnAnArrayOfItemsReversed(CustomArray<Integer> integerCustomArray, Integer[] expectedResult) {
        var result = integerCustomArray.reverseTo();

        assertArrayEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"null,-1", "null,0"}, nullValues = "null")
    public void insertAt_WhenCalledWithNull_ShouldThrowIllegalArgumentException(Integer value, int index) {
        var array = getIntegerMyLocalArray(2, false);

        assertThrowsExactly(IllegalArgumentException.class, () -> array.insertAt(value, index));
    }

    @ParameterizedTest
    @CsvSource(value = {"' ',0", "'',1"})
    public void insertAt_WhenCalledWithWhiteSpace_ShouldThrowIllegalArgumentException(String value, int index) {
        var array = new MyLocalArray<>(String.class, 2);

        assertThrowsExactly(IllegalArgumentException.class, () -> array.insertAt(value, index));
    }

    @Test
    public void insertAt_WhenCalledWithNullValue_ShouldThrowIllegalArgumentException() {
        var array = new MyLocalArray<>(String.class, 2);

        assertThrowsExactly(IllegalArgumentException.class, () -> array.insertAt(null, 1));
    }

    @ParameterizedTest
    @MethodSource("invalidInsertAtProvider")
    public void insertAt_WhenCalledWithInvalidIndex_ShouldThrowIndexOutOfBoundsException(CustomArray<Integer> array, int value, int index) {
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> array.insertAt(value, index));
    }

    @ParameterizedTest
    @MethodSource("insertAtProvider")
    public void insertAt_WhenCalled_ShouldCorrectlyInsertValue(CustomArray<Integer> array, int value, int index, int expectedLength) {
        assertDoesNotThrow(() -> array.insertAt(value, index));
        assertThat(array.itemLength()).isEqualTo(expectedLength);
        assertThat(array.items()[index]).isEqualTo(value);
    }
    @ParameterizedTest
    @MethodSource("insertAtProviderUsingString")
    public void insertAt_WhenCalledUsingString_ShouldCorrectlyInsertValue(CustomArray<String> array, String value, int index, int expectedLength) {
        assertDoesNotThrow(() -> array.insertAt(value, index));
        assertThat(array.itemLength()).isEqualTo(expectedLength);
        assertThat(array.items()[index]).isEqualTo(value);
    }


    private static Stream<Arguments> maxProvider() {
        var array = getIntegerMyLocalArray(2, false);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        return Stream.of(Arguments.of(new MyLocalArray<>(Integer.class, 1), null),
                Arguments.of(new MyLocalArray<>(Integer.class, 2), null),
                Arguments.of(getIntegerMyLocalArray(1, false), 1),
                Arguments.of(getIntegerMyLocalArray(2, false), 2),
                Arguments.of(array, 3));
    }

    private static Stream<Arguments> intersectArrayProvider() {
        var array = getIntegerMyLocalArray(3, true);
        return Stream.of(
                Arguments.of(array, new Integer[0], new Integer[0]),
                Arguments.of(array, new Integer[]{4, 5}, new Integer[0]),
                Arguments.of(array, new Integer[]{1, 4}, new Integer[]{1}),
                Arguments.of(array, new Integer[]{1, 4, 4}, new Integer[]{1}),
                Arguments.of(array, new Integer[]{1, 2}, new Integer[]{1, 2}),
                Arguments.of(array, new Integer[]{1, 1, 2}, new Integer[]{1, 2}),
                Arguments.of(array, new Integer[]{2, 3}, new Integer[]{2, 3})
        );
    }

    private static Stream<Arguments> reverseArrayProvider() {
        return Stream.of(
                Arguments.of(new MyLocalArray<>(Integer.class, 1), new Integer[0]),
                Arguments.of(getIntegerMyLocalArray(1, false), new Integer[]{1}),
                Arguments.of(getIntegerMyLocalArray(3, false), new Integer[]{3, 2, 1}),
                Arguments.of(getIntegerMyLocalArray(3, true), new Integer[]{3, 2, 1, 1})
        );
    }

    private static Stream<Arguments> invalidInsertAtProvider() {
        return Stream.of(Arguments.of(getIntegerMyLocalArray(1, false), 1, -2),
                Arguments.of(getIntegerMyLocalArray(1, false), 1, -1),
                Arguments.of(new MyLocalArray<>(Integer.class, 1), 1, 0),
                Arguments.of(getIntegerMyLocalArray(1, false), 11, 1),
                Arguments.of(getIntegerMyLocalArray(2, false), 11, 2));
    }

    private static Stream<Arguments> insertAtProvider() {
        return Stream.of(
                Arguments.of(getIntegerMyLocalArray(1, false), 11, 0, 2),
                Arguments.of(getIntegerMyLocalArray(2, false), 12, 1, 3),
                Arguments.of(getIntegerMyLocalArray(3, false), 13, 1, 4));
    }


    private static Stream<Arguments> insertAtProviderUsingString() {
        var array = new MyLocalArray<>(String.class, 1);
        array.insert("1");
        var array2 = new MyLocalArray<>(String.class, 2);
        array2.insert("1");
        array2.insert("2");
        return Stream.of(
                Arguments.of(array, "11", 0, 2),
                Arguments.of(array2, "12", 1, 3));
    }
    private static MyLocalArray<Integer> getIntegerMyLocalArray(int size, boolean shouldDuplicate) {
        var array = new MyLocalArray<>(Integer.class, size);
        for (int i = 0; i < size; i++) {
            array.insert(i + 1);
            if (i == 0 && shouldDuplicate)
                array.insert(i + 1);
        }
        return array;
    }

}
