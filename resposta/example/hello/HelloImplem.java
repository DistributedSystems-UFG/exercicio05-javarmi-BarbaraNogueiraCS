/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author barbara
 */
package resposta.example.hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementacao concreta do objeto remoto MyHello.
 *
 * Esta classe executa, no servidor, as operacoes definidas na interface Hello.
 */
public class HelloImplem extends UnicastRemoteObject implements Hello {

    public HelloImplem(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }

    @Override
    public int soma(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public double subtracao(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplicacao(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divisao(double a, double b) throws RemoteException {
        if (b == 0.0) {
            throw new IllegalArgumentException("Nao e possivel dividir por zero.");
        }
        return a / b;
    }
}