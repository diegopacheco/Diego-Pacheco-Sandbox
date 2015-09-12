set.seed(1234)
ind <- sample(2, nrow(iris),replace=TRUE, prob=c(0.7,0.3))
trainData <- iris[ind==1,]
testData <- iris[ind==2,]
library(parallel)
myFormula <- iris$Species ~ iris$Sepal.Length + iris$Sepal.Width + iris$Petal.Length + iris$Petal.Width
iris_ctree <- ctree(myFormula, data=trainData)
testPred <- predict(iris_ctree, newdata = testData)

table(predict(iris_ctree),trainData$Species)

print(iris_ctree)

