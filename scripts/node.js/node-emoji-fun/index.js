const emoji = require('node-emoji');
const { log } = console;

const pizza = emoji.get('pizza');
log(pizza);

log(emoji.get("cat"));
log(emoji.get('coffee')) // returns the emoji code for coffee (displays emoji on terminals that support it)
log(emoji.which(emoji.get('coffee'))) // returns the string "coffee"
log(emoji.get(':fast_forward:')) // `.get` also supports github flavored markdown emoji (http://www.emoji-cheat-sheet.com/)
log(emoji.emojify('I :heart: :coffee:!')) // replaces all :emoji: with the actual emoji, in this case: returns "I ❤️ ☕️!"
log(emoji.random()) // returns a random emoji + key, e.g. `{ emoji: '❤️', key: 'heart' }`
log(emoji.search('cof')) // returns an array of objects with matching emoji's. `[{ emoji: '☕️', key: 'coffee' }, { emoji: ⚰', key: 'coffin'}]`
log(emoji.unemojify('I ❤️ 🍕')) // replaces the actual emoji with :emoji:, in this case: returns "I :heart: :pizza:"
log(emoji.find('🍕')) // Find the `pizza` emoji, and returns `({ emoji: '🍕', key: 'pizza' })`;
log(emoji.find('pizza')) // Find the `pizza` emoji, and returns `({ emoji: '🍕', key: 'pizza' })`;
log(emoji.hasEmoji('🍕')) // Validate if this library knows an emoji like `🍕`
log(emoji.hasEmoji('pizza')) // Validate if this library knowns a emoji with the name `pizza`
log(emoji.strip('⚠️ 〰️ 〰️ low disk space')) // Strips the string from emoji's, in this case returns: "low disk space".
log(emoji.replace('⚠️ 〰️ 〰️ low disk space', (emoji) => `${emoji.key}:`)) // Replace emoji's by callback method: "warning: low disk space"
