# Mars Rovers

Implements Mars Rovers Kata in Java using TDD approach.

Start with NASA class. It receives a Plateau and instructions for rovers.
It's independent of the input method.

Bootstrap class is to setup the application and it expects a file where input is written.

## Assumptions
* Rovers cannot move off the plateau. In such a case, rover stops moving and further commands are not sent.
* Multiple rovers can be at the same cell. No obstacle detection.
* Input is correct. 