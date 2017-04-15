import csv, random, time

from random import randrange
from datetime import timedelta

def strTimeProp(start, end, format, prop):
    """Get a time at a proportion of a range of two formatted times.

    start and end should be strings specifying times formated in the
    given format (strftime-style), giving an interval [start, end].
    prop specifies how a proportion of the interval to be taken after
    start.  The returned time will be in the specified format.
    """

    stime = time.mktime(time.strptime(start, format))
    etime = time.mktime(time.strptime(end, format))

    ptime = stime + prop * (etime - stime)

    return time.strftime(format, time.localtime(ptime))


def randomDate(start, end, prop):
    return strTimeProp(start, end, '%Y-%m-%d', prop)

prot = ['www.', '']
dom = ['.com', '.eu', '.us', '.en', '.uk' ]
merchandise = ['t-shirts', 'cds', 'vinyls', 'videos', 'hoodies', 'posters']
with open('artists.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    writeCSV = open('website.csv', 'w')
    #writeCSV = csv.writer( open('albums.csv', 'w'), delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL )  
    for row in readCSV:
        strlist = list(row)
        name = random.choice(prot) + (''.join(row[1].strip().split(" "))).lower() + random.choice(dom)
        #print(name)
        newstr = [
                    name,
                    random.choice(merchandise),#merchandise
                    str(randomDate("2017-4-1", "2018-4-1", random.random())), #nexteventdate
                    row[0] #is artistid
                ]
        newstr = ",".join(newstr) + "\n"
        print( newstr )
        writeCSV.writelines(newstr)
    writeCSV.close()
