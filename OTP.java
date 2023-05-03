package TEST;

import java.util.Scanner;

public class OTP {

    static final String[] MSGS
            = {"AD8FBFEA27BD782D4E4F56A3E161393B9801FEB8F50625C6D88F64CAF2047564AD183F2394411F874C2D265DBDEB865A38DD1D66DC75BFF529E549DCB09312C412AC16E097A82C24A2F9906E489A5C9CD375F1064F29AA9028D791779F03BA05F6C30ED03EC5F4EACBFEC7172B826A08858E9A746659E6CFE89823C1F88BECD84C1886BF742EA52120761AA4DDECA1774FBF2A634BB69D77D58C474373E11D77BFAC6313CE7702A102F98E40A2C1986F7CD839021202FEFA4FDC1C6DC81EE7B4683720B061C30EC06DE285FF2EBCA3625E9F208205F62A0A6B15FCBC1491988A4402AB58472494BBBDD420BD580079761348D0BEC721E6",
                "898FBAEA3CF8637D44554EA3EB737772974DE1B6A11A388399956883E850216CB4153F3A935051C659353204A0AE815B38C41062927EB4E131A059C7FF8E14D948AC28EB97A83628E7FFD1794CDD4692D07EB5524537FED16FD69A618405A040F48C159E7F96EBE8DDAACD032B822F1ECD8A87733216E386FB952ECCBD88FACF085D86AD7F69A92F323319E8DAF8A632",
                "8D8FBFEA27BD782D4E4F56A3E16139269E44B2B4EE1C3FC6DA8E6D87F41E756FA313726D94531FC467282241A5A28A583A87554B9360BFF038B70AD9B08814815DE225A5DAB32C28E7EDD57557D651DDC462B4525938BDDB6FD39176CD16A712F78747D17896EEF4C7B0CF517F9E674DD6829862320AF0CBFC912A98AC9BE7C908579CBB6869B12E233306F2DAEBF53641B86374",
                "9685EDEE26F1313653554CA3FC7A7C728352E7B8ED4F2189D28473CAFA123A7CB8416B259E1518B5077A2E4AEEECAD504C8E55708876B4E234AB4D94B99503811BDF24E6C2AE3739BEBA9E3A6ECE138E8578B0004E3DA7902E928C778E10AB14B2970FDF6A96E8E2CDABDA187F8F2204CBC3906A701CF5C2E9996FD9B69ABFD34D4C9DB16822B52467770CF2D6FAB02406B0793A45AFD136D386080A72A70D77A2FC6741C36214F541F1824AF7DA9B6F7AD8240D",
                "E194A5EE3EBD763849491BEFED746D72824EB2AEE906288EDC976598BB193B7DA913716D8C544CC65534214BBCBF915179DD10239979B5F33AAD0AC0B0DA06C050E761E3DEAE2D39E7F4DE6E489A4095C030BE144C38BDD56FC697739942AA01EBCD47F770C5EBEEDCBBCC51698F2219CD8A86276110E5D3ED8926D7B6",
                "8589A9AF33F2647D494842A3FC7D39278544B2A0EE1A39C6DB936183F5502166A8006672DB7C1F84492E675DA1BEC45779DF106DDB63FAFF38B10B948C8E10D348AC2FEAC0",
                "9592B4AF22FC633958481BEEE7616D729947B2ADE90638C6CD84789EBB192629A1047E23925B588A45293405EEBE8A537DDA06238578AFA63BAA49C1ACDA1ECF1CF829E097B13F24A9BDC47B55DD51898567B91B4939FED93C928B7A8842A505EBC305C76AD3E8A7C1B0C408",
                "9588ACFB6DEE3129555F1BF3FA7B77319F51FEBCA1002DC6D8C15099FE053166E133510AD5156B8E457A2951A3A9814D6B8914719937B4E929E558D1BE961DD81CFE20EBD3B333",
                "9588A8F66AFC63381D5D5EEDED6078269345B2ACF20625819980208EFE04307BA108712488415685003B2B43A1B98D4B70C4",
                "9192A2ED26F87C7D54491BF7E0736D728F4EE7F9F20A2E829995688FBB023467A80E726D9C505183523B334BBCEB855879C01B2DDC52ACE32FBC0AC0B697148145E334A5C4B93B29E7F4C43A53D251DDCC7EB8064330B2",
                "9588A8AF39F8722F584E1BEEED616A339144B2B0F2556BB1D1846ECAEE033C67AB417E6D88414D8341376747A7BB8C5A6A891B668A72A8A628B64F94AB92148157E938A5DAB32C28E7E9D87B499A5B93C675F15A1B68EC877F80CD3B"}; // cypher

    private static int[][] hex() {
        int arr[][] = new int[MSGS.length][MSGS[10].length() / 2];

        for (int k = 0; k < MSGS.length; k++) {
            int len = Math.min(MSGS[10].length(), MSGS[k].length());
            for (int j = 0, i = 0; j < len; j += 2, i++) {
                arr[k][i] = Integer.parseInt(MSGS[k].substring(j, j + 2), 16);
//                System.out.print(arr[k][i]+ ", ");
            }
//            System.out.println("\n --------------------------------");

        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = hex();

        String plain[] = new String[10];
        for (int i = 0; i < 10; i++) {
            plain[i] = "";
        }

        String target = "";

        for (int i = 0; i < arr[10].length; i++) {

            char possible[] = new char[95];
            char possible2[] = new char[65];
            int h = 0, g = 0;
            for (int guess = 32; guess < 127; guess++) {
                System.out.println("guess = " + (char) guess + "\n");

                char[] p = new char[10];
                for (int j = 0; j < arr.length - 1; j++) {
                    if (i >= MSGS[j].length() / 2) {
                        p[j] = ' ';
                        System.out.println("plain[" + j + "] : " + plain[j] + p[j]);
                        continue;
                    }
                    int guess_xor_msgs = (arr[10][i] ^ arr[j][i]) ^ guess;
                    p[j] = (char) guess_xor_msgs;
                    System.out.println("plain[" + j + "] : " + plain[j] + p[j]);
                }
                System.out.println("------------------- " + i + " --------------------------");
                boolean flag = true, flag2 = true;

                for (int b = 0; b < 10; b++) {
                    if (!(Character.isAlphabetic(p[b]) || Character.isDigit(p[b]) || p[b] == 32)) {
                        flag2 = false;
                    }
                    if (p[b] < 32 || p[b] > 126) {
                        flag = false;
                        break;
                    }

                }

                if (flag) {
                    possible[h++] = (char) guess;
                }
                if (flag2) {
                    possible2[g++] = (char) guess;
                }

            }

            System.out.print("[ ");
            for (char b : possible) {
                if (b == '\0') {
                    break;
                }
                System.out.print(b + ", ");
            }
            System.out.println("]\n");

            System.out.print("[ ");
            for (char b : possible2) {
                if (b == '\0') {
                    break;
                }
                System.out.print(b + ", ");
            }
            System.out.println("]");

            System.out.println("\n******************************************************************************************************************\n ");

            System.out.println("plaintext: " + target);
            char choose = sc.nextLine().charAt(0);
            target += choose;
            for (int j = 0; j < 10; j++) {
                if (i >= MSGS[j].length() / 2) {
                    plain[j] += ' ';
                    continue;
                }
                plain[j] += (char) ((arr[10][i] ^ arr[j][i]) ^ choose);
            }

        }
        System.out.println();
        for (int j = 0; j < arr.length - 1; j++) {
            System.out.println("plain[" + j + "]: " + plain[j]);
        }

    }
}
// The secret message is: When using a stream cipher never use the key more than once (1927022)
