import { fromWorker } from 'observable-webworker';
import { of } from 'rxjs';

const input$ = of('Hello from main thread');

fromWorker<string, string>(() => new Worker('./hello.ts', { type: 'module' }), input$).subscribe(message => {
  console.log(message); // Outputs 'Hello from webworker'
});
