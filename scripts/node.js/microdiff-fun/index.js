// If you are using CommonJS, you can import it like this:
const diff = require("microdiff").default;

const obj1 = {
	originalProperty: true,
};
const obj2 = {
	originalProperty: true,
	newProperty: "new",
};

console.log(diff(obj1, obj2));
console.log(diff(obj2, obj1));
console.log(diff(obj2, obj2));