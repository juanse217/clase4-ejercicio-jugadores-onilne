package com.sebastian;

import java.util.Scanner;

import com.sebastian.model.Player;
import com.sebastian.service.GameService;

public class Main {
    public static void main(String[] args) {
        GameService service = new GameService();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== MENÚ JUEGO ====");
            System.out.println("1. Conectar jugador");
            System.out.println("2. Desconectar jugador");
            System.out.println("3. Mostrar jugadores conectados");
            System.out.println("4. Agregar jugador a sala de espera");
            System.out.println("5. Sacar jugador de sala de espera");
            System.out.println("6. Mostrar sala de espera");
            System.out.println("7. Actualizar ranking");
            System.out.println("8. Mostrar ranking");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nickname: ");
                    String nick = sc.nextLine();
                    System.out.print("Nivel: ");
                    int nivel = sc.nextInt();
                    System.out.print("Puntos: ");
                    int puntos = sc.nextInt();
                    Player j = new Player(nick, nivel, puntos);
                    if (service.connectPlayer(j))
                        System.out.println("Jugador conectado.");
                    else
                        System.out.println("Ya estaba conectado.");
                    break;
                case 2:
                    System.out.print("Nickname: ");
                    nick = sc.nextLine();
                    Player j2 = new Player(nick, 0, 0);
                    if (service.disconnectPlayer(j2))
                        System.out.println("Jugador desconectado.");
                    else
                        System.out.println("Jugador no encontrado.");
                    break;
                case 3:
                    service.showConnectedPlayers();
                    break;
                case 4:
                    System.out.print("Nickname: ");
                    nick = sc.nextLine();
                    service.addToqueue(new Player(nick, 0, 0));
                    break;
                case 5:
                    service.removeFromQueue();
                    break;
                case 6:
                    service.showQueue();
                    break;
                case 7:
                    service.updateRanking();
                    System.out.println("Ranking actualizado.");
                    break;
                case 8:
                    service.showRanking();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}