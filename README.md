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
In our benchmarks we are reading `N` integers on standard input.

The memory is the memory used after initialisation.

      For 1000 integers :
      Elapsed time : 	.10s vs .05s
      Max memory : 	1K vs 1K
      Ratios (time/mem) : 2.0 and 1.0

      For 10000 integers :
      Elapsed time : 	.42s vs .06s
      Max memory : 	4977K vs 5K
      Ratios (time/mem) : 7.0 and 995.4

      For 25000 integers :
      Elapsed time : 	.99s vs .08s
      Max memory : 	8477K vs 505K
      Ratios (time/mem) : 12.3 and 16.7

      For 50000 integers :
      Elapsed time : 	2.16s vs .14s
      Max memory : 	13613K vs 5029K
      Ratios (time/mem) : 15.4 and 2.7

      For 75000 integers :
      Elapsed time : 	3.59s vs .22s
      Max memory : 	19269K vs 5297K
      Ratios (time/mem) : 16.3 and 3.6

      For 100000 integers :
      Elapsed time : 	4.01s vs .19s
      Max memory : 	24141K vs 5293K
      Ratios (time/mem) : 21.1 and 4.5

      For 150000 integers :
      Elapsed time : 	5.73s vs .30s
      Max memory : 	34673K vs 5293K
      Ratios (time/mem) : 19.1 and 6.5

      For 200000 integers :
      Elapsed time : 	8.86s vs .34s
      Max memory : 	49161K vs 5301K
      Ratios (time/mem) : 26.0 and 9.2


