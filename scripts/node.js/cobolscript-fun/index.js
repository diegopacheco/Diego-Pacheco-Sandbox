var cobolscript = require('cobolscript');
var program = cobolscript.compileProgram('display "Hello, world from CobolScript!".');
program.run(cobolscript.getRuntime());
