package com.example.control;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import com.example.daos.IProdutoDAO;
import com.example.daos.ProdutoDAO;
import com.example.entity.Produto;


public class ProdutoControl {
	    public IntegerProperty idProduto = new SimpleIntegerProperty(0);
	    public StringProperty nomeProduto = new SimpleStringProperty("");
	    public StringProperty descricaoProduto = new SimpleStringProperty("");
	    public  DoubleProperty precoProduto = new SimpleDoubleProperty(0);
	    public   IntegerProperty quantidadePecas = new SimpleIntegerProperty(0);
	

	    private static int counter = 0;

	    private ObservableList<Produto> listaView = FXCollections.observableArrayList();
	    private IProdutoDAO IprodutoDAO = new ProdutoDAO();

	    public Produto getEntity() {
	    	Produto p = new Produto();
	        p.setIdProduto(idProduto.get());
	        p.setNomeProduto(nomeProduto.get());
	        p.setDescricaoProduto(descricaoProduto.get());
	        p.setQuantidadePeca(quantidadePecas.get());
	        p.setPrecoProduto(precoProduto.get());
	       
	        return p;
	    }

	    public void setEntity(Produto p) {
	        idProduto.set(p.getIdProduto());
	        nomeProduto.set(p.getNomeProduto());
	        descricaoProduto.set(p.getDescricaoProduto());
	        quantidadePecas.set(p.getQuantidadePeca());
	        precoProduto.set(p.getPrecoProduto());
	       
	    }

	    public void salvar() {
	    	Produto p = getEntity();
	        if (p.getIdProduto() == 0) {
	        	IprodutoDAO.adicionar(p);
	            setEntity(new Produto());
	        } else {
	        	IprodutoDAO.atualizar(idProduto.get(), p);
	        }
	        atualizarListaView();
	        
//	    	Produto p = getEntity();;
//	    	IprodutoDAO.adicionar(p);
//	         atualizarListaView();
	    
	    }

	    public void novoProduto() {
	    	Produto p = new Produto();
	        p.setIdProduto(++counter);
	        setEntity(p);
	    }

	    public void pesquisar() {
	        listaView.clear();
	        List<Produto> encontrados = IprodutoDAO.pesquisarPorNome(nomeProduto.get());
	        listaView.addAll(encontrados);
	    }

	    public void remover(int idProduto) {
	           IprodutoDAO.remover(idProduto);
	           atualizarListaView();
	           
	            }
	          
	    

	    public void atualizarListaView() {
	    	listaView.clear();
	    	listaView.addAll(IprodutoDAO.pesquisarPorNome(""));
	    }

	    public ObservableList<Produto> getListaView() {
	        return listaView;
	    }
	}
	
	


