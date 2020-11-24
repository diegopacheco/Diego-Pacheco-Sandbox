function producer()
    print("Type stuff on console")
    return coroutine.create(function()
        while true do
            local line = io.read()
            coroutine.yield(line)
        end
    end)
end

function consumer(p)
    while true do
        local status,line = coroutine.resume(p)
        if status then
            print("INPUT:",line,"\n")
        else
            break
        end
    end
end

p = producer()
consumer(p)