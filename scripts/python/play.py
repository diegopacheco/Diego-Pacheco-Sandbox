# Simple Strings usages
print ("python kicks ass like 2x2 = ".capitalize(), 2*2)
print ("My name is %s and age is %d years!" % ('Diego Pacheco', 25) )
print ("NO CAPSLOCK HERE".lower())

#IF and else Statements playground
value = 120
if value==100 :
   print ("The value is %s" % value)
else:
   print ("This is other loousy value %s" % value)
   
# Loop fun and stuffs   
i = 1
while (i <= 10):
   print ("2 X %d = %d " %  (i, i * 2) )
   i = i + 1

fruits = ['banana', 'apple',  'mango', 'melancia']
for fruit in fruits:        
   print ('Current fruit :', fruit)

for letter in 'Python':
   print ('Current Letter :', letter)

# Lists and beast :-)
listStuffs = ['physics', 'chemistry', 1997, 2000];
listStuffs[2] = 2001
print (listStuffs)

del listStuffs[2]
print (listStuffs)

#Python Tuples this is new to me, nice :D
tup1 = ('physics', 'chemistry', 1997, 2000);
tup2 = (1, 2, 3, 4, 5 );
tup3 = "a", "b", "c", "d";

print (tup1)
print (tup2)
print (tup3)

#Python dictionaty, hm... in java we call that Maps
dict = {'Alice': '2341', 'Beth': '9102', 'Cecil': '3258'}
print (dict)

dict = {'Name': 'Zara', 'Age': 7, 'Class': 'First'}
print ("dict['Name']: ", dict['Name'])
print ("dict['Age']: ", dict['Age'])
   
del dict['Name']
print (dict)

# Date and Time
import time
import calendar

ticks = time.time()
print ("Number of ticks since 12:00am, January 1, 1970:", ticks)

localtime = time.localtime(time.time())
print ("Local current time :", localtime)

localtime = time.asctime( time.localtime(time.time()) )
print ("Local current time :", localtime)

cal = calendar.month(2010, 6)
print ("Here is the calendar:")
print (cal)

#Yes baby yeah, functions finally
def soma( a, b = 0):
   print ("Soma %d + %d = %d" % (a,b,a+b) )
   return;

# Now you can call printme function
soma(10,5)
soma(5)

#Kicks ASS
sum = lambda arg1, arg2: arg1 + arg2;
print ("Value of total : ", sum( 10, 20 ))

# Yes we can return
def kicks(who = "Argentina"):
    return ("Yes %s sucks" % who)
	
whoSucks = kicks("Inter")
print (whoSucks)

# IO easy made
str = input("Enter your name buddy ")
print ("Great :", str)

fo = open("C:/tmp/file.py.txt", "wb")
print ("Name of the file: ", fo.name)
print ("Closed or not : ", fo.closed)
print ("Opening mode : ", fo.mode)
fo.close()

fo = open("C:/tmp/file.py2.txt", "w")
fo.write("Python")
fo.close()

# OO and Python ohh yeah
class Parent:
   def doit(self):
      print ("Strubbles me")

class People(Parent):
   name = ""
   age  = 0

   def __init__(self, name, age):
      self.name = name
      self.age  = age
   
   def __str__(self):
     return ("Name: %s Age %d" % (self.name, self.age) )
   
   def displayName(self):
     print ("My Name is %s" % self.name)

   def displayAge(self):
     print ("My age is :", self.age)

p1 = People("Diego Pacheco", 25)
p1.displayName()
p1.displayAge()
p1.doit()
print (p1)
