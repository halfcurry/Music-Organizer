import csv
with open('genres.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    writeCSV = open('mygenres.csv', 'w')
    count = 0
    for row in readCSV:
        count = count + 1
        writeCSV.writelines( str(count) + "," + row[0] + ",https://en.wikipedia.org/wiki/" + ''.join(row[0].strip().split(" ")).lower() + "\n" )
    writeCSV.close()
