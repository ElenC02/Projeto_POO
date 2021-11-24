package com.example.control;


import java.util.List;
import com.example.daos.FuncionarioDAO;
import com.example.daos.IFuncionarioDAO;
import com.example.entity.Funcionario;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionarioControl {
	public IntegerProperty idFuncionario = new SimpleIntegerProperty(0);
	public IntegerProperty idUsuario = new SimpleIntegerProperty(0);
    public StringProperty cargoFuncionario = new SimpleStringProperty("");
	public StringProperty  setor = new SimpleStringProperty("");

    private static int counter = 0;
	
    private ObservableList<Funcionario> listaViewF = FXCollections.observableArrayList();
    private IFuncionarioDAO IFuncionarioDAO = new FuncionarioDAO();

    public Funcionario getEntity() {
    	Funcionario f = new Funcionario();
        f.setIdFuncionario(idFuncionario.get());
        f.setIdUsuario(idUsuario.get());
        f.setCargoFuncionario(cargoFuncionario.get());
        f.setSetor(setor.get());

        return f;
    }

    public void setEntity(Funcionario f) {
        idFuncionario.set(f.getIdFuncionario());
        idUsuario.set(f.getIdUsuario());
        cargoFuncionario.set(f.getCargoFuncionario());
        setor.set(f.getSetor());
    }

    public void salvar() {
    	Funcionario f = getEntity();
        if (f.getIdFuncionario() == 0) {
        	IFuncionarioDAO.adicionar(f);
            setEntity(new Funcionario());
        } else {
        	IFuncionarioDAO.atualizar(idFuncionario.get(), f);
        }
        atualizarListaView();
    }

    public void novoFuncionario() {
    	Funcionario f = new Funcionario();
        f.setIdFuncionario(++counter);
        setEntity(f);
    }

    public void pesquisar() {
        listaViewF.clear();
        List<Funcionario> encontrados = IFuncionarioDAO.pesquisarPorID(idFuncionario.get());
        listaViewF.addAll(encontrados);
    }

    public void remover(int idFuncionario) {
           IFuncionarioDAO.remover(idFuncionario);
           atualizarListaView();
    }
          
    

    public void atualizarListaView() {
    	listaViewF.clear();
    	listaViewF.addAll(IFuncionarioDAO.pesquisarPorID(0));
    }

    public ObservableList<Funcionario> getListaView() {
        return listaViewF;
    }
}