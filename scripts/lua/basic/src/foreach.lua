-- loop in range from 1 to 10
for var=1,10 do
    print(var)
end

-- from 20 to 30 stepping 3 in 3
for var=20,30,3 do
    print(var)
end

days = {"Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"}

revDays = {}
for i,v in ipairs(days) do
    revDays[v] = i
end
print("Sunday is",revDays["Sunday"])