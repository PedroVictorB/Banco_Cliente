/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ações;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Pedro
 */


public class Sacar2 extends Thread {

    // parte que controla a recepção de mensagens do cliente
    private Socket conexao;
    private String conta;
    private int valor;
    
    // construtor que recebe o socket do cliente
    public Sacar2(Socket conexao, String conta, int valor) {
        this.conexao = conexao;
        this.conta = conta;
        this.valor = valor;
    }

    public void executa(){
        try {
            //usar scanner para arquivos ou entrada na linha de comando
            Socket socket = new Socket("127.0.0.1", 2222);
            PrintStream saida = new PrintStream(socket.getOutputStream());
            Thread thread = new Sacar2(socket, conta, valor);
            thread.start();
            saida.println("3 "+ conta + " " + valor);
            
        } catch (IOException e) {
            System.out.println("Falha na Conexao... .. ." + " IOException: " + e);
        }
    }
    // execução da thread

    @Override
    public void run() {
        try {
            //recebe mensagens de outro cliente através do servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
            //cria variavel de mensagem
            String msg;
            while (true) {
                // pega o que o servidor enviou
                msg = entrada.readLine();
                //se a mensagem contiver dados, passa pelo if, 
                // caso contrario cai no break e encerra a conexao
                if (msg == null) {
                    System.out.println("Conexão encerrada!");
                    System.exit(0);
                } else if ("-1".equals(msg)) {
                    System.out.println("Consulta não disponível");
                } else {
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            // caso ocorra alguma exceção de E/S, mostra qual foi.
            System.out.println("Ocorreu uma Falha... .. ."
                    + " IOException: " + e);
        }
    }
}
