/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.FuncionarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.detail;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.summary;
import rh.modelo.Funcionario;

/**
 *
 * @author leandropontes
 */
@Named(value = "funcionarioMbean")
@SessionScoped
public class FuncionarioMBean implements Serializable {

    /**
     * Nunca meter nada dentro contrutor.. em modo CDIBean Apagar o construtor
     */
    Funcionario funcionario = new Funcionario();
    FuncionarioDAO dao = new FuncionarioDAO();

    Funcionario funcionario1 = new Funcionario("Leandro", "Pontes", "Informatico", 50000.00);
    Funcionario funcionario2 = new Funcionario("Anselmo", "Sambongo", "Informatico",70000.00);
    Funcionario funcionario3 = new Funcionario("Ada", "henriques", "Informatico", 50000.00);

    List<Funcionario> funcionarios = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String guardar() {
        funcionarios.add(funcionario);
        FacesContext  facesContext = FacesContext.getCurrentInstance();  
        
        String meuNome ="leandro pontes";
        FacesMessage facesMessage = new FacesMessage(null, "Funcionario Guardado com Sucesso"+" "+meuNome);  
        
        facesContext.addMessage(null, facesMessage);
        
        return "listaFuncionarios";
    }
        
    // para salvar na basse de dados 
       public String save() {
        dao.save(funcionario);
        funcionario = new Funcionario();
        return "funcionarioDB";
    }
}


