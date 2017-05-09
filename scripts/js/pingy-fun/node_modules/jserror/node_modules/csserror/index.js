var createCssStringLiteral = require('./lib/createCssStringLiteral');

function createCssError(str, doubleEscape) {
  var tpl = 'body * {\n  display: none !important;\n}\n\nbody:before {\n  line-height: 1.5;\n  display: block;\n  z-index: 99999999;\n  white-space: pre;\n  font-family: "Courier New", monospace;\n  font-size: 20px;\n  color: black;\n  margin: 10px;\n  padding: 10px;\n  border: 4px dashed red;\n  margin-bottom: 10px;\n  content: __ERRORMESSAGE__;\n}\n';

  return tpl.replace('__ERRORMESSAGE__', createCssStringLiteral(str, doubleEscape));
}

module.exports = createCssError;
