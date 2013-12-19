/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import ações.Consultar2;
import ações.Depositar2;
import ações.Sacar2;
import ações.Transferir2;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pedro
 */
public class teste1 {
    public static void main(String args[]) throws InterruptedException{
        try {
            
            new Consultar2(new Socket("127.0.0.1", 2222), "1").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "2").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "3").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "4").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "5").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "6").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "7").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "8").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "9").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "10").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "11").executa();
            //Thread.sleep(1000);
            new Consultar2(new Socket("127.0.0.1", 2222), "12").executa();
            
//            new Consultar2(new Socket("127.0.0.1", 2222), "13").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "14").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "15").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "16").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "17").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "18").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "19").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "20").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "21").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "22").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "23").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "24").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "25").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "26").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "27").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "28").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "29").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "30").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "31").executa();
//            new Consultar2(new Socket("127.0.0.1", 2222), "32").executa();
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(teste1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(teste1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
