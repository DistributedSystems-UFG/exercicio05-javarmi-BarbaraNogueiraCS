/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author barbara
 */
package resposta.example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota do objeto MyHello.
 *
 * Esta interface define os metodos que poderao ser chamados remotamente pelo cliente.
 */
public interface Hello extends Remote {

    String sayHello() throws RemoteException;

    int soma(int a, int b) throws RemoteException;

    double subtracao(double a, double b) throws RemoteException;

    double multiplicacao(double a, double b) throws RemoteException;

    double divisao(double a, double b) throws RemoteException;
}