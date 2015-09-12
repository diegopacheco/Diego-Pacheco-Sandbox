iris2 <- iris[,1:4]
kmeans.result <- kmeans(iris2,centers=3)
centers <- kmeans.result$centers[kmeans.result$cluster,]
distances <- sqrt(rowSums((iris2 - centers)^2))
outliers <- order(distances,decreasing = T)[1:5]
plot(iris2[,c("Sepal.Length","Sepal.Width")],pch="o",col=kmeans.result$cluster,cex=0.3)
points(kmeans.result$centers[,c("Sepal.Length","Sepal.Width")],col=1:3,pch=8,cex=1.5)
points(iris2[outliers, c("Sepal.Length","Sepal.Width")],pch="+",col=4,cex=1.5)
                  
