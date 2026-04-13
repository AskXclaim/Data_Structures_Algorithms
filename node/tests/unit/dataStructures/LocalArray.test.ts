import {describe, it, expect, beforeEach} from "@jest/globals";
import LocalArray from "../../../src/dataStructures/LocalArray.js";

let localArray = new LocalArray();
describe("LocalArray", () => {

    beforeEach(() => {
        localArray = new LocalArray();
    });
    it("Should add an item to LocalArray", () => {
        expect(() => localArray.insert(1)).not.toThrow();
        expect(() => localArray.insert(2)).not.toThrow();
    });
    it("Should throw an error when removeAt is called with an invalid index", () => {
        expect(() => localArray.removeAt(1)).toThrow();
        localArray.insert(1);
        localArray.insert(2);
        expect(() => localArray.removeAt(2)).toThrow();
    });
    it("Should not throw an error when removeAt is called with a valid index", () => {
        localArray.insert(1);
        localArray.insert(2);
        expect(() => localArray.removeAt(1)).not.toThrow();
        expect(() => localArray.removeAt(0)).not.toThrow();
    });

    it("Should return the correct index when indexOf is called with a valid value", () => {
        localArray.insert(1);
        localArray.insert(2);
        let index = localArray.indexOf(1);
        expect(index).toBe(0);
        index = localArray.indexOf(2);
        expect(index).toBe(1);
    });

    it("Should return the correct index [-1] when indexOf is called with an invalid value", () => {
        localArray.insert(1);
        localArray.insert(2);
        let index = localArray.indexOf(0);
        expect(index).toBe(-1);
        index = localArray.indexOf(3);
        expect(index).toBe(-1);
    });

    it("should print current value of array", () => {
        let result = localArray.print();
        expect(result).toMatch("[]");
        localArray.insert(1);
        localArray.insert(2);
        result = localArray.print();
        expect(result).toMatch("[1,2]");
    });
})