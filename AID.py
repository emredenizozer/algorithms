#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'findMatch' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING_ARRAY possibleMatches
#  2. STRING crossword
#

def findMatch(possibleMatches, crossword):
    sanitizedCrossword = crossword.replace('.', '').lower()
    sanitizedCrosswordIndexes = []
    result = ""
    found = True

    for i in range(len(crossword)):
        if crossword[i] != '.':
            sanitizedCrosswordIndexes.append(i)


    for item in possibleMatches:
        if len(crossword) == len(item):
            for i in range(len(sanitizedCrosswordIndexes)):
                if found and crossword[sanitizedCrosswordIndexes[i]] == item[sanitizedCrosswordIndexes[i]].lower():
                    continue;
                else:
                    found = False
                    break;
            if found:
                result = item.lower()
                break;
        else:
            continue
    return result

if __name__ == '__main__':
    possibleMatches = ["vaporeon", "jolteon", "espeon", "tolteon"]
    crossword = "...or..."
    result = findMatch(possibleMatches, crossword)
    crossword = "...eon"
    result = findMatch(possibleMatches, crossword)
    print(result)

'''

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    possibleMatches_count = int(input().strip())

    possibleMatches = []

    for _ in range(possibleMatches_count):
        possibleMatches_item = input()
        possibleMatches.append(possibleMatches_item)

    crossword = input()

    result = findMatch(possibleMatches, crossword)

    fptr.write(result + '\n')

    fptr.close()
'''