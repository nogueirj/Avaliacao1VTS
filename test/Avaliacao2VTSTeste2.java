/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import avaliacao1vts.Funcionario;
import avaliacao1vts.FuncionarioDAO;
import avaliacao1vts.ReceitaFederal;
import avaliacao1vts.RelatorioDeFuncionarios;
import java.util.ArrayList;
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
    //Existem 2 funcionários na categoria “tecnico” que não estão com o CPF bloqueado.
    @Test
    public void FuncionariosTecnico(){
        FuncionarioDAO dao = mock(FuncionarioDAO.class);
        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(dao);
        ReceitaFederal receita = mock(ReceitaFederal.class);
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario(); f1.setCpf("111111111-11");
        Funcionario f2 = new Funcionario(); f2.setCpf("222222222-22");
        Funcionario f3 = new Funcionario(); f3.setCpf("333333333-33");
        
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        
        relatorio.setRf(receita);
        
        when(dao.getFuncionariosBy("tecnico")).thenReturn(funcionarios);
        when(receita.isCPFBloqueado(f1.getCpf())).thenReturn(Boolean.FALSE);
        when(receita.isCPFBloqueado(f2.getCpf())).thenReturn(Boolean.FALSE);
        when(receita.isCPFBloqueado(f3.getCpf())).thenReturn(Boolean.TRUE);
        int quantidadeBloqueados = relatorio.getFuncComCPFBloqueado("tecnico");
        int quantidadeNaoBloqueados = funcionarios.size() - quantidadeBloqueados;
        assertEquals(quantidadeNaoBloqueados, 2);
    }
    
    //Existe 1 funcionário na categoria “analista” que está com o CPF bloqueado
    @Test
    public void Funcionariosanalista(){
        FuncionarioDAO dao = mock(FuncionarioDAO.class);
        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(dao);
        ReceitaFederal receita = mock(ReceitaFederal.class);
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario(); f1.setCpf("444444444-44");
        Funcionario f2 = new Funcionario(); f2.setCpf("555555555-55");
        
        funcionarios.add(f1);
        funcionarios.add(f2);
        
        relatorio.setRf(receita);
        
        when(dao.getFuncionariosBy("analista")).thenReturn(funcionarios);
        when(receita.isCPFBloqueado(f1.getCpf())).thenReturn(Boolean.FALSE);
        when(receita.isCPFBloqueado(f2.getCpf())).thenReturn(Boolean.TRUE);
        int quantidade = relatorio.getFuncComCPFBloqueado("analista");
        assertEquals(quantidade, 1);
    }
    
    //Existem 4 funcionários na categoria “gerente” com os CPFs: (123456789-00, 111222333-44,
    //654321987-23, 098876654-99), sendo que os CPFs 111222333-44 e 098876654-99 estão bloqueados.
    @Test
    public void Funcionariosgerente(){    
        FuncionarioDAO dao = mock(FuncionarioDAO.class);
        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(dao);
        ReceitaFederal receita = mock(ReceitaFederal.class);
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario(); f1.setCpf("123456789-00");
        Funcionario f2 = new Funcionario(); f2.setCpf("111222333-44");
        Funcionario f3 = new Funcionario(); f3.setCpf("654321987-23");
        Funcionario f4 = new Funcionario(); f4.setCpf("098876654-99");
            
        
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);
        
        relatorio.setRf(receita);
        
        when(dao.getFuncionariosBy("gerente")).thenReturn(funcionarios);
        when(receita.isCPFBloqueado(f1.getCpf())).thenReturn(Boolean.FALSE);
        when(receita.isCPFBloqueado(f3.getCpf())).thenReturn(Boolean.FALSE);
        when(receita.isCPFBloqueado(f2.getCpf())).thenReturn(Boolean.TRUE);
        when(receita.isCPFBloqueado(f4.getCpf())).thenReturn(Boolean.TRUE);
        int quantidade = relatorio.getFuncComCPFBloqueado("gerente");
        assertEquals(quantidade, 2);
    }
}
