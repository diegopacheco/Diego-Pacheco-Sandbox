#!/user/bin/env node

module.exports = logoGenerator;

function logoGenerator(string, color, options) {
    'use strict';
    var figlet = require('figlet'),
        colors = require('colors/safe'),
        asciiArt;

    if (!options) { options = {}; }

    try {
        asciiArt = figlet.textSync(string || '', options);
        console.log(colors[color || 'rainbow'](asciiArt));
    } catch (err) {
        console.log( colors['red']('turbo-logo ' + err) );

    }
}
