package com.osfletes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Database;

import siena.jdbc.ddl.DdlGenerator;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;
import com.osfletes.model.User2;

public class GenerateSchema {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DdlGenerator generator = new DdlGenerator();

		// add all your classes
		//generator.addTable(Anuncio.class);
		generator.addTable(Direccion.class);
		generator.addTable(User2.class);
		generator.addTable(AnuncioMultipleLocalizado.class);
		

		// get the Database model
		Database database = generator.getDatabase();

		Platform platform = PlatformFactory.createNewPlatformInstance("mysql");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/osfletes", "root", "root");

		// if you want to print the SQL that will be executed
		String sql = platform.getAlterTablesSql(connection, database);
		System.out.println(sql);

		// this will perform the database changes
		platform.alterTables(connection, database, true);

		connection.close();	
	}
}
