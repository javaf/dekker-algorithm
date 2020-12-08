Dekker's algorithm is the **first known** correct solution
to the **mutual exclusion** problem in concurrent
programming. The solution is attributed to Dutch
mathematician **Th. J. Dekker** by Edsger W. Dijkstra.
It allows two threads to share a single-use resource
without conflict, *using only shared memory for*
*communication*.

Java already provides a `ReentrantLock`. This is for
educational purposes only.

```java
process(i):
1. I want to enter CS.
2. If you want CS too  ...
3a. If its my turn, retry 2.
4a. If its your turn, i dont want to enter.
4b. I wait for you turn to complete.
4c. I now want to enter, retry 2.
5. I enter CS (sleep).
6. Its your turn now.
7. I dont want CS.
```

See [Main.java] for code, and [repl.it] for output.

[Main.java]: https://repl.it/@wolfram77/dekker-algorithm#Main.java
[repl.it]: https://dekker-algorithm.wolfram77.repl.run


### references

- [Computer Architecture - Dekker's Algorithm :: 
intrigano](https://www.youtube.com/watch?v=dPa9414uyYE)
- [Dekker's algorithm in Process Synchronization :: GeeksforGeeks](https://www.geeksforgeeks.org/dekkers-algorithm-in-process-synchronization/)
- [Dekker's algorithm](https://en.wikipedia.org/wiki/Dekker%27s_algorithm)
