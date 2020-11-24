Account = {}
function Account:new (o)
    o = o or {}   -- create object if user does not provide one
    setmetatable(o, self)
    self.__index = self
    return o
end

function Account.withdraw (self,v)
    self.balance = self.balance - v
end

function Account.printBalance(self)
    print("Account Balance: R$ "..self.balance)
end

a = Account.new({ balance = 500.0 })
Account.printBalance(a)
Account.withdraw(a,100.00)
Account.printBalance(a)