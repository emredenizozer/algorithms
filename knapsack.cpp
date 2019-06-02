#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int w, n;

    cin>>w>>n;
    vector<int> weigths(n);
    vector<int> values(n);
    vector<vector<int> > knapsack(n, vector<int>(w+1));

    cout<<"Enter weights:"<<endl;
    int item;
    for (int i=0 ; i < n; i++){
        cin>>item;
        weigths[i] = item;
    }
    
    cout<<"Enter values:"<<endl;

    for (int i=0 ; i < n; i++){
        cin>>item;
        values[i]=item;
    }

    /*
    for (auto &weigth : weigths){
        cout<<weigth<<" ";
    }

    cout<<endl;

    for (auto &value : values){
        cout<<value<<" ";
    }
    */

   for(int i=0; i < n; i++) {
       for (int j = 0; j < w+1; j++)
       {
           if (weigths[i] > j && i > 0) {
               knapsack[i][j] = knapsack[i-1][j];
           }
           else if(weigths[i] <= j && i == 0) {
               knapsack[i][j] = values[i];
           }
           else if(weigths[i] <= j && i > 0) {
               knapsack[i][j] = max(values[i] + knapsack[i-1][j-weigths[i]], knapsack[i-1][j]);
           }

       }
   }

/*
   for ( int i = 0 ; i < n ; i++ )
    {
        for ( int j = 0 ; j < w+1 ; j++ )
        {
            cout<<knapsack[i][j]<< " ";
        }
        cout<<endl;
    }
*/

    cout<<"Max value is: "<<knapsack[n-1][w]<<endl;

     cout<<"Item weights inside the knapsack: "<<endl;

    int res = knapsack[n-1][w];
    int printItemIndex = w;

    for (int i = n; i > 0, res > 0; i--)
    {
        if (res == knapsack[i-1][printItemIndex])
            continue;
        
        else {
            cout<<weigths[i]<<" ";
            printItemIndex -= weigths[i];
            res -= values[i];
        }
        
    }
    
    cout<<endl;


}
    
    