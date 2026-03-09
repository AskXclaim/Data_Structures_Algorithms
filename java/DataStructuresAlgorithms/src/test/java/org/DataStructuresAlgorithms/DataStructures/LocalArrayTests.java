package org.DataStructuresAlgorithms.DataStructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LocalArrayTests {
    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    public void whenClassIsInstantiated_WIthSizeZeroOrLess_ThrowAnException(int size) {
        assertThrows(IllegalArgumentException.class, () -> new LocalArray(size));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void whenClassIsInstantiated_WIthSizeOneOrGreater_DoesNotThrowAnException(int size) {
        assertDoesNotThrow(() -> new LocalArray(size));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2})
    public void whenInsertIsCalled_WIthValidValue_ShouldAddValueToArray(int value) {
        var array = new LocalArray(1);
        assertDoesNotThrow(() -> array.insert(value));
    }

    @Test
    public void whenInsertIsCalledMultipleTimes_WIthValidValues_ShouldAddValueToArray() {
        var array = new LocalArray(1);
        array.insert(1);
        assertDoesNotThrow(() -> array.insert(2));
        assertDoesNotThrow(() -> array.insert(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 1})
    public void whenRemoveAtIsCalled_WithInvalidIndex_ShouldThrowAnException(int value) {
        var array = new LocalArray(1);
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(value));
    }

    @Test
    public void whenRemoveAtIsCalled_WithInvalidIndexAfterMultipleSizeIncrease_ShouldThrowAnException() {
        var array = new LocalArray(1);
        array.insert(1);
        array.insert(2);
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void whenRemoveAtIsCalled_WithValidIndex_ShouldNotThrowAnException(int index) {
        var array = new LocalArray(3);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        assertDoesNotThrow(() -> array.removeAt(index));
    }

    @ParameterizedTest(name = "index: {0}, value: {1}")
    @CsvSource({"0,10", "1,11", "2,12"})
    public void whenIndexOfIsCalled_WithValidIndex_ShouldReturnCorrectIndex(int index, int value) {
        var array = new LocalArray(3);
        array.insert(10);
        array.insert(11);
        array.insert(12);
        var theIndex = array.indexOf(value);
        assertEquals(index, theIndex);
    }

    @Test
    public void whenIndexOfIsCalled_WithInvalidIndex_ShouldReturnMinusOne() {
        var array = new LocalArray(1);
        array.insert(10);
        var theIndex = array.indexOf(11);
        assertEquals(-1, theIndex);
    }

    @Test
    @DisplayName("Print() works as expected when called with no values present")
    public void whenPrintIsCalled_WithNoValuesAdd_ShouldReturnAnEmptyPrintedArray() {
        var array = new LocalArray(1);
        var result = array.print();
        assertEquals("[]", result);
    }

    @Test
    @DisplayName("Print() works as expected when called with values present")
    public void whenPrintIsCalled_WithValuesAdd_ShouldReturnPrintedArray() {
        var array = new LocalArray(1);
        array.insert(1);
        array.insert(2);
        var result = array.print();
        assertEquals("[1, 2]", result);
    }
}
