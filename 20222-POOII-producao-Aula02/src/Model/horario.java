/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Davi
 */
public class horario {
    
    double hora,minuto,segundo;

    public horario(double hora, double minuto, double segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "horario{" + "hora=" + hora + ", minuto=" + minuto + ", segundo=" + segundo + '}';
    }
    
    
    
}
