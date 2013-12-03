/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Pedro
 */
public class conCli extends Thread {

    private Socket conexao;
    private String comando;
    public String msg;
    //O comando vai obedecer o seguinte padrão:
    //1-Os valores deverão ter 1 espaço entre eles para que a função split no servidor separe cada um.
    //2-O primeiro valor é a operação, o segundo é o numero da conta e os demais valores são as variáveis.

    public conCli(Socket socket, String comando) {
        this.conexao = socket;
        this.comando = comando;
        
        try {
            Socket s = new Socket("127.0.0.1", 2222);
            PrintStream saida = new PrintStream(s.getOutputStream());
            saida.println(this.comando);
            System.out.println("passei 1");
            
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        
    }
    
    
    @Override
    public void run()
    {
        try {
            //recebe mensagens de outro cliente através do servidor
            PrintStream saida = new PrintStream(this.conexao.getOutputStream());
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
            
            //cria variavel de mensagem
                System.out.println("passei 3");
                // pega o que o servidor enviou
                msg = entrada.readLine();
                //se a mensagem contiver dados, passa pelo if, 
                // caso contrario cai no break e encerra a conexao
                if (msg == null) {
                    System.out.println("Conexão encerrada!");
                    System.exit(0);
                }
        } catch (IOException e) {
            System.out.println("Ocorreu uma Falha... .. ." + 
                " IOException: " + e);
        }
    }
}
