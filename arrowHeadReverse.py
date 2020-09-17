# ERROR(S) WITHIN CODE. FIX.
# prints in wrong order. need to error if user enters wrong value

arrow_base_height = int(input('Enter arrow base height: '))
arrow_base_width = int(input('Enter arrow base width: '))
arrow_head_width = int(input('Enter arrow head width: '))

while arrow_head_width <= arrow_base_width:
    arrow_head_width = int(input('Enter arrow head width: '))
    if arrow_head_width > arrow_base_width:
# known issue: else:
      for arrow_base_height in range(arrow_base_height):
        for i in range(arrow_base_width):
          i += 1
          print('*', end=' ')
        print('')
      for arrow_head_width in range(arrow_head_width):
        for arrow_top in range(arrow_head_width):
          arrow_top -= 1
          print('*', end=' ')
        print('')
    
     
    
    
    
    
    
    
    
    
    
    
           

    
    
    


