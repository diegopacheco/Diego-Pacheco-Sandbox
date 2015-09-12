iris2 <- iris
iris2$Species <- NULL
kmeans.result <- kmeans(iris2,3)
plot(iris2[c("Sepal.Length","Sepal.Width")], col = kmeans.result$cluster)
points(kmeans.result$centers[,c("Sepal.Length","Sepal.Width")],col=1:3,pch=8,cex=2)