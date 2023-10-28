public class FbNumbers {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FbNumbers <n>");
            System.exit(1);
        }

        try {
            int n = Integer.parseInt(args[0]);
            long result = computeFibonacci(n);
            System.out.println("Fibonacci(" + n + ") = " + result);
        } catch (NumberFormatException e) {
            System.err.println("Argument " + args[0] + " must be an integer.");
            System.exit(2);
        }
    }

    public static long computeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long fib1 = 0;
        long fib2 = 1;
        long fibonacci = 0;

        for (int i = 2; i <= n; i++) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }

        return fibonacci;
    }
}
