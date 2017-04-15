import csv

songs = open('songs.csv')
artists = open( 'artists.csv')    
readsong = songs.reader(csvfile, delimiter=',')
readartist = songs.reader(csvfile, delimiter=',')
