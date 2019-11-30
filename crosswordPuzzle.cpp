#include <bits/stdc++.h> 
using namespace std; 

int ways = 0; 

void printMatrix(vector<string>& matrix, int n) 
{ 
    for (int i = 0; i < n; i++) 
        cout << matrix[i] << endl; 
}

vector<string> splitWord(const string &s, char delim) {
    vector<string> result;
    stringstream ss (s);
    string item;

    while (getline (ss, item, delim)) {
        result.push_back (item);
    }

    return result;
}
 
vector<string> checkHorizontal(int x, int y, 
                               vector<string> matrix, 
                               string currentWord) 
{ 
    int n = currentWord.length(); 
  
    for (int i = 0; i < n; i++) { 
        if (matrix[x][y + i] == '-' ||  
            matrix[x][y + i] == currentWord[i]) { 
            matrix[x][y + i] = currentWord[i]; 
        } 
        else { 
  
            // this shows that word cannot  
            // be placed horizontally 
            matrix[0][0] = '@'; 
            return matrix; 
        } 
    } 
  
    return matrix; 
} 

vector<string> checkVertical(int x, int y, 
                             vector<string> matrix, 
                             string currentWord) 
{ 
    int n = currentWord.length(); 
  
    for (int i = 0; i < n; i++) { 
        if (matrix[x + i][y] == '-' ||  
            matrix[x + i][y] == currentWord[i]) { 
            matrix[x + i][y] = currentWord[i]; 
        } 
        else {
            matrix[0][0] = '@'; 
            return matrix; 
        }
    }
    return matrix; 
}

void solvePuzzle(vector<string>& words, 
                 vector<string> matrix, 
                 int index, int n) 
{ 
    if (index < words.size()) { 
        string currentWord = words[index]; 
        int maxLen = n - currentWord.length(); 
  
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j <= maxLen; j++) { 
                vector<string> temp = checkVertical(j, i, 
                                        matrix, currentWord);
  
                if (temp[0][0] != '@') { 
                    solvePuzzle(words, temp, index + 1, n); 
                } 
            }
        } 
  
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j <= maxLen; j++) { 
                vector<string> temp = checkHorizontal(i, j, 
                                      matrix, currentWord); 
  
                if (temp[0][0] != '@') { 
                    solvePuzzle(words, temp, index + 1, n); 
                } 
            } 
        } 
    } 
    else { 
        // calling of print function to 
        // print the crossword puzzle 
        // cout << (ways + 1) << " way to solve the puzzle "<< endl; 
        printMatrix(matrix, n); 
        // cout << endl; 
        
        ways++; 
        return; 
    } 
} 
  
// Driver Code 
int main() 
{
    int matrixLength = 10;
    string inputString;
    vector<string> matrix;
    vector<string> words;
  
    for (int i = 0; i < matrixLength; i++)
    {
        cin>>inputString;
        matrix.push_back(inputString);
    }

    cin>>inputString;
    words = splitWord(inputString, ';'); 
  
    // initialize the number of ways 
    // to solve the puzzle to zero 
    ways = 0; 
  
    // recursive function to solve the puzzle 
    // Here 0 is the initial index of words array 
    // n1 is length of grid 
    solvePuzzle(words, matrix, 0, matrixLength); 
    // cout << "Number of ways to fill the grid is "<< ways << endl; 
  
    return 0; 
}

/*

"++++++++++"
"+------+++"
"+++-++++++"
"+++-++++++"
"+++-----++"
"+++-++-+++"
"++++++-+++"
"++++++-+++"
"++++++-+++"
"++++++++++"




"*-********"
"*-****-***"
"*--***--**"
"*-****-***"
"*-****-***"
"*-****-***"
"*-*------*"
"*-********"
"***-------"
"PUNJAB;JHARKHAND;MIZORAM;MUMBAI"


++++++++++
+------+++
+++-++++++
+++-++++++
+++-----++
+++-++-+++
++++++-+++
++++++-+++
++++++-+++
++++++++++
POLAND;LHASA;SPAIN;INDIA




*/