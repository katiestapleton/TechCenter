# ISSUE: LOOK FOR POSSIBLE LOOP ERROR
# create service cost dictionary

car_services = { # My original mistake was no ','. I referenced zybooks.
    'Oil change' : 35,
    'Tire rotation' : 19,
    'Car wash' : 7,
    'Car wax' : 12,
    '-' : 0  
}

# print full service selection using dictionary
print("Davy's auto shop services")
print(f"Oil change -- ${car_services['Oil change']}")
print(f"Tire rotation -- ${car_services['Tire rotation']}")
print(f"Car wash -- ${car_services['Car wash']}")
print(f"Car wax -- ${car_services['Car wax']}")
print('')

# customer inputs - select 2 services
service_one = input('Select first service: ')
print('')
service_two = input('Select second service: ')
print('')

# print invoice
print("Davy's auto shop invoice")
print('')

# print service one
if service_one is '-': 
    print("Service 1: No service") 
else:
    print(f"Service 1: {service_one}, ${car_services[service_one]}")

# repeat for service two
if service_two is '-':
    print("Service 2: No service")
else:
    print(f"Service 2: {service_two}, ${car_services[service_two]}")

# form equation and then print
print('')
total_cost = car_services[service_one] + car_services[service_two]
print(f'Total: ${total_cost}')

