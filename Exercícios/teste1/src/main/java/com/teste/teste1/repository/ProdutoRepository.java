package com.teste.teste1.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.teste1.model.Produto;

@Repository
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /** 
     * Metodo que retorna uma lista de produtos
     * @return List<Produto>
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /** 
     * Metodo que retorna o produto pelo id
     * @param id id do produto que será localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }



    /** 
     * Metodo que adiciona um produto na lista
     * @param produto produto que será adicionado
     * @return retorna o produto adicionado
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }


    /** 
     * Metodo que deleta um produto
     * @param produto produto que será deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /** 
     * Metodo que atualiza um produto
     * @param produto produto que será atualizado
     * @return retorna o produto atualizado
     */
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if (produtoEncontrado.isEmpty()) {
            throw new InputMismatchException("Produto Não Encontrado");
        }
        deletar(produto.getId());
        produtos.add(produto);
        return produto;
    }
}

