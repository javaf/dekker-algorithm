import java.util.concurrent.*;

class Main {
  static int c1, c2;
  static int turn;

  static void process1() {
    new Thread(() -> {
      try {
      while(true) {
        c1 = 1;
        turn = 1;
        log("1: waiting");
        while(c2==1 && turn==1) Thread.sleep(10);
        log("1: enter critical section");
        Thread.sleep((long)(Math.random()*1000));
        log("1: exits critical section");
        c1 = 0;
      }
      }
      catch(InterruptedException e) {}
    }).start();
  }

  static void process2() {
    new Thread(() -> {
      try {
      while(true) {
        c2 = 1;
        turn = 2;
        log("2: waiting");
        while(c1==1 && turn==2) Thread.sleep(10);
        log("2: enter critical section");
        Thread.sleep((long)(Math.random()*1000));
        log("2: exits critical section");
        c2 = 0;
      }
      }
      catch(InterruptedException e) {}
    }).start();
  }

  public static void main(String[] args) {
    process1();
    process2();
  }
  static void log(String x) {
    System.out.println(x);
  }
}