package br.com.fatec.primeiroprojeto.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.primeiroprojeto.entities.Pessoa;
import br.com.fatec.primeiroprojeto.repositorio.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List; 


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    //tava escrito getPessoa ao inves de getPessoas e o controller acabava chamando um metodo que nao existia
    //coloquei um tratamento de exception tb pq so gay
    public List<Pessoa> getPessoas(){
        List<Pessoa> pessoas = this.repository.findAll();

        if(pessoas == null){
            throw new EntityNotFoundException("Não há pessoas cadastradas!");
        }

        return pessoas;
    }

    //precisa implementar os getByName e getByEmail ao inves de getById
    public Pessoa getPessoaById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Essa Pessoa Não existe")
        );
    }
    
    //mesmo caso do get vale pra delete
    public void deletePessoatById(int id){
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);;
        }

        else{
            throw new EntityNotFoundException("Essa Pessoa Não existe");
        }
    }

    public Pessoa save(Pessoa pessoa){
        return this.repository.save(pessoa);
    }

}
