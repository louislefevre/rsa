# Flowcharts

Compiled on [flowchart.js](http://flowchart.js.org/).



## Key Generation Flowchart
st=>start: Start  
op1=>operation: p = MersenneTwister (2048 bit-length)  
                			   q = MersenneTwiser (2050 bit-length)  
op2=>operation: n = p\*q  
op3=>operation: φ(n) = (p − 1)\*(q − 1)  
op4=>operation: e = 65537  
op5=>operation: d = d\*e = 1  (mod φ(n))  
op6=>operation: Public key = {n, e}  
               			    Private Key = d  
e=>end: End  

st->op1->op2->op3->op4->op5->op6->e  



## RSA Algorithm Flowchart
st=>start: Start  
op1=>operation: m = Plaintext message  
							   Public key = {n, e}  
							   Private key = d  
op2=>operation: Encryption:  
							   c = m^e (mod n)  
op3=>operation: Decryption:  
							   m = c^d (mod n)  
e=>end: End  

st->op1->op2->op3->e  
