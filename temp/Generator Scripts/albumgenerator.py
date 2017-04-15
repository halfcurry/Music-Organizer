import csv

with open('top3000albums-2-6-0015.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    writeCSV = open('albums.csv', 'w')
    #writeCSV = csv.writer( open('albums.csv', 'w'), delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL )  
    for row in readCSV:
        strlist = list(row)
        newstr = [row[0],#albumid
                  row[1], #artistname
                  row[2], #albumname
                  row[3], #year
                  row[4] #albumscore
                ]
        newstr = ",".join(newstr) + "\n"
        print( newstr )
        writeCSV.writelines(newstr)
    writeCSV.close()
        
