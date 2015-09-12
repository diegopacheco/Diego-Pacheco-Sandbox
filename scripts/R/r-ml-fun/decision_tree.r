set.seed(1234)
ind <- sample(2, nrow(iris),replace=TRUE, prob=c(0.7,0.3))
trainData <- iris[ind==1,]
testData <- iris[ind==2,]
library(party)
myFormula <- iris$Species ~ iris$Sepal.Length + iris$Sepal.Width + iris$Petal.Length + iris$Petal.Width
iris_ctree <- ctree(myFormula, data=trainData)
testPred <- predict(iris_ctree, newdata = testData)


print(iris_ctree)
plot(iris_ctree,type="simple")
