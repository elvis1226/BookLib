# BookLib
Simple library management system

# Requirement
1. Users (User) and Administrators (Admin) can register and log in to the system.
2. Users can view the list of books, borrow multiple books, and return these books.
3. Administrators have the authority to view the list of books, add books, delete
   books. If a book is already in the system and the administrator tries to add it
   again, the system should merge the inventory rather than create a new one. Also,
   administrators cannot delete books that are currently being borrowed by users.

# Environment
- JDK 22
- Maven 3.8.x

# Build
- mvn clean install

# Run
 
# Support Commands
- register admin <USER_NAME> <PASSWORD>
- register user <USER_NAME> <PASSWORD>
- login <USER_NAME> <PASSWORD>
- add <BOOK_NAME> <BOOK_INVENTORY>
- list
- search <BOOK_NAME>
- borrow <BOOK_NAME>
- return <BOOK_NAME>
- delete <BOOK_NAME>

# Log Screenshot
- Log_screenshot.jpg