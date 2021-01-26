import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    private static Cache cache;
    private static String filename;

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();

        if(Integer.parseInt(args[0]) == 1) {
            cache = new Cache(Integer.parseInt(args[1]));
            System.out.println("First level cache with " + args[1] + " entries has been created\n");
            filename = args[2];
        }
        else if(Integer.parseInt(args[0]) == 2) {
            cache = new Cache(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            System.out.println("First level cache with " + args[1] + " entries has been created");
            System.out.println("Second level cache with " + args[2] + " entries has been created\n");
            filename = args[3];
        }
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine()) {
            Scanner wordScanner = new Scanner(scanner.nextLine());
            while(wordScanner.hasNext()) {
                String word = wordScanner.next();
                if(Integer.parseInt(args[0]) == 1) {
                    cache.getObject(word, false);
                }
                else if(Integer.parseInt(args[0]) == 2) {
                    cache.getObject(word, true);
                }
            }
        }
        double ref1 = cache.getRefs(1);
        double hit1 = cache.getHits(1);
        double hitRatio1 = hit1/ref1;

        if(Integer.parseInt(args[0]) == 1) {
            System.out.println("\nThe number of 1st-level references: " + ref1);
            System.out.println("The number of 1st-level cache hits: " + hit1);
            System.out.println("The 1st-level cache hit ratio: " + hitRatio1);
        }
        else if(Integer.parseInt(args[0]) == 2) {
            double ref2 = cache.getRefs(2);
            double hit2 = cache.getHits(2);
            double hitRatio2 = hit2/ref2;
            double hitRatioGlobal = (hit1+hit2)/ref1;

            System.out.println("\nThe number of global references: " + ref1);
            System.out.println("The number of global cache hits: " + (hit1+hit2));
            System.out.println("The global hit ratio: " + hitRatioGlobal);

            System.out.println("\nThe number of 1st-level references: " + ref1);
            System.out.println("The number of 1st-level cache hits: " + hit1);
            System.out.println("The 1st-level cache hit ratio: " + hitRatio1);

            System.out.println("\nThe number of 2nd-level references: " + ref2);
            System.out.println("The number of 2nd-level cache hits: " + hit2);
            System.out.println("The 2nd-level cache hit ratio: " + hitRatio2);
        }

        long end = System.currentTimeMillis();

        System.out.println("\nRuntime in ms: " + (end-start));

    }
}