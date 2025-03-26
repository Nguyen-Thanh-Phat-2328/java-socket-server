/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deploychatclientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author 23042
 */
public class DeployChatClientServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        try {
            int port = 5000;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            while(true){
                int chon;
                do{
                   chon = dis.readInt();
                    switch (chon) {
                        case 1:
                            //Nhận đầu vào từ client 
                            int a = dis.readInt();
                            int b = dis.readInt();
                            int s = a + b;

                            //Gửi kết quả cho client
                            dos.writeInt(s);
                            break;
                        case 2:
                            //Nhận đầu vào từ client
                            String str = dis.readUTF();
                            int so = Integer.parseInt(str);
                            //Đọc số thành chữ
                           
                           
                            //Trả kết quả cho client
                            dos.writeUTF(docHangChuc(so));
                            break;
                        default:
                            throw new AssertionError();
                    }
                } while(chon != 0);
            }
            
       
        } catch (Exception e) {
        }
        
        
    }
    
    //
    static String[] mang = {"không","một","hai","ba","bốn","năm","sáu","bảy","tám","chín"};
    public static String docHangChuc(int so){
        if(so % 10 == so){
                for(int i = 0; i < mang.length; i++){
                if(so == i){
                    return mang[i];
                }
            }
        } else if(so % 100 == so) {
            String soHaiChuSo = "";
            int donvi = so % 10;
            int chuc = (so - donvi) / 10;
            for(int i = 0; i < mang.length; i++){
                if(chuc == 1 && chuc == i){
                    soHaiChuSo += "Mười";
                } else if(chuc == i){
                    soHaiChuSo = soHaiChuSo + mang[i] + " mươi";
                }
            }
            for(int i = 0; i < mang.length; i++){
                if(donvi == i && donvi == 0){
                    soHaiChuSo = soHaiChuSo + " mươi";
                }
                else if(donvi == i){
                    soHaiChuSo = soHaiChuSo + " " + mang[i];
                }
            }
            return soHaiChuSo;
        }
        return null;
    
    }
    
}
