class LocalArray {
    private _items: number[] = [];

    public insert(item: number): void {
        this._items.push(item);
    }

    public removeAt(index: number): void {
        if (!this.isIndexValid(index))
            throw new Error("Index is out of bounds");

        this._items?.splice(Math.abs(index), 1);
    }

    private isIndexValid(index: number): boolean {
        return !(index < 0 || Math.abs(index) >= this._items?.length);
    }

    public indexOf(value: number): number {
        return this._items.indexOf(value);
    }

    public print(): string {
        let result = "[";
        if (this._items?.length >0) {
            for (const item in this._items) {
                result += `${this._items[item]},`;
            }
            result = result.substring(0, result.length - 1);
        }
        result += "]";

        return result;
    }
}

export default LocalArray;