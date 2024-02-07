Based on your request, I'll design an exercise that matches the complexity and learning objectives of your example. The scenario will involve a library management system with a focus on object-oriented programming (OOP) principles.

### Exercise: Library Management System

**Scenario**: A public library needs a system to manage books and patrons. Books can be borrowed by patrons, who must return them within a set period. The system tracks which books are available, which are borrowed, and by whom. The library categorizes books as either fiction or non-fiction, and patrons can search for books by category or borrow them based on availability. A book can be reserved if it's currently borrowed, with the reservation going to the first requester.

**Objective**: Create the necessary classes to implement the system and the operations for:
- Adding a book to the library inventory,
- Borrowing a book from the library (by book ID),
- Returning a book to the library,
- Searching for books by category (fiction or non-fiction),
- Reserving a borrowed book, with reservations managed in a first-come, first-served basis,
- Viewing the most recent book added to the library without borrowing it,
- Viewing the details of the currently borrowed books, including borrower information.

Each book should have a unique identifier, title, author, and category (fiction or non-fiction). Patrons should have a name and an ID. To track books and reservations efficiently, consider using appropriate data structures.

**Input Format**:
- `add book_id title author category` (category is either fiction or non-fiction)
- `borrow patron_id book_id`
- `return book_id`
- `search category`
- `reserve patron_id book_id`
- `view_latest`
- `view_borrowed`

**Constraints**:
- Handle exceptional situations gracefully (e.g., attempting to borrow a book that is not available, reserving a book that doesn't exist).
- For maximum points, the program should be easy to understand and extend. Consider future requirements like adding more categories, changing loan periods, or adding new types of library items.

**Output Format**:
- Upon borrowing, returning, or reserving a book: confirmation message with book and patron details.
- When searching: list of available books in the requested category.
- `view_latest` and `view_borrowed` should display relevant book details.

**Sample Input**:
```
add 001 "The Great Gatsby" "F. Scott Fitzgerald" fiction
add 002 "A Brief History of Time" "Stephen Hawking" non-fiction
borrow 1001 001
view_latest
return 001
search fiction
```

**Sample Output**:
```
Book added: The Great Gatsby, F. Scott Fitzgerald, fiction
Book borrowed: The Great Gatsby by patron 1001
Latest book: A Brief History of Time, Stephen Hawking, non-fiction
Book returned: The Great Gatsby
Available fiction books: The Great Gatsby
```

This exercise challenges students to apply OOP principles to manage relationships between objects, handle dynamic data structures, and ensure the system is both scalable and easy to maintain.