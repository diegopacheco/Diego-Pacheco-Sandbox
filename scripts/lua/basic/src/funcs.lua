function sum(a,b)
    result = a + b
    return result
end
print(sum(2,3))

function sumMul(a,b)
    sum = a + b
    mul = a * b
    return sum,mul
end
s,m = sumMul(2,3)
print("Sum is",s,"Mul is",m)