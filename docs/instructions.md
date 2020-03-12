## Part I
- Develop a software prototype in Java to demonstrate how the RSA algorithms work.

- Use the simplified algorithms and examples studied in the lectures/workshops.

- Your prototype should demonstrate:
  - How two primes p and q are generated.
  - How the random number e is generated, where 0 < e < r and e has no factor in common with r.
  - How the private key d and public key (e,n) are generated.

- As part of testing, may also demonstrate a special case when your RSA program would not work securely.
  - Your program should prompt the user to input certain parameters that would lead to the problematic state.

- Design at least a simple user interface to allow the user to simulate a communication scenario:
  - Where Alice sends an encrypted message to Bob, and Bob decrypts the cipher text to read the message.
  - Also, Charlie may intercept the data flow and obtain unauthorised information.
- For example, the following format may be adopted to demonstrate what happens with the plaintext m that travels from Alice to Bob, where “??” parts are for you to design:
  Alice    Charlie    Bob
    m
    ↓
    ??   →   ??   →   ??
    ↓
    ??   ←   ??   ←   ??
    ↓        ↓
    ??       ??
    ↓
    ??   →   ??   →   ??
             ↓        ↓
             ??       ??

It would be easier to divide the task into a number of sub-tasks:
1. Implement a crypto-random key generator and the algorithm for modular exponentiation.
2. Implement the RSA encryption algorithm.
3. Implement the RSA decryption algorithm.

## Part II
- Based on the software prototype that you have developed in the previous part, analyse and implement the protocol below about authentication using a trusted server S:
  - Suppose a trusted server S that distributes public keys on behalf of others. Thus S holds Alice’s public key KA and Bob’s public key KB. S’s public key, kS, is well known. Now Alice (A) and Bob (B) wish to authenticate with each other and they propose to use the following protocol.
    1) Dear S, This is A and I would like to get B’s public key. Yours sincerely, A.
    2) Dear A, Here is B’s public key signed by me. Yours sincerely, S.
    3) Dear B, This is A and I have sent you a nonce only you can read. Yours sincerely, A.
    4) Dear S, This is B and I would like to get A’s public key. Yours sincerely, B.
    5) Dear B, Here is A’s public key signed by me. Yours sincerely, S.
    6) Dear A, Here is my nonce and yours, proving I decrypted it. Yours sincerely, B.
    7) Dear B, Here is your nonce proving I decrypted it. Yours sincerely, A.

- Implement this protocol in Java to demonstrate how it works (again in decimal). There is no specific requirement to the user interface of your prototype but you may like to use the same simple user interface in the previous coursework assignment.

- Identify and in your program demonstrate if there is an error or/and a subtle vulnerability of this protocol.
  - [Hint: Consider if A uses this protocol to authenticate with a third-party Z.]

- You may add if necessary assumptions for details to ease your implementation, but you must explain them clearly to gain credits.

- Also, you may decide where to start your implementation but it might be easier for you to first work out the keys and notations involved in each step.
  - For example, let nA and nB be the nonce of A and of B respectively, and (x, y)k be (x, y) with a signature k.
  The following lines denote the protocol with information flows to be transmitted.
    1) A → S: A, B
    2) S → A: (KB,B)kS
    3) A → B: (nA,A)KB
    4) B → S: B, A
    5) S → B: (KA,A)kS
    6) B → A: (nA,nB)KA
    7) A → B: (nB)KB
