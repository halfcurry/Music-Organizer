import csv,os,random

newlist = ['/home/music/', '/home/Desktop/music/', '/home/Documents/music/']
with open('top5000songs-2-6-0015.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    writeCSV = open('songs.csv', 'w')
    #writeCSV = csv.writer( open('albums.csv', 'w'), delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL )  
    for row in readCSV:
        strlist = list(row)
        newstr = [row[0],#songid
                  row[1], #artistname
                  row[2], #songname
                  row[3], #year
                  row[4], #songscore
                  row[5], #usascore
                  row[6], #eurscore
                  random.choice(newlist)+row[1][:30]#filepath
                ]
        newstr = ",".join(newstr) + "\n"
        print( newstr )
        writeCSV.writelines(newstr)
    writeCSV.close()
