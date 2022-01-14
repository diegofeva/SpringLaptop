package com.example.SpringEjercicio4;

import com.example.SpringEjercicio4.entities.Laptop;
import com.example.SpringEjercicio4.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Crear una clase HelloController que sea un controlador REST.
//Dentro de la clase crear un método que retorne un saludo.
//Probar que retorna el saludo desde el navegador y desde Postman.


//Ejercicio 2
//Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":
//Laptop (entidad)
//LaptopRepository (repositorio)
//LaptopController (controlador)
//Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
//Probar que funciona desde Postman.
//Los objetos Laptop se pueden insertar desde el método main de la clase principal.

@SpringBootApplication
public class SpringEjercicio4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringEjercicio4Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"hp","d1",45,"Windows");
		repository.save(laptop1);
		Laptop laptop2 = new Laptop(null,"hp","d2",45,"Windows");
		repository.save(laptop2);
		Laptop laptop3 = new Laptop(null,"hp","d3",45,"Windows");
		repository.save(laptop3);
		Laptop laptop4 = new Laptop(null,"hp","d4",45,"Windows");
		repository.save(laptop4);
		Laptop laptop5 = new Laptop(null,"hp","d5",45,"Windows");
		repository.save(laptop5);
		Laptop laptop6 = new Laptop(null,"hp","d6",45,"Windows");
		repository.save(laptop6);



	}

}
