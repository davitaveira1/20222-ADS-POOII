/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex02;

/**
 *
 * @author Davi
 */
public class eletrodomestico {
    
    String nome;
    double potencia;
    double tempo;

    
    
    public eletrodomestico(String nome, double potencia, double tempo) {
        this.nome = nome;
        this.potencia = potencia;
        this.tempo = tempo;
    }
    
    double wattsDia(){
        return potencia*tempo;
    }
    
    double wattsMes(){
        return wattsDia()*30;
    }
    
    double wattsAno(){
        return wattsMes() * 12;
    }
    
    double gastoMes(double precoKWatt){
        return (wattsMes()/1000)*precoKWatt;
    }
    
    String relatorio(double precoKWatt){
        return "Nome: "+nome+
                "\nPotencia: "+potencia+
                "\nTempo: "+tempo+
                "\nWatts/Dia: "+wattsDia()+
                "\nWatts/Mês: "+wattsMes()+
                "\nWatts/Ano: "+wattsAno()+
                "\nPreço KWatt: "+precoKWatt+
                "\nGasto Mensal: "+gastoMes(precoKWatt);
    }
    
    public static void main(String[] args) {
        eletrodomestico e1 = new eletrodomestico("TV", 50, 10);
        System.out.println(e1.relatorio(0.50));
    }
    
}
