# Build a dictionary containing the specified movie collection
movie_list = {
    "Munich":          [2005, "Steven Spielberg"],
    "The Prestige":    [2006, "Christopher Nolan"],
    "The Departed":    [2006, "Martin Scorsese"],
    "Into the Wild":   [2007, "Sean Penn"],
    "The Dark Knight": [2008, "Christopher Nolan"],
    "Mary and Max":    [2009, "Adam Elliot"],
    "The King\'s Speech": [2010, "Tom Hooper"],
    "The Artist":      [2011, "Michel Hazanavicius"],
    "The Help":        [2011, "Tate Taylor"],
    "Argo":            [2012, "Ben Affleck"],
    "12 Years a Slave": [2013, "Steve McQueen"],
    "Birdman":         [2014, "Alejandro G. Inarritu"],
    "Spotlight":       [2015, "Tom McCarthy"],
    "The BFG":         [2016, "Steven Spielberg"]
}

# Prompt the user for a year 
user_year = int(input('Enter a year between 2005 and 2016:\n'))
while user_year < 2005 or user_year > 2017:
    print('N/A')
    user_year = int(input('Enter a year between 2005 and 2016:\n'))
    
# Displaying the title(s) and directors(s) from that year
for name, info in movie_list.items():
    if info[0] == user_year:
        print("%s, %s" % (name, info[1]))
print("")

# Display menu
print('MENU\nSort by:\ny - Year\nd - Director\nt - Movie title\nq - Quit\n')
menu = input('Choose an option:\n')

# Carry out the desired option: Display movies by year, 
# display movies by director, display movies by movie title, or quit
while menu != 'q':
    break
    if menu == 'y':
        print('FIXy')
        print("")
    elif menu == 'd':
        print('FIXd')
        print("")
    elif menu =='t':
        years = sorted(movie_list.items())
        print(title[1], title[0])
        print("")
   
