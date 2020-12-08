// Dekker's algorithm is the first known correct solution
// to the mutual exclusion problem in concurrent
// programming. The solution is attributed to Dutch
// mathematician Th. J. Dekker by Edsger W. Dijkstra.
// It allows two threads to share a single-use resource
// without conflict, using only shared memory for
// communication.

class Main {
  static boolean[] flag = {false, false};
  static int turn = 0;
  static int N = 4;
  // flag: ith process wants to enter CS?
  // turn: whose turn to enter CS
  // N: number of loops


  // 1. I want to enter CS.
  // 2. If you want CS too  ...
  // 3a. If its my turn, retry 2.
  // 4a. If its your turn, i dont want to enter.
  // 4b. I wait for you turn to complete.
  // 4c. I now want to enter, retry 2.
  // 5. I enter CS (sleep).
  // 6. Its your turn now.
  // 7. I dont want CS.
  static Thread process(int i) {
    return new Thread(() -> {
      int j = 1 - i;
      for (int n=0; n<N; n++) {
        log(i+": want CS"); // LOCK
        flag[i] = true;   // 1
        while (flag[j]) { // 2
          if (turn == i) { Thread.yield(); continue; } // 3a
          flag[i] = false;      // 4a
          while (turn == j) Thread.yield(); // 4b
          flag[i] = true; // 4c
        }
        
        log(i+": in CS"+n);
        sleep(1000 * Math.random()); // 5

        log(i+": done CS"); // UNLOCK
        turn = j;        // 6
        flag[i] = false; // 7
      }
    });
  }


  public static void main(String[] args) {
    try {
    log("Starting 2 processes (threads) ...");
    Thread p0 = process(0);
    Thread p1 = process(1);
    p0.start();
    p1.start();
    p0.join();
    p1.join();
    }
    catch (InterruptedException e) {}
  }

  static void sleep(double t) {
    try { Thread.sleep((long)t); }
    catch (InterruptedException e) {}
  }

  static void log(String x) {
    System.out.println(x);
  }
}
