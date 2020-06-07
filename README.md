# Fixture Generator
Takes a list of teams and generates all weekly fixtures

### Sample Usage
Open `EntryPoint.kt` and increase team count to number of teams in your game. 
Only requirement is that number of teams must be even, then run the main method.

### Sample output for a 4 team game
```text
[
Week 1
[Team 1 vs Team 3, Team 4 vs Team 2]
, 
Week 2
[Team 3 vs Team 2, Team 1 vs Team 4]
, 
Week 3
[Team 4 vs Team 3, Team 2 vs Team 1]
]
```