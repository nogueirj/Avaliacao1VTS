/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import avaliacao1vts.Classificador;
import avaliacao1vts.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julionogueira
 */
public class Avaliacao1VTSTeste1 {
    
    public Avaliacao1VTSTeste1() {
        classificador = new Classificador();
    }
    
    private Classificador classificador;
    
    @Test
    public void definirFaixaEtariaIdosa(){
        Pessoa p = new Pessoa("Maria", 81);
        String resultado = classificador.definirFaixaEtaria(p);
        assertEquals(resultado, p.getNome()+" eh idoso");
    }
    
    @Test
    public void definirFaixaEtariaCrianca(){
        Pessoa p = new Pessoa("Maria", 10);
        String resultado = classificador.definirFaixaEtaria(p);
        assertEquals(resultado, p.getNome()+" eh crianca");
    }
    
    @Test
    public void definirFaixaEtariaAdoslescente(){
        Pessoa p = new Pessoa("Maria", 16);
        String resultado = classificador.definirFaixaEtaria(p);
        assertEquals(resultado, p.getNome()+" eh adolescente");
    }
    
    @Test
    public void definirFaixaEtariaAdulto(){
        Pessoa p = new Pessoa("Maria", 55);
        String resultado = classificador.definirFaixaEtaria(p);
        assertEquals(resultado, p.getNome()+" eh adulto");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void definirFaixaEtariaInvalido(){
        Pessoa p = new Pessoa("Maria", -1);
        String resultado = classificador.definirFaixaEtaria(p);
        assertEquals(resultado, "");
    }
}
