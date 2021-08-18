var java = require('java');
var javaLangSystem = java.import('java.lang.System');
  
javaLangSystem.out.printlnSync('I love java!');
var java_ver = javaLangSystem.getPropertySync("java.version");
console.log("Java Version === " + java_ver);
