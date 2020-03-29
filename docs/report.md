# Report

Include:

- Algorithms (in flow chart form)
- Design (in block diagram or class-diagram in UML)
- Demonstration (5 best screenshots)
- Discussion (including answers to any questions/problems in the Coursework assignment, your experience in attempt of the coursework, and full bibliography)



## Algorithms

Text



## Design
### RSA Package
The RSA package contains the encryption and decryption process for the RSA algorithm, appropriately stored in the “RSA” class. Associated with this class is “RSATest”, which is used to perform tests that ensure its functionality is working correctly.
![alt text](images/package-encryption.png "Encryption Package")

### Keys Package
The keys package is responsible for generating the public and private key used within the RSA algorithm. The “RSAKeyGenerator” provides a static method for generating a “KeyPair”, which contains a public key, private key and the modulus. The “MersenneTwister” class is used for generating secure random numbers, to help ensure that the algorithm cannot be compromised. Lastly, the “RSAKeyGeneratorTest” class is used to perform tests that ensure the keys are generated correctly.
![alt text](images/package-keys.png "Keys Package")

### GUI Package
The GUI package is where the user interface is managed. Each child of the “Tab” class is its own individual section within the interface, and is run through the “MainInterface” class. Within that class they are appended to the tab pane within the primary frame. 
![alt text](images/package-gui.png "GUI Package")



## Demonstration

Text



## Discussion





## References

https://cs.gmu.edu/~sean/research/mersenne/MersenneTwisterFast.java

https://jeremykun.com/2011/07/29/encryption-rsa/

https://github.com/j2kun/rsa

http://flowchart.js.org/