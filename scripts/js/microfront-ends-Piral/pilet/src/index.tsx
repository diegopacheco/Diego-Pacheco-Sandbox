import { PiletApi} from 'piral';
import * as React from 'react';

export function setup(app: PiletApi) {
  app.showNotification('Hello from Piral!');
  app.registerMenu(() =>
    <a href="http://diego-pacheco.blogspot.com" target="_blank">Diego Pacheco Blog</a>
  );
  app.registerTile(() => <div>Welcome to Piral!</div>, {
    initialColumns: 2,
    initialRows: 1,
  });
}
