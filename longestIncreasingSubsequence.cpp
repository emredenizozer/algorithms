#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int longestCommonSubsequenceRecursiveHelper(vector<int> sequence, int pos, int lastNum)
{
    if (pos == sequence.size())
    {
        return 0;
    }
    int firstSum = 0;
    if (lastNum < sequence[pos])
    {
        firstSum = 1 + longestCommonSubsequenceRecursiveHelper(sequence, pos + 1, sequence[pos]);
    }
    int secondSum = longestCommonSubsequenceRecursiveHelper(sequence, pos + 1, lastNum);
    return max(firstSum, secondSum);
}

int longestCommonSubsequenceRecursive(vector<int> sequence)
{
    int seqSize = sequence.size();
    int maxLen = 0;
    for (int i = 0; i < seqSize - 1; i++)
    {
        int len = longestCommonSubsequenceRecursiveHelper(sequence, i + 1, sequence[i]);
        if (len > maxLen)
        {
            maxLen = len;
        }
    }
    return maxLen + 1;
}

int longestCommonSubsequence(vector<int> sequence)
{
    vector<int> totalSum(sequence.size(), 1);
    vector<int> location(sequence.size(), -1);
    int seqSize = sequence.size();
    int maxIndex = 0;

    for (int i = 1; i < seqSize; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (sequence[j] < sequence[i])
            {
                totalSum[i] = max(totalSum[j] + 1, totalSum[i]);
                location[i] = j;
                if (totalSum[i] > totalSum[maxIndex])
                {
                    maxIndex = i;
                }
            }
        }
    }

    int total = totalSum[maxIndex];
    int idx = maxIndex;

    cout << "Longest sequence is: ";
    while (total--)
    {
        cout << sequence[idx] << " ";
        idx = location[idx];
    }

    cout << endl;

    return totalSum[maxIndex];
}

int main()
{
    vector<int> input = {3, 4, -1, 0, 6, 2, 3, 4};
    cout << "Maximum subsequence length: " << longestCommonSubsequence(input) << endl;
    cout << "Maximum subsequence length using recursion: " << longestCommonSubsequenceRecursive(input) << endl;

    return 0;
}
