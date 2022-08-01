Code Refactoring Changes

- Eliminate unnecessary import statements across files
  - Went through User, UserService, UserController, UserRepository, and UserServiceImpl and eliminated any unused import statements.
- Get rid of unused getters and setters
  -  {TBD}
- Add comments and documentation on existing code
  - Went back and added nonexistent documentation in the files: User, UserService, UserServiceImpl, UserController, and user Repository.
- Fix bloating of controller class
  - To fix the bloating of the controller class (UserController), we have now created the ApplicationController and other MVC related items to handle all actions of the application object. 
  - In addition, we have also migrated the original UI navigation that handles the application use case navigation to the ApplicationController. 
- Branch history fix
  - Branch history error has been fixed. New working branch titled 'working_branch' has been set to the main branch. 
- Fix button declaration 
- Get rid of assigned objects that are never accessed 
- Removed the "center" HTML tags and replaced it with updated "style" tag.
