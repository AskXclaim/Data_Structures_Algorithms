"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class LocalArray {
    constructor() {
        this._items = [];
    }
    insert(item) {
        this._items.push(item);
    }
    removeAt(index) {
        var _a;
        if (!this.isIndexValid(index))
            throw new Error("Index is out of bounds");
        (_a = this._items) === null || _a === void 0 ? void 0 : _a.splice(Math.abs(index), 1);
    }
    isIndexValid(index) {
        var _a;
        return !(index < 0 || Math.abs(index) >= ((_a = this._items) === null || _a === void 0 ? void 0 : _a.length));
    }
    indexOf(value) {
        return this._items.indexOf(value);
    }
    print() {
        var _a;
        let result = "[";
        if (((_a = this._items) === null || _a === void 0 ? void 0 : _a.length) > 0) {
            for (const item in this._items) {
                result += `${this._items[item]},`;
            }
            result = result.substring(0, result.length - 1);
        }
        result += "]";
        return result;
    }
}
exports.default = LocalArray;
