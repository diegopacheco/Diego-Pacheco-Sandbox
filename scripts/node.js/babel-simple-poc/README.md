### Build

(1) First build the TS lib. This lib will be exported to JS in lib/ folder.
```bash
cd animal-lib-ts/
npm run build
```

(2) First build the JS lib(Wich uses TS as JS).
```bash
cd animal-js-lib-user/
npm run build
```

(3) Run JS code using TS lib(Exported as JS)
```bash
npm run run
```
```
JS Lib Calling TS lib FISH == 42
```