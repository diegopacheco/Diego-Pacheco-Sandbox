a=1:10
b=10:100

save(a,"./data.rdata")

rm(a)

load(file="./data.rdata")

var1=1:5
var2=(1:5)/2
var3=c("diego","pacheco","R","ML")

df1=data.frame(var1,var2,var3)
names(df1)=c("Integers","Doubles","Strings")

write.csv(df1,file="d:/data.csv",row.names = FALSE)
df1
