package br.com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int option = -1;

		while (option != 0) {
			menu();
			option = scanner.nextInt();

			switch (option) {
				case 1:
					findBookByTitle(scanner);
					break;

				case 2:
					listBooks();
					break;

				case 3:
					listAuthors();
					break;

				case 4:
					findAuthorByName(scanner);
					break;

				case 5:
					listAuthorsAliveByYear(scanner);
					break;

				case 0:
					System.out.println("Saindo...");
					break;

				default:
					System.out.println("Opção inválida");
			}

		}

		scanner.close();

	}

	public void menu() {
		System.out.println("1 - Buscar livro pelo título");
		System.out.println("2 - Listar livros salvos");
		System.out.println("3 - Listar autores salvos");
		System.out.println("4 - Buscar autor pelo nome");
		System.out.println("5 - Listar autores vivos em determinado ano");
		System.out.println("0 - Sair");
		System.out.println("Escolha uma opção:");
	}

	private void findBookByTitle(Scanner scanner) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findBookByTitle'");
	}

	private void listBooks() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listBooks'");
	}

	private void listAuthors() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listAuthors'");
	}

	private void findAuthorByName(Scanner scanner) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAuthorByName'");
	}

	private void listAuthorsAliveByYear(Scanner scanner) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listAuthorsAliveByYear'");
	}

}
