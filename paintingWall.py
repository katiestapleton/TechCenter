# Remember, spacing MATTERS in the python coding. Its not just cosmetic.

wall_height = float(input('Enter wall height (feet): '))
wall_width = float(input('Enter wall width (feet): '))
wall_area = float(wall_height * wall_width)
print('Wall area:', wall_area, 'square feet')

# paint gallon ratio: 1 gallon = 350 square feet
# paint gallon equation: area/350 = needed gallons
paint_supply_gallon = float(wall_area / 350)
print('Paint needed:', paint_supply_gallon, 'gallons')

#added ceil to value for future usage. minimize coding
paint_cans = math.ceil(paint_supply_gallon)
print('Cans needed:', paint_cans, 'can(s)')
print('')

# Dictionary of paint colors and cost per gallon
paintColors = {
   'red': 35,
   'blue': 25,
   'green': 23
}

# enter input state to provide key input
selected_color = input('Choose a color to paint the wall: ')

# Cost of paint: paint color key * gallons = total cost
total_cost = int(paintColors[selected_color] * paint_cans)

# the Non-comma method to prevent excessive coding. Thanks reddit!
print(f'Cost of purchasing {selected_color} paint: ${total_cost}')
