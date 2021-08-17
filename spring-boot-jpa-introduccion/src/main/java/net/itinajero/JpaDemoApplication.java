package net.itinajero;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.itinajero.model.Categoria;
import net.itinajero.repository.CategoriasRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriasRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		//guardarTodas();
		//buscarTodos();
		//conteo();
		buscarTodos();
	}
	
	/**
	 * Metodo saveAll - Interfaz CrudRepository
	 */
	private void guardarTodas() {
		List<Categoria> categorias = getListaCategorias();
		repo.saveAll(categorias);
	}
	
	/**
	 * Metodo existsById - Interfaz CrudRepository
	 */
	private void existeId() {
		boolean existe = repo.existsById(50);
		System.out.println("La categoria existe: " + existe);
	}
	
	/**
	 * Metodo findAll - Interfaz CrudRepository
	 */
	private void buscarTodos() {
		Iterable<Categoria> categorias = repo.findAll();
		for (Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	/**
	 * Metodo findAllById - Interfaz CrudRepository
	 */
	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repo.findAllById(ids);
		for (Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	/**
	 * Metodo deleteAll - Interfaz CrudRepository
	 */
	private void eliminarTodos() {
		repo.deleteAll();
	}
	
	/**
	 * Metodo count - Interfaz CrudRepository
	 */
	private void conteo() {
		long count = repo.count();
		System.out.println("Total Categorias: " + count);
	}
	
	/**
	 * Metodo deleteById - Interfaz CrudRepository
	 */
	private void eliminar() {
		int idCategoria = 1;
		repo.deleteById(idCategoria);
	}
	
	/**
	 * Metodo save(update) - Interfaz CrudRepository
	 */
	private void modificar() {
		Optional<Categoria> optional = repo.findById(2);
		if (optional.isPresent()) {
			Categoria catTmp = optional.get();
			catTmp.setNombre("Ing. de software");
			catTmp.setDescripcion("Desarrollo de sistemas");
			repo.save(catTmp);
			System.out.println(optional.get());
		}	
		else
			System.out.println("Categoria no encontrada");
	}
	
	/**
	 * Metodo findById - Interfaz CrudRepository
	 */
	private void buscarPorId() {
		Optional<Categoria> optional = repo.findById(5);
		if (optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("Categoria no encontrada");
	}
	
	/**
	 * Metodo save - Interfaz CrudRepository
	 */
	private void guardar() {
		Categoria cat = new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
		repo.save(cat);
		System.out.println(cat);		
	}
	
	/**
	 * Metodo que regresa una lista de 3 Categorias
	 * @return
	 */
	private List<Categoria> getListaCategorias(){
		List<Categoria> lista = new LinkedList<Categoria>();
		// Categoria 1
		Categoria cat1 = new Categoria();
		cat1.setNombre("Programador de Blockchain");
		cat1.setDescripcion("Trabajos relacionados con Bitcoin y Criptomonedas");
		
		// Categoria 2
		Categoria cat2 = new Categoria();
		cat2.setNombre("Soldador/Pintura");
		cat2.setDescripcion("Trabajos relacionados con soldadura, pintura y enderezado");
						
		// Categoria 3
		Categoria cat3 = new Categoria();
		cat3.setNombre("Ingeniero Industrial");
		cat3.setDescripcion("Trabajos relacionados con Ingenieria industrial.");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		return lista;
	}
		
}
