# Story 1
[X] Case1  
Given a parking lot, and a car  
When park the car  
Then return a parking ticket. 

[X] Case2  
Given a parking ticket  
When fetch the car  
Then return the car.

[X] Case3  
Given two parked cars and two parking tickets  
When fetch the car  
Return right car.  

[X] Case4  
Given a wrong ticket  
When fetch the car  
Return nothing

[X] Case5  
Given a used parking ticket  
When fetch the car  
Return nothing

[X] Case6  
Given a full parking lot, a car    
When park the car  
Return nothing


# Story 2
[X] Case1  
Given an unrecognized ticket  
When fetch the car      
Return error message "Unrecognized parking ticket."    

[X] Case2  
Given a used ticket  
When fetch the car      
Return error message should be "Unrecognized parking ticket."

[X] Case3 
Given a parking lot without any position, and a car  
When park the car        
Return error message should be "No available position."  


# Story 3
[X] Case1  
Given a parking lot, standard parking boy and a car
When park the car      
Return parking ticket

[X] Case2  
Given a parking lot with a parked car, a standard parking boy, a parking ticket  
When fetch the car      
Return parked car

[X] Case3  
Given a parking lot with two parked cars, a standard parking boy, and two parking tickets  
When fetch the car (2x)     
Return right car for each ticket

[X] Case4  
Given a parking lot, a standard parking boy, and wrong ticket
When fetch the car    
Return  error message "Unrecognized parking ticket."

[X] Case5  
Given a parking lot, a standard parking boy, and used parking ticket  
When fetch the car    
Return error message "Unrecognized parking ticket."

[X] Case6  
Given a parking lot without any position, a standard parking boy, and a car  
When park the car    
Return error message "No available position."

# Story 4
[X] Case1  
Given a standard parking boy that manages two parking lots, two not full parking lots, and a car  
When park the car      
Return car parked in first parking lot

[X] Case2  
Given a standard parking boy that manages two parking lots, first lot is full second with position, and a car  
When park the car      
Return car parked in second parking lot

[X] Case3  
Given a standard parking boy that manages two parking lots, both parking lots with parked car, and two parking ticket  
When fetch the car (2x)      
Return right car for each ticket

[X] Case4  
Given a standard parking boy that manages two parking lots, and unrecognized ticket  
When fetch the car    
Return  error message "Unrecognized parking ticket."

[X] Case5  
Given a standard parking boy that manages two parking lots, and used parking ticket  
When fetch the car    
Return error message "Unrecognized parking ticket."

[X] Case6  
Given a standard parking boy that manages two parking lots without any position, and a car  
When park the car    
Return error message "No available position."

# Story 5
[X] Case1  
Given a smart parking boy, first parking lot has 2 parked cars, second parking lot has 1 parked car, and a car  
When park the car      
Return car parked in second parking lot

[X] Case2  
Given a smart parking boy with two empty parking lots, and three cars  
When park the car (3x)     
Return right parking lot for each car

[X] Case3  
Given a smart parking boy with parked cars in two parking lots, and two parking tickets  
When fetch the car (2x)      
Return right car for each ticket

[X] Case4  
Given a smart parking boy that manages two parking lots, and unrecognized ticket  
When fetch the car    
Return  error message "Unrecognized parking ticket."

[X] Case5  
Given a smart parking boy that manages two parking lots, and used parking ticket  
When fetch the car    
Return error message "Unrecognized parking ticket."

[X] Case6  
Given a smart parking boy that manages two parking lots without any position, and a car  
When park the car    
Return error message "No available position."


# Story 6
[X] Case1  
Given a super smart parking boy, first parking lot has 1 parked car, second parking lot has 2 parked cars, and a car  
When park the car      
Return car parked in first parking lot

[X] Case2  
Given a super smart parking boy with two empty parking lots, and three cars  
When park the car (3x)     
Return right parking lot for each car

[X] Case3  
Given a super smart parking boy with parked cars in two parking lots, and two parking tickets  
When fetch the car (2x)      
Return right car for each ticket

[X] Case4  
Given a super smart parking boy that manages two parking lots, and unrecognized ticket  
When fetch the car    
Return  error message "Unrecognized parking ticket."

[X] Case5  
Given a super smart parking boy that manages two parking lots, and used parking ticket  
When fetch the car    
Return error message "Unrecognized parking ticket."

[X] Case6  
Given a super smart parking boy that manages two parking lots without any position, and a car  
When park the car    
Return error message "No available position."


