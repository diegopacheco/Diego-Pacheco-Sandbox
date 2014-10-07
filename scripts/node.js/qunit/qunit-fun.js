QUnit.test("first qunit basics", function( assert ) {
	var now = "2008/01/28 22:25:00";
	assert.equal(1 == 1, true);
	assert.equal(3 == 3, true);

	var text = "nodejs";
	assert.equal(text == "js", "nodejs","Fail to get text from js test sample");
});
