//
// new terminal run: /usr/bin/google-chrome --remote-debugging-port=9222 --disable-gpu --headless
//
//
const { Chromeless }  = require('chromeless')

const fs = require('fs')
function copyFile(src, dest) {
  let readStream = fs.createReadStream(src)
  readStream.once('error', (err) => {
    console.log(err)
  })
  readStream.once('end', () => {
    console.log('done copying')
  })
  readStream.pipe(fs.createWriteStream(dest))
}

async function run() {
  const chromeless = new Chromeless()
  const screenshot = await chromeless
    .goto('https://www.google.com')
    .type('chromeless', 'input[name="q"]')
    .press(13)
    .wait('#resultStats')
    .screenshot()
  copyFile(screenshot, '/app/' + screenshot.replace('/tmp/',''))
  console.log('Done -> ' + '/app/' + screenshot.replace('/tmp/',''))
  await chromeless.end()
}

run().catch(console.error.bind(console))
