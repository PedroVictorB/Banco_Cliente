/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Pedro
 */
public class conCli extends Thread {

    private Socket conexao;
    private String comando;
    
    //O comando vai obedecer o seguinte padrão:
    //1-Os valores deverão ter 1 espaço entre eles para que a função split no servidor separe cada um.
    //2-O primeiro valor é a operação, o segundo é o numero da conta e os demais valores são as variáveis.

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
