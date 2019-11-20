#include<bits/stdc++.h>
using namespace std;

void print2largest(int arr[], int arr_size) 
{ 
    int i, first, second; 
  
    /* There should be atleast two elements */
    if (arr_size < 2) 
    { 
        cout<<"Invalid Input"<<endl; 
        return; 
    } 
  
    first = second = INT_MIN; 
    
    for (int i=0; i<arr_size; i++) {
        if (arr[i] > first) {
            second = first;
            first = arr[i];
        }
        else if (arr[i] < first && second < arr[i]) {
            second = arr[i];
        }
    }

    if (second == INT_MIN) 
        cout<<"There is no second largest element"<<endl;  
    else
        cout<<"The second largest element is "<<second<<endl; 
} 
  
/* Driver program to test above function */
int main() 
{ 
    int arr[] = {12, 35, 1, 10, 34, 1}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
    print2largest(arr, n); 
    return 0; 
} 