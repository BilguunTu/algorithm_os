package labFive.example;

public class example {

public static int example1(int[ ] arr) {

int n = arr.length, total = 0;

for (int j=0; j < n; j++) // loop from 0 to n-1

total += arr[j];

   return total;

}


public static int example2(int[ ] arr) {

int n = arr.length, total = 0;

for (int j=0; j < n; j += 2) // note the increment of 2

total += arr[j];

return total;

}

 


public static int example3(int[ ] arr) {

int n = arr.length, total = 0;

for (int j=0; j < n; j++)  // loop from 0 to n-1

for (int k=0; k <= j; k++) // loop from 0 to j

total += arr[j];

return total;

}


public static int example4(int[ ] arr) {

int n = arr.length, prefix = 0, total = 0;

for (int j=0; j < n; j++) {  // loop from 0 to n-1

prefix += arr[j];

total += prefix;

}

return total;

}

public static int example5(int[ ] first, int[ ] second) { // assume equal-length arrays

int n = first.length, count = 0;

for (int i=0; i < n; i++) {   // loop from 0 to n-1

int total = 0;

for (int j=0; j < n; j++)  // loop from 0 to n-1

for (int k=0; k <= j; k++) // loop from 0 to j

total += first[k];

if (second[i] == total) count++;

}

return count;

}
  
}
