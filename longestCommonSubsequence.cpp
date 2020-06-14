#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

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
    vector<int> input = {3, 4, -1, 0, 6, 2, 3};
    cout << "Maximum subsequence length: " << longestCommonSubsequence(input) << endl;

    return 0;
}
