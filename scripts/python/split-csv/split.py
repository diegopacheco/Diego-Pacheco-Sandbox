csvfile = open('/home/diego/Downloads/excel.csv', 'r').readlines()
filename = 1
splitBy = 2000
for i in range(len(csvfile)):
     if i % splitBy == 0:
         open(str(filename) + '.csv', 'w+').writelines(csvfile[i:i+splitBy])
         filename += 1
