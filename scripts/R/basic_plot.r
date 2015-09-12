pdf("d:/plot.pdf")
library(MASS)
parcoord(iris[1:4],col=iris$Species)
graphics.off()