/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.entidades;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tiago D. Teixeira
 */
@Entity
@Table(name = "USUARIOS")
@Access(AccessType.PROPERTY)
//@SequenceGenerator(name = "usuario_seq", sequenceName = "seq_usuario", initialValue = 1, allocationSize = 1)
public class Usuario implements Serializable {

    private Long id;
    private String nomeUsuario;
    private String usuario;
    private String senha;
    private boolean bloqueado;

    public Usuario() {
        super();
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(String nomeUsuario, String usuario, String senha, boolean bloqueado) {
        this.nomeUsuario = nomeUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.bloqueado = bloqueado;
    }

    public Usuario(Long id, String nomeUsuario, String usuario, String senha, boolean bloqueado) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.bloqueado = bloqueado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "usuario", nullable = true, length = 30)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "senha", nullable = true, length = 255)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "nomeUsuario", nullable = false, unique = true, length = 255)
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Column(name = "bloqueado", columnDefinition = "boolean")
    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

}
