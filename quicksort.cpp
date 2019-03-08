// programos pavadinimas
#include <iostream>
#include <iomanip>
#include <cmath>
#include <fstream>
#include <string>

using namespace std;

int * partitionQ(int A[], int p, int r);
void quickSort(int A[], int p, int r);


int main ()
{
    int test[8]= {4,4,4,4,4,4,4,4};

    quickSort(test, 0, 7);

    for(int i = 0; i < 8; i++){
        cout << i <<" : " << test[i] << endl;
    }

   return 0;
}



void quickSort(int A[], int p, int r) {
    if(p < r) {
        int *q;
        q = partitionQ(A, p, r);
        quickSort(A, p, (int)(*q) - 1);
        quickSort(A, (int)*(q + 1) + 1, r);
    }
}


int * partitionQ(int A[], int p, int r) {
    int x = A[r];
    int i = p - 1;
    int k = p - 1;

    for(int j = p; j < r; j++) {
        if(A[j] < x) {
            i++;
            k++;
            swap(A[j], A[i]);
        }
        else if(A[j] == x) {
            k++;
            swap(A[j], A[k]);
        }
    }

    swap(A[r], A[k + 1]);
    int equalPivot[2]= {(i+1), (k+1)};
    return equalPivot;
}
