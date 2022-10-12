/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

/**
 *
 * @author Davi
 */
public class Produto {
    
    private int codigo;
    private String nome;
    private int estoque;
    private double precoUnitario;

    public Produto() {
    }

    
    
    public Produto(int codigo,String nome, int estoque, double precoUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.estoque = estoque;
        this.precoUnitario = precoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }



    
    
    
    
}
