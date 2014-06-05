import calendar
import datetime

class DevHours:

	WORKED = 26.0
	MES  = 6
	ANO  = 2014 
	FERIADOS = 1

	WH   = 8.45
	BASE = 180.0

	def countDays(self):
		weekday_count = 0
		cal = calendar.Calendar()
		for week in cal.monthdayscalendar(self.ANO, self.MES):
		    for i, day in enumerate(week):
		        if day == 0 or i >= 5:
		            continue
		        weekday_count = weekday_count + 1
		return weekday_count - self.FERIADOS        

	def calcMissingDays(self):
	    today_day = datetime.datetime.now().day
	    return self.countDays() - today_day

	def calcDiff(self,workedHours):
		return (self.BASE - workedHours)

	def calcDiffHoursPerDay(self,workedHours):
	    return ( self.calcDiff(workedHours) / self.calcMissingDays() ) 

	def info(self):
		weekday_count = self.countDays()
		print '===> ' + str(self.ANO) + '/' + str(self.MES)
		print 'dias uteis: ' + str(weekday_count)
		print str(self.WH) + ' h = ' + str(weekday_count*self.WH)
		print str(self.WH+1) + ' h = ' + str(weekday_count*(self.WH+1))
		print str(self.WH+2) + ' h = ' + str(weekday_count*(self.WH+2))
		print str(self.WH+3) + ' h = ' + str(weekday_count*(self.WH+3))
		print 'Worked: ' + str(self.WORKED) + 'h to work: ' + str(self.calcDiff(self.WORKED)) + 'h'
		print 'Still have ' + str(self.calcMissingDays()) + ' to work'
		print 'AVG hours per day: ' + str(self.calcDiffHoursPerDay(self.WORKED))

dh = DevHours()
dh.info()