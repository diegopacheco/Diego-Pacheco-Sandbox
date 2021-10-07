```bash
node app.js &
dredd api-description.yml http://127.0.0.1:3000 
```
```
$ dredd api-description.yml http://127.0.0.1:3000
(node:84194) Warning: Accessing non-existent property 'padLevels' of module exports inside circular dependency
(Use `node --trace-warnings ...` to show where the warning was created)
pass: GET (200) / duration: 56ms
complete: 1 passing, 0 failing, 0 errors, 0 skipped, 1 total
complete: Tests took 59ms
```
