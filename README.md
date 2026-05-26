# Minesweeper
This is an APCSA 2025-2026 Spring final project
@author @white393939
5/18/2026
https://github.com/white393939/

ths is a standered minesweeper game

Example of characters:
"▣" : Unknown square
"□" : Empty square
"*" : mine
"⚑" : flaged square
"1" : square with 1 mine within 3*3 range

input two integers on the first run for the grid size(cannot be less then 4*4)
then input the coordinates of the square as labled in row column format to sweep it
coordinates starts at 0.
Ex: "5 3" is the square at row 5, column 3, but is at the 6th row and 4th column

input "f" to toggle flag mode
then input coordinates to flag a square
flag mode is not active by defult
flag mode cannot be entered on the first sweep(before any square is shown).

a valid square is a square that is within the bounds of the grid
and is not already sweeped or flagged.