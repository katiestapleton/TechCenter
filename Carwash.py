#A best practice, I will use immediately is adding new comment lines after about 80 characters.
# Its easier to read multiple lines than one really long line.

# Note: I have left my original comments in this code. I added * at the start to make this clear.
# Entering comments helped be remember what section I was coding and helped me address errors.
# I mainly used PyCharm Ed and sometimes Geany as interpreters instead of Zybooks.
# PyCharm Ed is an interactive interpreter. It helped me easily find most errors.
# I paid attention Py Ed's comments. I also executed it often to test for errors that would only be clear when executed.

# To reduce problems, I printed off the assignment to produce a makeshift flowchart.
# It had input/output, equation, print/new line, and dictionary written by the examples.

# As a best practice, I decided to use a dictionary instead of a list of variables.
# A dictionary is better in real life. If prices change, the value only needs to be changed in the dictionary.
# *create service cost dictionary
# CS: A dictionary is more practical for pairing values together. Trying to maintain 2 lists in matching order would be stressful. 
# CS: The dictionary needs to start before references to the keys can be made.
car_services = { # My original mistake was no ','. I referenced zybooks.
    'Oil change' : 35,
    'Tire rotation' : 19,
    'Car wash' : 7,
    'Car wax' : 12,
    '-' : 0  # Since I did the flowchart, this was entered in the dictionary immediately, not at the end.
}

# CS: The services could have been written as one long line of coding, but I think separating the lines made it
# easier for other coders to comprehend. Also, if the order needs to be changed, line can be just be dragged/C&P, which is faster and easier editting.
# *print full service selection using dictionary
print("Davy's auto shop services")
# *proper order: print(f"text{dictname['key']}")
# ^The order is commented because to prevent character from being overlooked and so it could be reused.
# On a previous assignment, using the comma in print was causing issues for exact output.
# I searched the internet for an answer. A Q/A post on Reddit.com showed another method by using print(f'info'). (I do not know the address anymore.)
# It is also a best practice also because it reduces excessive coding and better uniformity. 
print(f"Oil change -- ${car_services['Oil change']}")
print(f"Tire rotation -- ${car_services['Tire rotation']}")
print(f"Car wash -- ${car_services['Car wash']}")
print(f"Car wax -- ${car_services['Car wax']}")
print('')
# I used Zybooks to check about how to apply keys, but it was a little tricky for me.
# I had an error with ''''. I examined the coding closer. I realized I needed to use "" on the outside instead.


# *customer inputs - select 2 services
service_one = input('Select first service: ')
print('')
service_two = input('Select second service: ')
print('')
# I used a best practice: Do not make it hard to understand expression/input is referring to. Keep uniformity in the design.

# Since I am new to programming, I split up the invoice into section using blank lines.
# The comments were placed so I knew what I was coding and what came next.
# The lines and comments are both best practice for me. The coding is easier to review with the long lines.
# *print invoice
print("Davy's auto shop invoice")
print('')

# *print service one
# CS: The If/else allowed users to decide how many services they actually wanted, 0, 1, or 2.
# CS: '-' came first because it applied to only 1 variable, which could quickly be address, followed by the service/cost info.
if service_one is '-': # This was the line that took the longest to resolve the issue. I was not sure how to code it properly.
# It kept turning out as Service 1: - , $0. For example, if service_one == car_services['-']: 
# To resolve the problem, I referred to Zybooks multiple times and what Py Ed was telling me I was doing wrong.
# As a best practice, I executed it when I thought I found a possible solution. I did not want to assume I found the right code.
    print("Service 1: No service")
else: # *else:  proper order: print(f"text {service_numb}, ${dictname['service_numb']}"
    print(f"Service 1: {service_one}, ${car_services[service_one]}")

# CS: see previous CS comments from service_one if/else statement. Also applies to service 2.
# The best practice is used again to maintain uniformity in both if/else statements.
# The statements are set up the same way.
# If service one has an error/issue, the error should be the same in service two.
# Once a find the solution, its much faster to fix service two than analyze a new setup.
# *repeat for service two
if service_two is '-':
    print("Service 2: No service")
else:
    print(f"Service 2: {service_two}, ${car_services[service_two]}")

# CS: the equation was calculated in a separate line to allow for easier troubleshooting. Instead of TS an equation and print 
# in one line. I could focus on each part if there was an issue, which narrowed down the possible mistakes.
# *form equation and then print
print('')
total_cost = car_services[service_one] + car_services[service_two]
# The equation 
# I referred to Zybooks to check how dictionary values are added together.
print(f'Total: ${total_cost}')

# As a best practice, I made sure to save my coding frequently. 
# If the computer froze, then you may lose all work just because you did not save.

# As a best practice, I did my final execution in both Geany and PyCharm Ed, using the services and '-'.
# It’s simply like double checking an assignment for errors. Nothing wrong with double checking!
# Once I knew that it had no errors, I went onto the milestone commenting.
