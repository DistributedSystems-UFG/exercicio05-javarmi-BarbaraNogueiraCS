/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author barbara
 */
package resposta.example.hello;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Servidor RMI da aplicacao.
 *
 * Ele cria e registra os objetos remotos MyHello e MyNumber, deixando-os disponiveis para clientes.
 */
public class Server {

    private static final int HELLO_OBJECT_PORT = 5678;
    private static final int NUMBER_OBJECT_PORT = 5679;

    private Server() {}

    public static void main(String[] args) {
        try {
            iniciarRegistry();

            Hello helloObject = new HelloImplem(HELLO_OBJECT_PORT);
            Naming.rebind("MyHello", helloObject);

            MyNumber numberObject = new MyNumberImplem(NUMBER_OBJECT_PORT);
            Naming.rebind("MyNumber", numberObject);

            System.out.println("Servidor RMI pronto.");
            System.out.println("Objeto remoto registrado: MyHello");
            System.out.println("Objeto remoto registrado: MyNumber");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void iniciarRegistry() throws RemoteException {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("RMI Registry criado na porta " + Registry.REGISTRY_PORT + ".");
        } catch (RemoteException exception) {
            LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
            System.out.println("RMI Registry ja estava em execucao na porta " + Registry.REGISTRY_PORT + ".");
        }
    }
}