"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var LocalArray = /** @class */ (function () {
    function LocalArray() {
        this._items = [];
    }
    LocalArray.prototype.insert = function (item) {
        this._items.push(item);
    };
    LocalArray.prototype.removeAt = function (index) {
        var _a;
        if (!this.isIndexValid(index))
            throw new Error("Index is out of bounds");
        (_a = this._items) === null || _a === void 0 ? void 0 : _a.splice(Math.abs(index), 1);
    };
    LocalArray.prototype.isIndexValid = function (index) {
        var _a;
        return !(index < 0 || Math.abs(index) >= ((_a = this._items) === null || _a === void 0 ? void 0 : _a.length));
    };
    LocalArray.prototype.indexOf = function (value) {
        return this._items.indexOf(value);
    };
    LocalArray.prototype.print = function () {
        console.log(this._items);
    };
    return LocalArray;
}());
exports.default = LocalArray;
