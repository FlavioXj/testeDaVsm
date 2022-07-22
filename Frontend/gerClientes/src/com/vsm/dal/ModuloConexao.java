/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vsm.dal;

import java.sql.*;
import java.time.Clock;

/**
 *
 * @author Flávio
 */
public class ModuloConexao {
    //metodo responsável por estabelecer conexão com BD
    public static Connection conector(){  //metodo se chama conector
        java.sql.Connection conexao = null; //variavel se chaam conexao
        //abaixo irá chaamr o driver q importei
        String driver = "com.mysql.cj.jdbc.Driver";
        // armazenar informações referente ao banco
        String url="jdbc:mysql://localhost:3306/dbgercli";
        String user = "root";
        String password = "";
        
        //estabelecendo a conexão com o banco
        try {
            
            Class.forName(driver);
            
            conexao = DriverManager.getConnection(url, user, password);            
            return conexao;
            
        } catch (Exception e) {
            //System.out.println(e);
            
            return null;
        }
    }
    
}
