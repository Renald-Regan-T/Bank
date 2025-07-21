### ✅ **Project Title:** Banking Management System with File Persistence

---

### ✅ **Overview:**

This Java-based project simulates a **banking system** that allows users to:

* Create accounts
* Withdraw money
* Deposit money
* Transfer funds
* View transaction history
* And persist all data (customers and transactions) to files.

---

### ✅ **Features:**

1. **Customer Account Creation**
2. **ATM Withdrawal**
3. **Cash Deposit**
4. **Account-to-Account Transfer**
5. **Transaction History**
6. **Persistent File Storage for Customers and Transactions**

---

### ✅ **Technologies Used:**

* Java Collections (Map, List)
* File I/O using `BufferedReader` and `BufferedWriter`
* Console-based user interaction

---

### ✅ **Class Diagram:**

```plaintext
                 +--------------------+
                 |      Main          |
                 +--------------------+
                 | - Scanner sc       |
                 +--------------------+
                 | + main()           |
                 +---------+----------+
                           |
                           ▼
                 +--------------------+
                 |   Application      |
                 +--------------------+
                 | - customers        |
                 | - global_Transactions|
                 | - File_handling fl |
                 | - idgenerator      |
                 +--------------------+
                 | +add_Customer()    |
                 | +atm_withdrawal()  |
                 | +atm_deposit()     |
                 | +account_transfer()|
                 | +transaction_history()|
                 | +persistent_file() |
                 | +file_list()       |
                 | +authentication()  |
                 | +encry_Pw()        |
                 +--------------------+
                /|\   
                 |
     +-----------+----------+
     |                      |
     ▼                      ▼
+------------+       +-------------------+
|  Customer  |       |   Transaction     |
+------------+       +-------------------+
| - id       |       | - acNo            |
| - acNo     |       | - type            |
| - name     |       | - amount          |
| - balance  |       | - balancce        |
| - encryptedPwd|    +-------------------+
| - transactions |
+------------+

                 ▲
                 |
         +---------------+
         | File_handling |
         +---------------+
         | +file_write() |
         | +file_read()  |
         | +file_write2()|
         +---------------+
```

---

### ✅ **Class Responsibilities:**

#### 🔷 `Main`

* Console interface for interacting with the user.
* Routes user input to respective application methods.

#### 🔷 `Application`

* Core logic of the banking system.
* Manages all customers and their transactions.
* Handles account operations (add, withdraw, deposit, transfer).
* Manages encryption, authentication, and file persistence.

#### 🔷 `Customer`

* Represents a single customer.
* Contains account number, name, balance, encrypted password.
* Holds personal transaction history.

#### 🔷 `Transaction`

* Represents a single banking transaction.
* Stores account number, transaction type (deposit/withdrawal/transfer), amount, and balance after transaction.

#### 🔷 `File_handling`

* Utility class for reading from and writing to files.
* Maintains persistent data for:

  * Users (`users.txt`)
  * Transactions (`transaction.txt`)

---

### ✅ **Data Flow Example:**

1. **User Chooses: Add Customer**

   * `Application.add_Customer()` is called.
   * Password is encrypted.
   * New Customer is added to `Map`.
   * Opening transaction is created.
   * Customer and transaction info are written to files.

2. **User Chooses: ATM Withdrawal**

   * Authentication is verified.
   * If balance is sufficient, amount is debited.
   * New withdrawal `Transaction` is created and stored.

3. **File Persistence**

   * On exit or command, all customers and transactions are written to files.
   * Can be reloaded anytime using `file_list()`.

---

### ✅ **Password Encryption Logic:**

Simple encryption:
Each character is incremented by 1 (e.g., `a → b`, `9 → 0`, `Z → A`)

Example:

```java
"Banking" → "Cboljoh"
```

---

<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/ca4c3051-2cd3-45cb-ba26-95d6688d93c5" />
---

---
