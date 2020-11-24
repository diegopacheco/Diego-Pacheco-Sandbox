a = {}     -- create a table and store its reference in `a'

k = "x"
a[k] = 10        -- new entry, with key="x" and value=10
a[20] = "great"  -- new entry, with key=20 and value="great"

print(a["x"])    --> 10
print(a[20])     --> great
print(a)