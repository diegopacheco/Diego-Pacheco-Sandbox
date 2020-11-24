list = nil
list = {next = list, value = v}

l = {
    value = 10,
    next = {
        value = 20,
        next = nil
    }
}

function printList(temp)
    while temp ~= nil do
        print(temp.value)
        temp = temp.next
    end
end
printList(l)