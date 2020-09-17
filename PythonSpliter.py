# add user input: exit to loop. add further coding later

# initial entry
print('This program is designed to split one user enter into 2 outputs.')
print('Now enter in two words with a comma. Ex: add, comma or add,comma.')
user_strings = input('Enter input string: ')

while 'q' != user_strings:   
    while 'q' == user_strings:	
        break

    # the user needs to keep entering the input until the proper conditions are met.
    while ',' not in user_strings:
        print('Error: Incorrect input. Please try again. (2 words separated by comma)')
        user_strings = input('Enter input string: ')
    else:
        # stripping  before splitting for faster processing and error reduction.
        user_strings = user_strings.replace(' ', '')  
        results = user_strings.split(',') 
        #printing results
        print('First word:', results[0])  
        print('Second word:', results[1])
        user_strings = input('Enter input string: ')
