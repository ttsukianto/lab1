Programming Assignment #1
Thea Sukianto

GITHUB: 
https://github.com/ttsukianto/lab1

DESCRIPTION:
Implementation of a cache (one-level and two-level options) in Java using LinkedList.
When a data item is found (cache hit), it is moved to the top of the cache and returned.
When a data item is not found (cache miss), it is added to the top of the cache and returned.
A 2nd-level cache contains all data in the 1st-level cache (multilevel inclusion property).
The Test program outputs the global/1st-level/2nd-level references, cache hits, and cache hit ratio.

INSTALLATION:
Use the following commands to compile within the lab1 folder:

javac Test.java
javac Cache.java

USAGE:
For a one-level cache, use the following command:

java Test 1 <cache size> <input textfile name>

For a two-level cache, use the following command:

java Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>

REPORT:
Admittedly, this project was a little difficult to implement at first because I had not programmed in Java
for a few years (since CS 221 in Fall 2018). Therefore, most of the bugs/issues I encountered were syntax-related.
I am used to programming in R and Python, so I would forget semicolons and use the wrong case for booleans. I used 
the supplied small.txt and Encyclopedia.txt files for testing. Surprisingly, after fixing the syntax errors, my
test output for small.txt matched the expected output, so it appeared that my logic was correct. My test output
for Encyclopedia.txt differs with the expected by 1 or 2 hits, but this could be due to delimiter differences.
The runtime for a two-level cache with sizes 1000 and 2000 on Encyclopedia.txt was 21162ms. Since my first 
solution attempt seemed to yield the desired results, I ended up only pushing to GitHub three times (solution 
attempt, runtime counter, and README). For the next project, I will try to update GitHub incrementally through 
the development process instead of once per solution attempt.
