# Report
Documentation report for the RSA algorithm implemented by Louis Lefevre.

## Algorithms
### Key Generation
Before encryption or decryption can take place, we must generate a pair of keys: the public key and the private key. The public key is available publicly and shared with the world, while the private key is kept secret by its owner. The following describes the steps in detail:
- In order to generate these keys we begin by assigning variables p and q with a pair of random prime numbers of similar bit-length using the Mersenne Twister pseudo-random number generator, giving us two extremely large prime numbers. 
- The modulus, known as n, is then calculated by multiplying p by q.
- Phi, known as φ(n), is then used to store a calculated value of Euler’s totient function for n. This is done by doing p minus 1 and q minus 1, and multiplying the results.
- The public exponent, known as e, is a number that is larger than 1, smaller than φ(n), and is co-prime with φ(n). In most cases, and in many implementations of RSA, the Fermat number 65537 is used, as it always meets all the requirements listed.
- The private exponent, known as d, is calculated by finding a value that fulfils the equation d * e = 1 (mod φ(n)).  
![alt text](images/key-generation.png "Key Generation Algorithm")

### RSA Algorithm
Once we have the public and private key, we can use them to encrypt and decrypt a plain-text message. Either key can be used to encrypt a message, but a message cannot be decrypted with the same key it was encrypted with, only the opposite key can do that. The following describes the steps in detail:
- For encryption, you will typically want to use the public key (containing n and e). To generate the cipher-text from the plain-text, the plain-text is converted into its byte form so it can be read as a sequence of numbers. The bytes, represented by variable m, then have the equation m<sup>e</sup> (mod n) applied to them, generating the cipher-text c.
- For decryption, you will typically want to use the private key (containing d). To generate the plain-text from the cipher-text, the cipher-text is applied to the equation c<sup>d</sup> (mod n), generating the plain-text in byte form. The bytes array is then converted back into text form, giving us the plain-text message back.  
![alt text](images/rsa-algorithm.png "RSA Algorithm")

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
### Key Generation
![alt text](images/key-generation-demonstration.png "Key Generation Demonstration")

### Encryption
![alt text](images/encryption-demonstration.png "Encryption Demonstration")

### Decryption
![alt text](images/decryption-demonstration.png "Decryption Demonstration")

## Discussion
During the first iteration of development, I originally went with a different approach; each individual character would be converted into its numerical ASCII value, and then applied to the RSA encryption algorithm. The returned result would then be appended to an array containing the entire encrypted message, with each position representing a single character. However, the issue with this is that the cipher-text would always have to be stored as an array rather than a string, since in the latter form it would be impossible to tell where each ASCII value begins and ends.

I also initially had issues with the random number generation that was used at various locations within the program. I got to a point where the encryption and decryption was working correctly, but I discovered that it would fail a fraction of the time. I did this by running thousands of tests on the same input and checking their result, which revealed that under various circumstances anywhere from 1% to 50% of the program executions would fail. I realised this was due to the random number generator producing values that cause the algorithm to break, but was unsure what distinguished these numbers from the rest. In hindsight, I realised one of the issues was due to the plain-text message being smaller in value than the modulus, so if both primes were small enough this would cause the encryption process to malfunction. It was also made worse by the fact it was possible for the prime numbers to occasionally be the same value, which again broke the algorithm.

A third problem was that I could only process messages that were small in length. Strings of text with only a few characters would successfully encrypt and decrypt consistently, but as messages grew longer the rate of failure became larger. This was related to the previous problem, as a longer message means a larger message, and the likelihood of the messages value being greater than that of the modulus increased.

Lastly, I was storing my values using the primitive long data type. The issue with using long is that it has a limited capacity and cannot store numbers of an arbitrary length, which hinders the RSA algorithms security massively, as the main aspect that makes it secure is the fact the two prime numbers used during key generation are extremely large in bit-length. 

In order to solve these issues I decided to start using the BigInteger Java class to manage numbers. Since storing extremely large numbers isn’t possible with longs, the move to BigIntegers which don’t have limitations in size, made a lot of sense. BigInteger also provides lots of useful methods and functions that can be used to perform vital steps within the algorithm, further improving its security, and solving the issues previously listed: instead of converting each individual character to ASCII I could convert an entire string to its byte form and pass it as a parameter to a BigInteger constructor, I could dictate the bit-length of the prime numbers to ensure they are long enough and completely different in value, and I improved the security of the algorithm massively as the resulting encrypted messages were far greater in size than they previously were.

One final change I made was that initially I calculated the public exponent e manually by finding a value that met the conditions: e > 1, e < φ(n), and e co-prime with φ(n). However, I then discovered that in most RSA algorithms they use one of the Fermat numbers in their implementations, typically the highest known term 65537. Since using this number as the public key in all messages is essentially fool proof, I decided to adopt it myself.



## References
- [Crypto-It RSA](http://www.crypto-it.net/eng/asymmetric/rsa.html) - Key generation and RSA algorithms
- [How the RSA Algorithm Works](https://www.youtube.com/watch?v=Z8M2BTscoD4) - Explanation of RSA algorithm process
- [Fermat Numbers](https://en.wikipedia.org/wiki/Fermat_number) - Fermat numbers terms
- [Mersenne Twiser](https://cs.gmu.edu/~sean/research/mersenne/MersenneTwisterFast.java) - Source code for Mersenne Twister pseudo-random number generator
- [Encryption RSA](https://jeremykun.com/2011/07/29/encryption-rsa/) - BigInteger implementation theory
- [Flowchart.js](http://flowchart.js.org/) - Flowchart generation
