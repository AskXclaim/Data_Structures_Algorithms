"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const LocalArray_js_1 = __importDefault(require("./dataStructures/LocalArray.js"));
const localArray = new LocalArray_js_1.default();
localArray.insert(10);
localArray.insert(15.5);
localArray.insert(20);
console.log(localArray.print());
console.log(localArray.indexOf(15.5));
console.log(localArray.indexOf(30));
localArray.removeAt(1);
console.log(localArray.print());
