function status(co)
    print("coroutine status: "..coroutine.status(co))
end

co = coroutine.create(function ()
    print("hi")
end)
print(co)

status(co)
coroutine.resume(co) -- prints hi
status(co)