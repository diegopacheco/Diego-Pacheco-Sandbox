import { parse } from 'node-html-parser';

const root = parse('<ul id="list"><li>Hello World</li></ul>');
console.log(root.firstChild.structure);
console.log(root.querySelector('#list').rawAttrs);