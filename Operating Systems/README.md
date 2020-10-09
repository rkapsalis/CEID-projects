## Commands
**1)  ./tool.sh -f <file>** 
  
      Shows file contents
 
**2)  ./tool.sh -f <file> -id <id>**
  
      Shows user's name, surname and date of birth with the specified id, separated by a single space.
      (e.g. $ ./tool.sh -f persons.dat -id 10995116283604 will show Gilels Viktor 1982-04-18)
 
**3i.) ./tool.sh --firstnames -f <file>**
      
      Shows all distinct first names (firstname field) contained in the file, in alphabetical order, one per line.
**3ii.)  ./tool.sh --lastnames -f <file>**  
  
      Shows all distinct last names (lastname field) contained in the file, in alphabetical order, one per line.
     
  
**4)  ./tool.sh --born-since <dateA> --born-until <dateB> -f <file>**
     
      Shows only the rows that correspond to users born from dateA to dateB. Either may be given
  
**5)  ./tool.sh --socialmedia -f <file>**
  
     Shows all social media used by users, in alphabetical order, and next to the name of the social media the number of users who have used it (with
     exactly one space to seperate).
  
**6)  ./tool.sh -f <file> --edit <id> <column> <value>**
  
     Modifies the file. In particular, for the user with an <id> code, it will replace the column <column> with <value>. If there is no user with this id, or
     column is not among acceptable columns 2 to 8 (column 1 corresponding to the same id is not allowed to be modified), this command will change nothing.
  
## Authors
* Romanos Kapsalis
* Stylianos Vazaios
