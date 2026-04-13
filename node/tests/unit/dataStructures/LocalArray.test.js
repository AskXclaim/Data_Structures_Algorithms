"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const globals_1 = require("@jest/globals");
const LocalArray_js_1 = __importDefault(require("../../../src/dataStructures/LocalArray.js"));
let localArray = new LocalArray_js_1.default();
(0, globals_1.describe)("LocalArray", () => {
    (0, globals_1.beforeEach)(() => {
        localArray = new LocalArray_js_1.default();
    });
    (0, globals_1.it)("Should add an item to LocalArray", () => {
        (0, globals_1.expect)(() => localArray.insert(1)).not.toThrow();
        (0, globals_1.expect)(() => localArray.insert(2)).not.toThrow();
    });
    (0, globals_1.it)("Should throw an error when removeAt is called with an invalid index", () => {
        (0, globals_1.expect)(() => localArray.removeAt(1)).toThrow();
        localArray.insert(1);
        localArray.insert(2);
        (0, globals_1.expect)(() => localArray.removeAt(2)).toThrow();
    });
    (0, globals_1.it)("Should not throw an error when removeAt is called with a valid index", () => {
        localArray.insert(1);
        localArray.insert(2);
        (0, globals_1.expect)(() => localArray.removeAt(1)).not.toThrow();
        (0, globals_1.expect)(() => localArray.removeAt(0)).not.toThrow();
    });
    (0, globals_1.it)("Should return the correct index when indexOf is called with a valid value", () => {
        localArray.insert(1);
        localArray.insert(2);
        let index = localArray.indexOf(1);
        (0, globals_1.expect)(index).toBe(0);
        index = localArray.indexOf(2);
        (0, globals_1.expect)(index).toBe(1);
    });
    (0, globals_1.it)("Should return the correct index [-1] when indexOf is called with an invalid value", () => {
        localArray.insert(1);
        localArray.insert(2);
        let index = localArray.indexOf(0);
        (0, globals_1.expect)(index).toBe(-1);
        index = localArray.indexOf(3);
        (0, globals_1.expect)(index).toBe(-1);
    });
    (0, globals_1.it)("should print current value of array", () => {
        let result = localArray.print();
        (0, globals_1.expect)(result).toMatch("[]");
        localArray.insert(1);
        localArray.insert(2);
        result = localArray.print();
        (0, globals_1.expect)(result).toMatch("[1,2]");
    });
});
