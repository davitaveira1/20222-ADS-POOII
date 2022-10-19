/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Produto;
import java.util.List;

/**
 *
 * @author Davi
 */
public class controlaProdutos {
    
    public static void adicionar(List<Produto> lista,Produto p){
        lista.add(p);
    }
    
    public static int ultimoCodigo(List<Produto> lista){
        if(lista.isEmpty()){            
            return 1;
        }else{
            
            //System.out.println("Codigo2: "+lista.size());
            int tamanho = lista.size();
            System.out.println("Tamanho: "+tamanho);
            //System.out.println("");
            int proxCodigo = lista.get(tamanho-1).getCodigo()+1;
            System.out.println("Codigo prod: "+lista.get(tamanho-1).getCodigo());
            System.out.println("proxCodigo: "+proxCodigo);
            return proxCodigo;
            
            //return lista.size()+1;
        }
        
    }
    
    public static void imprimir(List<Produto> lista){
        for(Produto p : lista){
            
            System.out.println("Produto: "+p.getCodigo());
            System.out.println("Produto: "+p.getNome());
            System.out.println("Produto: "+p.getQuantidade());
            System.out.println("Produto: "+p.getPreco());
            System.out.println("===================");
        }
    }
    
    public static Produto buscarProduto(List<Produto> lista,int codigo){        
        return lista.get(codigo);
    }
    
    public static void editar(List<Produto> lista){
        
    }
    
    public static void excluir(List<Produto> lista,int codigo){        
        lista.remove(codigo);
    }
    
}
