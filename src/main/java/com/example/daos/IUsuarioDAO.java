package com.example.daos;

import com.example.entity.Usuarios;
import java.util.List;

public interface IUsuarioDAO {
    void adicionar(Usuarios u);
    List<Usuarios> pesquisarPorNome(String nome);
    void atualizar(int idUsuario, String nomeUsuario, int CEP, String ruaEnderecoNumero, String cidadeEndereco,
                   String estadoEndereco, int telefoneUsuario, String tipoUsuario, String login, String senha );
    void remover(long id);
}
