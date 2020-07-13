import { Expect, Test, TestFixture } from "alsatian";

@TestFixture("Awesome Test Fixture")
export class ExampleTestFixture {

  @Test("Confirm 1 + 1 is 2")
  public test1() {
    Expect(1 + 1).toBe(2);
  }
}
