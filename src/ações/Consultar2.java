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


public class Consultar2 extends Thread {

    // parte que controla a recepção de mensagens do cliente
    private Socket conexao;
    private String conta;
    
    // construtor que recebe o socket do cliente
    public Consultar2(Socket socket, String str) {
        this.conexao = socket;
        this.conta = str;
    }

    public void executa(){
        try {
            Socket socket = new Socket("127.0.0.1", 2222);
            PrintStream saida = new PrintStream(socket.getOutputStream());
            Thread thread = new Consultar2(socket, conta);
            thread.start();
            saida.println("4 "+ conta);
            
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
