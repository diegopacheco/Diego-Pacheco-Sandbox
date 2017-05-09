var createCssStringLiteral = require('./lib/createCssStringLiteral');

function createCssError(str, doubleEscape) {
  var tpl = [
    'body * {',
    '  display: none !important;',
    '}',
    'body:before {',
    '  line-height: 1.5;',
    '  display: block;',
    '  z-index: 99999999;',
    '  white-space: pre;',
    '  font-family: "Courier New", monospace;',
    '  font-size: 20px;',
    '  color: black;',
    '  background-color: white;',
    '  margin: 10px;',
    '  padding: 10px;',
    '  border: 4px dashed red;',
    '  margin-bottom: 10px;',
    '  content: __ERRORMESSAGE__;',
    '}'
  ].join('\n');

  return tpl.replace('__ERRORMESSAGE__', createCssStringLiteral(str, doubleEscape));
}

module.exports = createCssError;
