Two processes use a respective variable to indicate that they want to enter a critical section. However using just that could lead to a deadlock. So they use a tie-breaker "turn" to indicate whose turn it is to wait. So, each process says it wants to enter CS but also that it is its turn to wait. In the end, a process only waits if the other process wants to enter CS as well as it is its own turn to wait. This tie-breaker prevents deadlock.

```java
Process 1:
1. I want to enter CS (c1=1)
2. Its my turn to wait (turn=1)
3. I wait if you want too and my wait turn
4. I enter CS (sleep random)
5. I dont want to enter CS (c1=0)
```

```java
Process 2:
1. I want to enter CS (c2=1)
2. Its my turn to wait (turn=2)
3. I wait if you want too and my wait turn
4. I enter CS (sleep random)
5. I dont want to enter CS (c2=0)
```

See [Main.java] for code, and [repl.it] for output.

[Main.java]: https://repl.it/@wolfram77/dekkers-algorithm#Main.java
[repl.it]: https://dekkers-algorithm.wolfram77.repl.run


### references

- [Computer Architecture - Dekker's Algorithm :: 
intrigano](https://www.youtube.com/watch?v=dPa9414uyYE)
