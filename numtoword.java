import java.util.*;

public class numtoword {
    int num;
    String f = "";
    int i, j, d, k, e, g, h, z;
    int n[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    String word[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty" };
    int m[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
    String wrd[] = { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty" };

    numtoword(int nn) {
        num = nn;
    }

    String onedigit(int x) {
        f = "";
        if (x > 0 && x < 21) {

            if (x >= 0 && x < 21) {
                for (i = 0; i < n.length; i++) {
                    if (x == n[i]) {
                        f = word[i];
                    }
                }
            }
        }
        return f.toUpperCase();
    }

    String twodigit(int p) {
        f = "";
        if (p > 20 && p < 100) {
            d = p % 10;
            p = p / 10;
            p = p * 10;
            num = d;
            for (j = 0; j < m.length; j++) {

                if (p == m[j]) {
                    f = wrd[j] + " ";
                    break;
                }
            }
        }
        return f.toUpperCase();
    }

    String threedigit(int r) {
        f = "";
        if (r > 99 && r <= 999) {
            e = r / 100;
            num = r % 100;
            r = r / 100;
            for (k = 0; k < n.length; k++) {
                if (e == n[k])
                    f = word[k] + " hundred ";
            }
        }
        return f.toUpperCase();
    }

    String fourdigit(int s) {
        f = "";
        if (s > 999 && s <= 20000) {
            g = s / 1000;
            f = onedigit(g) + " thousand ";
        } else if (s >= 20000 && s < 100000) {
            g = s / 1000;
            f = onedigit(g) + twodigit(g) + onedigit(g % 10) + " thousand ";
        }
        num = s % 1000;
        return f.toUpperCase();
    }

    String lakhdigit(int t) {
        f = "";
        if (t > 99999 && t <= 2000000) {
            h = t / 100000;
            f = onedigit(h) + " lakh ";
        } else if (t >= 2000000 && t < 10000000) {
            h = t / 100000;
            f = onedigit(h) + twodigit(h) + onedigit(h % 10) + " lakh ";
        }
        num = t % 100000;
        return f.toUpperCase();
    }

    String croredigit(int u) {
        f = "";
        if (u > 9999999 && u <= 200000000) {
            z = u / 10000000;
            f = onedigit(z) + " crore ";
        } else if (u >= 200000000 && u < 1000000000) {
            z = u / 10000000;
            f = onedigit(z) + twodigit(z) + onedigit(z % 10) + " crore ";
        }

        num = u % 10000000;
        return f.toUpperCase();
    }

    void display() {
        System.out.println(
                croredigit(num) + lakhdigit(num) + fourdigit(num) + threedigit(num) + twodigit(num) + onedigit(num));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int q = sc.nextInt();

        String n = Integer.toString(q);
        int len = n.length();
        numtoword obj = new numtoword(q);
        if (q >= 0 && q <= 20) {
            System.out.println(obj.onedigit(q));
            System.exit(0);
        }
        obj.display();
    }
}