/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import avaliacao1vts.RelatorioDeFuncionarios;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author julionogueira
 */
public class Avaliacao2VTSTeste2 {
    
    public Avaliacao2VTSTeste2() {
    }
    
    @Test
    public void FuncionariosBloquados(){
        RelatorioDeFuncionarios relatorio = mock(RelatorioDeFuncionarios.class);
        when(relatorio.getFuncComCPFBloqueado("tecnico")).thenReturn(0);
        int quantidade = relatorio.getFuncComCPFBloqueado("tecnico");
        assertEquals(quantidade, 0);
    }
    
    @Test
    public void FuncionariosNaoBloquados(){
        RelatorioDeFuncionarios relatorio = mock(RelatorioDeFuncionarios.class);
        when(relatorio.getFuncComCPFBloqueado("analista")).thenReturn(1);
        int quantidade = relatorio.getFuncComCPFBloqueado("analista");
        assertEquals(quantidade, 1);
    }
    
    @Test
    public void FuncionariosGerente(){
        RelatorioDeFuncionarios relatorio = mock(RelatorioDeFuncionarios.class);
        when(relatorio.getFuncComCPFBloqueado("gerente")).thenReturn(2);
        int quantidade = relatorio.getFuncComCPFBloqueado("gerente");
        assertEquals(quantidade, 2);
    }
}
