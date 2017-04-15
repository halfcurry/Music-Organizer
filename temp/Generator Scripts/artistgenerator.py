import csv
import random

with open('artists-2-2-32.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    writeCSV = open('artists.csv', 'w')
    gender = ['M', 'F']
    states = [

         'Alabama','Alaska','Arizona','Arkansas','California','Colorado',
         'Connecticut','Delaware','Florida','Georgia','Hawaii','Idaho', 
         'Illinois','Indiana','Iowa','Kansas','Kentucky','Louisiana',
         'Maine' 'Maryland','Massachusetts','Michigan','Minnesota',
         'Mississippi', 'Missouri','Montana','Nebraska','Nevada',
         'New Hampshire','New Jersey','New Mexico','New York',
         'North Carolina','North Dakota','Ohio',    
         'Oklahoma','Oregon','Pennsylvania','Rhode Island',
         'South  Carolina','South Dakota','Tennessee','Texas','Utah',
         'Vermont','Virginia','Washington','West Virginia',
         'Wisconsin','Wyoming'
    ]
    #writeCSV = csv.writer( open('albums.csv', 'w'), delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL )  
    for row in readCSV:
        strlist = list(row)
        newstr = [row[-1],#artistid
                  row[0],#artistname
                  row[-2], #artistscore
                  random.choice(gender),#gender
                  random.choice(states)#hometown
                ]
        newstr = ",".join(newstr) + "\n"
        print( newstr )
        writeCSV.writelines(newstr)
    writeCSV.close()
