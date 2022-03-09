package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;
    private PessoaRepository pessoaRepository;

    public ContatoService() {
        this.contatoRepository = new ContatoRepository();
        this.pessoaRepository = new PessoaRepository();
    }

    public void delete(Long id) throws Exception {
        contatoRepository.delete(id);
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception {
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
        contato.setIdPessoa(pessoa.getIdPessoa());
        return contatoRepository.create(contato);
    }

    public Contato update(Integer id,Contato contato) throws Exception {
        return contatoRepository.update(id, contato);
    }


    public List<Contato> list() {
        return contatoRepository.list();
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }
}
