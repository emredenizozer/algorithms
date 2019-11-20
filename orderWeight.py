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
  sumofDigitsPair = []

  for i in intList:
    myPair = (i, sum_digits(i))
    sumofDigitsPair.append(myPair)

  sumofDigitsList = sorted(sumofDigitsPair, key=lambda element: (element[0], element[1]))

  sumofDigitsListGroup = defaultdict(list)
  
  for val, key in sumofDigitsList:
    sumofDigitsListGroup[key].append(val)

  sumofDigitsListGroup = dict(sumofDigitsListGroup)
  
  for x in sumofDigitsListGroup:
    sumofDigitsListGroup[x].sort(reverse=True)
    
  sorted_sumofDigitsListGroup = sorted(sumofDigitsListGroup.items(), key=lambda x: x[0])
  
  resultDict = sorted(sorted_sumofDigitsListGroup, key=lambda x: x[0])
  
  resultList = []
  
  for x in resultDict:
      for y in x[1]:
        resultList.append(y)

  resultString = " ".join(str(x) for x in resultList)
    
  return resultString
      

def main():
  myStr1 = "2000 10003 1234000 44444444 9999 11 11 22 123"
  myStr2 = "12 54 8 19 39 5000 45 23 65 1 9 28 11 2000 11"
  print(order_weight(myStr2))
  
  
if __name__== "__main__":
  main()

    
