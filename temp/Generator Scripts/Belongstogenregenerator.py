import random

f = open('BelongsToGenre.csv', 'w')
for i in range( 1, 5001 ):
    f.writelines( str(i) + "," + str( random.randint(1,258)) + "\n" )
f.close()
