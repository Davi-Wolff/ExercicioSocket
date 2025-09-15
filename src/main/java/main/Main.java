package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			String endereco = sc.nextLine();
			int porta = sc.nextInt();
			
			Socket sock = new Socket(endereco, porta);
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String linha = "";
			out.println("GET / HTTP/1.0\n");
			while ((linha = in.readLine()) != null) {
				System.out.println("echo: " + linha);
			}
		} catch (IOException e) {
			System.err.println("Problemas de IO");
		}
	}
}