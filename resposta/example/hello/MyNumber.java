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
 * Interface remota do objeto MyNumber.
 *
 * Esta interface define metodos numericos que podem ser chamados remotamente pelo cliente.
 */
public interface MyNumber extends Remote {

    String parOuImpar(int numero) throws RemoteException;

    boolean ehPrimo(int numero) throws RemoteException;

    double modulo(double numero) throws RemoteException;
}