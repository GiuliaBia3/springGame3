package com.senai.giuliab.prjGame.servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.giuliab.prjGame.entities.Jogo;
import com.senai.giuliab.prjGame.repositories.JogoRepository;

@Service
public class JogoServicies {
	private final JogoRepository jogoRepository;

    @Autowired
	public JogoServicies(JogoRepository jogoRepository) {
		this.jogoRepository =jogoRepository;
	}
	
		public Jogo getJogoById(Long id) {
			return jogoRepository.findById(id).orElse(null);
		}
		
		public  List<Jogo> getAllJogos(){
			return jogoRepository.findAll();
		}
		
		public Jogo saveJogo(Jogo jogo) {
			return jogoRepository.save(jogo);		
		}
		
		public void deleteJogo(Long id){
			jogoRepository.deleteById(id);	
		}	
		public Jogo updateJogo(Long id, Jogo novoJogo) {
	        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
		}
}
