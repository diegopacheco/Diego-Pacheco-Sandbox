path = require('path')

const config = {
  entry: './src/index.js',
  output: {
     filename: 'bundle.js',
     path: path.resolve()
  }
}

module.exports = config;
