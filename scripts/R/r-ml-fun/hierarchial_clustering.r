idx <- sample(1:dim(iris)[1],40)
irisSample <- iris[idx,]
irisSample$Species <- NULL
hc <- hclust(dist(irisSample),method="ave")
plot(hc,hang=-1,labels=iris$Speciesp[idx])
# Cuting into 3 clusters only
rect.hclust(hc,k=3)
groups <- cutree(hc,k=3)