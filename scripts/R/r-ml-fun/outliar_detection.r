set.seed(3147)
x <- rnorm(100)
y <- rnorm(100)
summary(x)
summary(y)

boxplot.stats(x)$out
boxplot(x)

df <- data.frame(x,y)
rm(x,y)

attach(df)
( a <- which(x %in% boxplot.stats(x)$out) )
( b <- which(y %in% boxplot.stats(y)$out) )
detach(df)

(outlier.list <- union(a,b))
plot(df)
points(df[outlier.list,], col = "blue", pch = "x", cex=2)