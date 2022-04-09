# Glided-Rose

Below I will detail my approach to solving this assessment and the thinking behind it:

### Approach to solving the problem
1. Understand the code and additional requirements of the assessment
   - The importance of the above is that it allowed me to identify duplicate code - code smell. This then allowed to extract this code into functions.
3. Add Test cases
   - I added tests before refactoring to increase confidence no existing functionality was broken.
   - Adding tests also allows you to have short feedback loops, with the accuracy of your refactor. Further increasing your productivity.
4. The Refactor
   - I used small incremental steps in the refactor. This allowed me to identify similar code patterns, and implement structure with each step. Reverting changes becomes easier.
   - Common references e.g. name of an item were moved into Constants.
   - I refactored code from AS Lint suggestions e.g replacing "equals()" with "==".
   - I removed the for loop using "indices" and rather referenced the "item" itself. This allowed me to move away from assessing the array using index notation .e.g items[I].name —> it.name
   - I replaced the top-level "if()" statement with a "when()" function. This further simplifies identifying to level conditionals statements.

### Test Coverage
See below screenshot of the coverage stats:

 
![Screenshot 2022-04-08 at 11 15 22](https://user-images.githubusercontent.com/1165257/162577504-0bb4ec3f-c472-4a6b-9401-a2ca39998cd7.png)
