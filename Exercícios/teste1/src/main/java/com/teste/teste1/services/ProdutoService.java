package com.teste.teste1.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.teste1.model.Produto;
import com.teste.teste1.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository protodutoRepository;


    /**
     * Metodo que adiciona um produto
     * @return
     */
    public List<Produto> obterTodos(){
        return protodutoRepository.obterTodos();
    }

    /** 
     * Metodo que retorna o produto pelo id
     * @param id id do produto que será localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return protodutoRepository.obterPorId(id);
    }

    /** 
     * Metodo que adiciona um produto na lista
     * @param produto produto que será adicionado
     * @return retorna o produto adicionado
     */
    public Produto adicionar(Produto produto){
        return protodutoRepository.adicionar(produto);
    }

    /** 
     * Metodo que deleta um produto
     * @param produto produto que será deletado
     */
    public void deletar(Integer id){
        protodutoRepository.deletar(id);
    }

    /** 
     * Metodo que atualiza um produto
     * @param produto produto que será atualizado
     * @return retorna o produto atualizado
     */
    public Produto atualizar(Integer id, Produto produto){
        produto.setId(id);
        return protodutoRepository.atualizar(produto);
    }
}
