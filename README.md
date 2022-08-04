
# Code Sharing Platform

Implementation of a "challenging" task from hyperskill.org Java Backend Developer course.

4/5 stages complete.





GET /api/code/N  returns JSON with the N-th uploaded code snippet.

GET /code/N  returns HTML that contains the N-th uploaded code snippet.

POST /api/code/new  takes a JSON object with a single field code, uses it as the current code snippet, and return JSON with a single field id. 

GET /code/new shows a textarea, where you can paste the code and a single button "Submit"

GET /api/code/latest returns a JSON array with 10 most recently uploaded code snippets sorted from the newest to the oldest.

GET /code/latest returns HTML that contains 10 most recently uploaded code snippets. 


