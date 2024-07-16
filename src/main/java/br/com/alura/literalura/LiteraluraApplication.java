package br.com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.literalura.dto.BookDTO;
import br.com.alura.literalura.model.Author;
import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.repository.BookRepository;
import br.com.alura.literalura.service.ConsumirAPI;

import java.util.*;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ConsumirAPI consumirAPI;

	@Autowired
	private BookRepository bookRepository;

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
					// findAuthorByName(scanner);
					break;

				case 5:
					// listAuthorsAliveByYear(scanner);
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
		System.out.println("Digite o título do livro:");
		String title = scanner.nextLine();

		try {
			List<BookDTO> books = consumirAPI.searchBooks(title);

			if (books.isEmpty()) {
				System.out.println("Nenhum livro encontrado");
			} else {
				for (int i = 0; i < books.size(); i++) {
					System.out.println(i + " - " + books.get(i).title());
				}

				System.out.println("Digite o número do livro que deseja salvar:");
				int index = scanner.nextInt();
				scanner.nextLine();

				Book book = new Book(books.get(index));
				bookRepository.save(book);
				System.out.println("Livro salvo com sucesso!");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listBooks() {
		List<Book> books = bookRepository.findAll();

		if (books.isEmpty()) {
			System.out.println("Nenhum livro salvo");

		} else {
			System.out.println("Lista de livros salvos: ");
			for (Book book : books) {
				System.out.println("- " + book.getTitle());
			}
		}

	}

	private void listAuthors() {
		List<Author> authors = bookRepository.findAllAuthors();

		if (authors.isEmpty()) {
			System.out.println("Nenhum autor salvo");
		} else {
			System.out.println("Lista de autores salvos:");
			for (Author author : authors) {
				System.out.println("- " + author.getName());

			}
		}
	}

	// private void findAuthorByName(Scanner scanner) {
	// // TODO Auto-generated method stub
	// throw new UnsupportedOperationException("Unimplemented method
	// 'findAuthorByName'");
	// }

	// private void listAuthorsAliveByYear(Scanner scanner) {
	// // TODO Auto-generated method stub
	// throw new UnsupportedOperationException("Unimplemented method
	// 'listAuthorsAliveByYear'");
	// }

}
