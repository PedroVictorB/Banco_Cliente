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
    public static void main(String args[]){
        try {
            //new Consultar2(new Socket("127.0.0.1", 2222), "1").executa();
            //new Depositar2(new Socket("127.0.0.1", 2222), "1", 200).executa();
            //new Consultar2(new Socket("127.0.0.1", 2222), "1").executa();
            //new Sacar2(new Socket("127.0.0.1", 2222), "1", 200).executa();
            new Consultar2(new Socket("127.0.0.1", 2222), "1").executa();
            new Consultar2(new Socket("127.0.0.1", 2222), "2").executa();
            System.out.println("----------------------------------");
            new Transferir2(new Socket("127.0.0.1", 2222), "1", "2", 200).executa();
            System.out.println("----------------------------------");
            new Consultar2(new Socket("127.0.0.1", 2222), "1").executa();
            new Consultar2(new Socket("127.0.0.1", 2222), "2").executa();
        } catch (UnknownHostException ex) {
            Logger.getLogger(teste1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(teste1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
