/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author barbara
 **/

package resposta.example.hello;

import java.rmi.Naming;

/**
 * Cliente RMI da aplicacao.
 *
 * Ele localiza os objetos remotos MyHello e MyNumber e chama seus metodos.
 */
public class Client {

    private Client() {}

    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];

        try {
            System.out.println("Iniciando cliente RMI...");
            System.out.println("Servidor informado: " + host);

            Hello helloStub = (Hello) Naming.lookup("rmi://" + host + "/MyHello");
            System.out.println("Objeto remoto MyHello encontrado.");

            System.out.println("sayHello(): " + helloStub.sayHello());
            System.out.println("soma(100, 1000): " + helloStub.soma(100, 1000));
            System.out.println("subtracao(20.5, 7.2): " + helloStub.subtracao(20.5, 7.2));
            System.out.println("multiplicacao(3.5, 4.0): " + helloStub.multiplicacao(3.5, 4.0));
            System.out.println("divisao(10.0, 4.0): " + helloStub.divisao(10.0, 4.0));

            MyNumber numberStub = (MyNumber) Naming.lookup("rmi://" + host + "/MyNumber");
            System.out.println("Objeto remoto MyNumber encontrado.");

            int numeroNatural = 17;
            double numeroReal = -8.75;

            System.out.println("parOuImpar(" + numeroNatural + "): " + numberStub.parOuImpar(numeroNatural));
            System.out.println("ehPrimo(" + numeroNatural + "): " + numberStub.ehPrimo(numeroNatural));
            System.out.println("modulo(" + numeroReal + "): " + numberStub.modulo(numeroReal));
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}