# Java's Scanner : our implementation

On France-IOI, we are using the gcj compiler to compile Java's source codes into executables.

We have our own implementation of the Java's Scanner.

* It fixes speed and memory usage problems (see below).
* It fixes some gcj's Scanner "bugs" (see below)
* It hasn't all the original functions

## Example of use
Exactly as you would use the original Java's Scanner :


    Scanner sc = new Scanner(System.in);
    int val = sc.nextInt()


## Supported functions

Original functions : 

    public boolean hasNext();
    public String next();
    public String nextLine();
    public int nextInt();
    public long nextLong();
    public float nextFloat();
    public double nextDouble();

Added functions :

    public char nextChar();

## Bugs fixed
Using `nextDouble()` to read the value `0` raises the error `ava.util.InputMismatchException: "0" is not a double`.

See http://stackoverflow.com/questions/9055788/java-scanner-0-is-not-a-double for more details.

Our Scanner fixes that

## Speed and memory usage
For this benchmark we are reading `N` integers on standard input, the most common usage in algorithmic contests.

      Comparison of Java's Scanner / our Scanner

      For 10 integers :
      Time : .07s vs .07s
      Memory : 25164K vs 20760K
      Ratios (time/mem) : 1.0 and 1.2

      For 5000 integers :
      Time : .26s vs .08s
      Memory : 30036K vs 21596K
      Ratios (time/mem) : 3.2 and 1.3

      For 10000 integers :
      Time : .44s vs .06s
      Memory : 30956K vs 22380K
      Ratios (time/mem) : 7.3 and 1.3

      For 25000 integers :
      Time : 1.02s vs .07s
      Memory : 34464K vs 23704K
      Ratios (time/mem) : 14.5 and 1.4

      For 50000 integers :
      Time : 1.97s vs .11s
      Memory : 39596K vs 25788K
      Ratios (time/mem) : 17.9 and 1.5

      For 75000 integers :
      Time : 2.93s vs .20s
      Memory : 44988K vs 26060K
      Ratios (time/mem) : 14.6 and 1.7

      For 100000 integers :
      Time : 3.85s vs .23s
      Memory : 50456K vs 26056K
      Ratios (time/mem) : 16.7 and 1.9

      For 150000 integers :
      Time : 5.68s vs .27s
      Memory : 60648K vs 26060K
      Ratios (time/mem) : 21.0 and 2.3

      For 200000 integers :
      Time : 6.86s vs .37s
      Memory : 75148K vs 26320K
      Ratios (time/mem) : 18.5 and 2.8


