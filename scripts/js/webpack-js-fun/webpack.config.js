path = require('path')

const config = {
  entry: './src/index.js',
  output: {
     filename: 'bundle.js',
     //path: path.resolve()
     path: path.resolve(__dirname, 'build')
  }
}

module.exports = config;
