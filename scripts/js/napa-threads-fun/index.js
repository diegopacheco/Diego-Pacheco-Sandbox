const napa = require('napajs');
const zone1 = napa.zone.create('zone1', {
    workers: 4
});

// Broadcast code to all 4 workers in 'zone1'.
zone1.broadcast('console.log("hello world");');

// Execute an anonymous function in any worker thread in 'zone1'.
zone1.execute(
        (text) => text,
        ['hello napa']
    ).then((result) => {
        console.log(result.value);
    });