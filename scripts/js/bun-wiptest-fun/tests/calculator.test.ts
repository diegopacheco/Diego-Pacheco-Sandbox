import { SimpleCalculator } from "../src/calculator"
import { it, expect } from "bun:test";

it("Should test the Simple Calculator Impl properly", () => {
    let result = new SimpleCalculator().sum(2,2);
    expect(4).toBe(result);
})