import java.util.Scanner;

class crc {
    void div(int[] a, int k) {
        int[] gp = {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
        int gpLength = gp.length;
        
        for (int i = 0; i <= k; i++) {
            if (a[i] == 1) {
                for (int j = 0; j < gpLength; j++) {
                    a[i + j] = a[i + j] ^ gp[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[100];
        int len, k;
        crc ob = new crc();

        System.out.println("Enter the length of Data Frame:");
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();

        System.out.println("Enter the Message:");
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }

       
        for (int i = 0; i < 16; i++) {
            a[len + i] = 0;
        }
        k = len;
        len += 16;

        for (int i = 0; i < len; i++) {
            b[i] = a[i];
        }

        ob.div(a, k);

        
        for (int i = 0; i < len; i++) {
            a[i] = a[i] ^ b[i];
        }

        System.out.println("Data to be transmitted:");
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("Enter the Received Data:");
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }

        ob.div(a, k);

        boolean errorDetected = false;
        for (int i = k; i < len; i++) {
            if (a[i] != 0) {
                errorDetected = true;
                break;
            }
        }

        if (errorDetected) {
            System.out.println("ERROR in Received data");
        } else {
            System.out.println("No error");
        }

        sc.close();
    }
}
