'use strict';
var fs = require('mz/fs');

module.exports = function checkdir(dir, options) {
  function isDirEmpty(files) {
    var filteredFiles;
    var noOfFiles;
    var empty;
    if (options && options.ignoreDotFiles) {
      filteredFiles = files.filter(function (file) {
        return file.indexOf('.') !== 0;
      });
    }
    noOfFiles = filteredFiles ? filteredFiles.length : files.length;
    empty = noOfFiles === 0;

    return {
      empty: empty,
      exists: true,
      files: noOfFiles
    };
  }

  function dirDoesNotExist(err) {
    if (err.code !== 'ENOENT') throw err;

    return {
      empty: true,
      exists: false,
      files: 0
    };
  }

  return fs.readdir(dir).then(isDirEmpty).catch(dirDoesNotExist);
};
