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
- register admin Alice password1
- register user Bob password2
- login Alice password1
- add "Clean Code" "Robert C. Martin" 5
- list
- search "Clean Code" " Robert C. Martin"
- borrow "Clean Code" " Robert C. Martin"
- return "Clean Code" " Robert C. Martin"
- delete "Clean Code" " Robert C. Martin"