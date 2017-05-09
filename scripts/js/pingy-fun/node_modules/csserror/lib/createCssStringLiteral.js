function createCssStringLiteral(str, doubleEscape) {
  return '"' + str.replace(/[\\\x00-\x1f\x21-\x2f]/g, function ($0) {
    return '\\' + (doubleEscape ? '\\' : '') + $0.charCodeAt(0).toString(16) + ' ';
  }) + '"';
}

module.exports = createCssStringLiteral;
