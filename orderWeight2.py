from collections import defaultdict
from itertools import chain

def sum_digits(n):
  s = 0
  while n:
      s += n % 10
      n //= 10
  return s

def order_weight(strng):
  if not strng:
    return

  strList = strng.split()
  intList = list(map(int, strList))
  sumofDigitsDict = {}

  for i in intList:
    sumofDigitsDict[sum_digits(i)] = []

  for i in intList:
    sumofDigitsDict[sum_digits(i)].append(i)
  for x in sumofDigitsDict:
    sumofDigitsDict[x].sort(reverse=True)
  
  orderedTupleList = sorted(sumofDigitsDict.items() , key=lambda x: x[0])
  resultList = []
  for pair in orderedTupleList:
    resultList.append(pair[1])
  flat_list = [item for sublist in resultList for item in sublist]

  resultString = " ".join(str(x) for x in flat_list)
    
  return resultString
      
def main():
  myStr = "11 10003 1234000 44444444 9999 2000 11 22 123"
  print(order_weight(myStr))
  
  
if __name__== "__main__":
  main()

    
