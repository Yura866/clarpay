
API endpoint :
http://localhost:8080/api/transfer

***************************************************
The post endpoint receive an object like below:
{    
	"sourceAccountNumber": "95C3X2g",
	"destinationAccountNumber": "C3X2gu58",
	"amount": 10  
}

****************************************************

the dockerfile is attached for docker image creation

****************************************************

Answering to the questions from the part 3: 
How would you improve your solution? 
I will implement the new services and exposed  new endpoints for customers and banks... exception handling and security implementation
and more test cases.

After implementation, is there any design decision that you would have done different?
can be refactored with implementation the other design patterns...

How would you adapt your solution if transfers are not instantaneous?
I would save the transaction on the remote storage....)
