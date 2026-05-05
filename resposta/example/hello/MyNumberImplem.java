/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author barbara
 */
package resposta.example.hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementacao concreta do objeto remoto MyNumber.
 *
 * Esta classe executa, no servidor, operacoes relacionadas a numeros naturais e reais.
 */
public class MyNumberImplem extends UnicastRemoteObject implements MyNumber {

    public MyNumberImplem(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String parOuImpar(int numero) throws RemoteException {
        validarNatural(numero);
        return (numero % 2 == 0) ? "par" : "impar";
    }

    @Override
    public boolean ehPrimo(int numero) throws RemoteException {
        validarNatural(numero);

        if (numero < 2) {
            return false;
        }

        if (numero == 2) {
            return true;
        }

        if (numero % 2 == 0) {
            return false;
        }

        for (int divisor = 3; divisor <= Math.sqrt(numero); divisor += 2) {
            if (numero % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public double modulo(double numero) throws RemoteException {
        return Math.abs(numero);
    }

    private void validarNatural(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("O numero deve ser natural, ou seja, maior ou igual a zero.");
        }
    }
}