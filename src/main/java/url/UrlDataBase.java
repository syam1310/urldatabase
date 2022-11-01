package url;

import java.util.List;
import java.util.Scanner;

public class UrlDataBase {


    public static void main(String[] ar) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        String[] inputCmd = null;
        UrlDatabaseService service = new UrlDatabaseService();
        while(true) {
            System.out.print("Please enter command: ");
            input = sc.nextLine(); inputCmd = input.split(" ");

            switch(inputCmd[0]) {
                case "storeurl":
                    int id = service.storeUrl(inputCmd[1]);
                    System.out.println("ID: " + id);
                    break;
                case "get":
                    int urlId = service.getUrlId(inputCmd[1]);
                    if(urlId==-1){
                        System.out.println("This url is not registered: " + urlId);
                    }else{
                        System.out.println("Unique short key: " + urlId);
                    }

                    break;
                case "count":
                    int usagesCount = service.getUrlUsagesCount(inputCmd[1]);
                    if(usagesCount==0){
                        System.out.println("This url is not registered: " + inputCmd[1]);
                    }else{
                        System.out.println("Latest usage count: " + usagesCount);
                    }

                    break;
                case "list":
                    String res = service.getList();
                    System.out.println(res);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
