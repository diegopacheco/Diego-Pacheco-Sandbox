local cassandra = require "cassandra"

local peer = assert(cassandra.new {
  host = "127.0.0.1",
  port = 9042,
  keyspace = "my_keyspace"
})

peer:settimeout(1000)

assert(peer:connect())

assert(peer:execute("INSERT INTO users(id, name, age) VALUES(?, ?, ?)", {
  cassandra.uuid("1144bada-852c-11e3-89fb-e0b9a54a6d11"),
  "John O Reilly",
  42
}))

local rows = assert(peer:execute "SELECT * FROM users")

local user = rows[1]
print(user.name) -- John O Reilly
print(user.age)  -- 42

peer:close()
