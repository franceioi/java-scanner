# Java's Scanner : our implementation

We have our own implementation of the Java's Scanner.

* It fixes speed and memory usage problems.
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
