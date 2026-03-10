import LocalArray from "./dataStructures/LocalArray.js";

const localArray = new LocalArray();
localArray.insert(10);
localArray.insert(15.5);
localArray.insert(20);
localArray.print();
console.log( localArray.indexOf(15.5));
console.log(localArray.indexOf(30));
localArray.removeAt(1);
localArray.print();