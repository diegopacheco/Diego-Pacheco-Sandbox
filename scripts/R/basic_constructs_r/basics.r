#
# Vars
#
i = 10
f = 10.6
s = "Diego String"
b = TRUE

#
# Sequence
#
s1 = 1:10

#
# Vector
#
v1 = c(1,2,3,6)

#
# Functions
#
inc = function(v){ v + 1 }
inc(5)

#
# Matrix
#
m = matrix(data = 1:10, nrow=5, ncol=5)

mm1 = matrix(1:4,2,2)
mm2 = matrix(1:4,2,2)
mm1 == mm2
identical(mm1,mm2)

#
# Lists
#
l = list(1,10,100,500)

#
# Factors
# 
factors = factor(c("MALE","FEMALE","MALE","FEMALE"))
levels(factors)
unclass(factors)

#
# Data Frame
#
df = data.frame(
  Name = c("CAT","DOG","PIG","LION"),
  HowMany = c(2,1,0,3),
  isPet = c(TRUE,TRUE,FALSE,FALSE)
)

# col - row
df[1,1]
# row
df[1,]
# cols
df[,1]
# name 
df[["Name"]]
# shortcut
df$Name
# sub framing
df[c(2,4),]
# kinda of queries
df[df$isPet==TRUE,]
df[df$HowMany>=2,]
df[df$Name %in% c("CAT","ALIGATTOR"),]

#
# R is a vectorized lang
#
1 + 2 
c(1,2,3) + c(4,5,6)

# HELP
?c

