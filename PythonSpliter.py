# General best practice(s) and troubleshooting:
# I did my coding on interpreters, standard and interactive


# Best practice: The name is based on the input info and not too complex or vague. It helps the human brain understand the coding.
user_strings = input('Enter input string: ')

# Control structure: Certain circumstances have to be met to produce the correct outcomes.
# Although 'if' can be included in loop, it does not initiate the loop. The 'for' loop works with
# specified variables, but not random inputs/variables. While was the best choice.

while 'q' != user_strings:
	# CS/BP: I originally used 'not in' and it was working fine. As a best practice, I researched the
	# internet to gain a clear understanding of the differences and which is technically the correct choice.
    # CS/TS: I originally thought that while loops did not stack and must have "else". This code
    # orignally consisted of if/elif/else until I realized it wasn't looping properly.
    
    while 'q' == user_strings:	# CD/BP: I originally used 'in', but also researched online to find out the correct choice (is, ==).
        break
        # CS: From previous attempts, I learned that break must be in the loop, not as last statement.
        # BP/CS: The break was placed before the ',' issue because it should be the first circumstance for the computer to address.
    while ',' not in user_strings:
		# CS: The , issue was placed here because it is the next circumstance for the computer to test. While/not in loop was selected because
		# the user needs to keep entering the input until the proper conditions are met.
        print('Error: No comma in string.')
        user_strings = input('Enter input string: ')
        # The input was entered again. Otherwise, the user would not be able to continue without inputting again.
    else:
        user_strings = user_strings.replace(' ', '')  # CS: Stripping added before splitting for faster computer processing and reduction of possibly errors.
        # TS: Originally, I was using .strip, but it did not remove the inside whitepace. I researched online.
        # I found a community forum, and someone stated that it only strips whitespace at the ends, not every spaces.
        results = user_strings.split(',')  # BP: I renamed the string for easier troubleshooting - also not too vague/complex/unrelated.
        print('First word:', results[0])  # I used Zybooks to check the correct way to reference splits.
        print('Second word:', results[1])
        # TS: When executing, I had an endless loop after the "prints" with no new input command. I reread the code to find what caused the loop.
        # I found that the user input was first entered before the start of the loop, after an user error, but not when the user entered information 
        # correctly (and wanted to continue).
        user_strings = input('Enter input string: ')
