'use strict';

var cssError = require('csserror');
var chalk = require('chalk');

module.exports = function getErrorScript(errorMessage) {
    var cleanErrorMessage = chalk.stripColor(errorMessage);

    return [
        '/**********************************************************',
        cleanErrorMessage.split('\n').map(function (str) {
            return ' * ' + str;
        }).join('\n'),
        ' *********************************************************/',
        ';(function () {',
        '  var str = "' + cssError(cleanErrorMessage, true).replace(/\n/g, '\\\n').replace(/"/g, '\\"') + '";',
        '  var el = document.createElement("style");',
        '  if (el.styleSheet) {',
        '    el.styleSheet.cssText = str;',
        '  } else {',
        '    el.appendChild(document.createTextNode(str));',
        '  }',
        '  var firstScript = document.getElementsByTagName("script")[0];',
        '  firstScript.parentNode.insertBefore(el, firstScript);',
        '}());',
        ''
    ].join('\n');
};
