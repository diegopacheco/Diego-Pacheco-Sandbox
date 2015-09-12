year <- rep(2012:2014, each=4)
quarter <- rep(1:4,3)
cpi <- c(162.2,164.6,166.5,166.0,166.2,167.0,168.6,169.5,171.0,172.1,173.3,174.0)
plot(cpi,xaxt="n",ylab="cpi",xlab="")
axis(1,labels=paste(year,quarter,sep="Q"),at=1:12,las=3)
fit <- lm(cpi ~ year + quarter)
data2015 <- data.frame(year=2015,quarter=1:4)
cpi2015 <- predict(fit,newdata = data2015)
style  <- c(rep(1,12), rep(2,4))

#
# Different plot
#

plot(c(cpi,cpi2015),xaxt="n", ylab="CPI",xlab="",pch=style,col=style)
axis(1,at=1:16,las=3,labels=c(paste(year,quarter,sep="Q"),"2015q1","2015q2","2015q3","2015q4"))