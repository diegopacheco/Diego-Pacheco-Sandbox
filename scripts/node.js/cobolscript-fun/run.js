var cobolscript = require('cobolscript');
fs = require('fs');

function runFile(filename) {
    cobolscript.compileProgramFile(filename).run(cobolscript.getRuntime());
};
process.argv.forEach(function (val) {
    if (val.slice(-4) == ".cob") runFile(val);
});