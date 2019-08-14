"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const observable_webworker_1 = require("observable-webworker");
const rxjs_1 = require("rxjs");
const input$ = rxjs_1.of('Hello from main thread');
observable_webworker_1.fromWorker(() => new Worker('./hello.worker', { type: 'module' }), input$).subscribe(message => {
    console.log(message); // Outputs 'Hello from webworker'
});
