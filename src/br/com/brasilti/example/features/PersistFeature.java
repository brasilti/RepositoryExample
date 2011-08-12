package br.com.brasilti.example.features;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.com.brasilti.example.entities.Carro;
import br.com.brasilti.example.entities.Marca;
import br.com.brasilti.repository.annotations.Transactional;
import br.com.brasilti.repository.core.Keeper;
import br.com.brasilti.repository.core.Seeker;
import br.com.brasilti.repository.exceptions.RepositoryException;

public class PersistFeature {

	@Inject
	private Keeper keeper;

	@Inject
	private Seeker seeker;

	@Transactional
	public void main(@Observes ContainerInitialized initialized) throws RepositoryException {
		Marca vw = new Marca();
		vw.setNome("Volkswagen");

		Marca gm = new Marca();
		gm.setNome("General Motors");

		this.keeper.persist(vw);
		this.keeper.persist(gm);

		List<Marca> marcas = this.seeker.seekAll(Marca.class);
		for (Marca m : marcas) {
			System.out.println("Marca: " + m.getNome());
		}

		System.out.println("Quantidade: " + this.seeker.count(Marca.class));
		
		Carro gol = new Carro();
		gol.setModelo("Gol");
		gol.setAno(2010);
		gol.setPreco(BigDecimal.valueOf(40000));
		gol.setMarca(vw);
		
		this.keeper.persist(gol);
		
		List<Carro> carros = this.seeker.seekAll(Carro.class);
		for (Carro carro : carros) {
			System.out.println("Carro: " + carro.getModelo());
		}
		
		System.out.println("Quantidade: " + this.seeker.count(Carro.class));
	}

}
