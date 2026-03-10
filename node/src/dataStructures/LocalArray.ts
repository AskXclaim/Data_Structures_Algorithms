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

    public print():void{
        console.log(this._items);
    }
}

export default LocalArray;