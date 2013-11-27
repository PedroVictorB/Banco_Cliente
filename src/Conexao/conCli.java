/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class conCli extends Thread {
// Flag que indica quando se deve terminar a execução.

    private static boolean done = false;

    private Socket conexao;
    private String comando;
    

    public conCli(Socket conexao, String comando) {
        this.conexao = conexao;
        this.comando = comando;
        try {
            this.conexao = new Socket("127.0.0.1", 2222);
            PrintStream saida = new PrintStream(this.conexao.getOutputStream());
            saida.println(this.comando);
            
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
