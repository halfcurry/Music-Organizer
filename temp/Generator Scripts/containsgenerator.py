import csv, random

with open('artistalbumjoin.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    writeCSV = open('containstest.csv', 'w')
    arr = []
    songIDprev = "1";
    for row in readCSV:
        #print(row)
        songID = row[0]
        if( songID == songIDprev ):
            #print(songID)
            arr.append(row)
        else:
            #print(songID)
            newstr = ",".join(list(random.choice(arr))) + "\n"
            print(newstr)
            songIDprev = songID
            arr = [row]
            writeCSV.writelines(newstr)
    writeCSV.close()
