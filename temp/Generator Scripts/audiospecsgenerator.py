import csv, random, time

ext = ['pcm','wav', 'mp3', 'flac', 'aac', 'aiff', 'ogg', 'wma' ]
kbitrate = [ 64, 128, 256, 320 ] 
merchandise = ['t-shirts', 'cds', 'vinyls', 'videos', 'hoodies', 'posters']
writeCSV = open('audiospecs.csv', 'w')
for i in range(1, 5001):
    #print(name)
    newstr = [
                str(i), #songid
                random.choice(ext),#extension
                str(random.choice(kbitrate)), #bitrate
                str(round(random.uniform(1.0, 30.0), 2 )), #size
                str(random.randint(30, 1000)) #duration in secs
            ]
    newstr = ",".join(newstr) + "\n"
    print( newstr )
    writeCSV.writelines(newstr)
writeCSV.close()
