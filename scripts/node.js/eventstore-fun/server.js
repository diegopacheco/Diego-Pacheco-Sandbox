import {
  jsonEvent,
  FORWARDS,
  START,
  EventStoreDBClient,
} from "@eventstore/db-client";
import { v4 as UUID } from 'uuid';

async function run() {
    
    const client = new EventStoreDBClient({
      endpoint: "localhost:2113",
    });

    const event = jsonEvent({
        type: "TestEvent",
        data: {
          entityId: UUID(),
          importantData: "I wrote my first event!",
        },
      });
    
      await client.appendToStream("some-stream", event);
    
      const events = await client.readStream("some-stream", 10, {
        direction: FORWARDS,
        fromRevision: START,
      });    
}

(async() => {
    console.log('before run');
    await run();
    console.log('after run');
})();