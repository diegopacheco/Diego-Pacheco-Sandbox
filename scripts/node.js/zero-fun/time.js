// time.js
const moment = require("moment")

module.exports = (req, res) => {
  var time = moment().format('LT');   // 11:51 AM
  res.send({time: time })
}
