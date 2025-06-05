package org.example.model;

import java.io.*;

public class ReadCSVFile {
    public static void main(String[] args) {
        String fileName ="user.csv";
        try (FileReader fileReader =new FileReader(fileName);
             BufferedReader bufferedReader =new BufferedReader(fileReader);
             ){
                int gmailCount =0;
                int hotmailCount =0;
                int yahooCount =0;
                String line;
                if((line = bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
                while ((line = bufferedReader.readLine())!=null){
                    String[] data = line.split(",");

                    //Object User
                    User user = new User(data[0],data[1],data[2]);
                    user.setEmailProvider(data[1]);
                    System.out.println(user);
                    switch (user.getEmailProvider()){
                        case "gmail.com":
                            gmailCount++;
                            break;
                        case "hotmail.com":
                            hotmailCount++;
                            break;
                        case "yahoo.com":
                            yahooCount++;
                            break;
                    }
                }
                System.out.printf("gmail有:%s,yahoo有:%s,hotmail有:%s",gmailCount,yahooCount,hotmailCount);
        }catch (IOException exception){
            System.out.println("檔案讀取有誤"+exception.getMessage());
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("資料不完整"+exception.getMessage());
        }

    }
}
