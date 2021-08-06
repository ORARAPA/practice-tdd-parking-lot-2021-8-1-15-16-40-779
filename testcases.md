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
[] Case1  
Given a parking lot, standard parking boy and a car
When park the car      
Return parking ticket

[] Case2  
Given a parking lot with a parked car, a standard parking boy, a parking ticket  
When fetch the car      
Return parked car

[] Case3  
Given a parking lot with two parked cars, a standard parking boy, and two parking tickets
When fetch the car (2x)     
Return right car for each ticket

