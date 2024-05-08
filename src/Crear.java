import java.sql.SQLException;
import java.sql.Statement;

public class Crear {

    public static void crearBD(Statement statement){

        String bd = "Empresa";


        try{
            statement.execute("CREATE DATABASE IF NOT EXISTS "+ bd+";");
            statement.execute("USE "+bd+";");

            statement.execute("CREATE TABLE IF NOT EXISTS departamentos"+
                    "(nu_dept int primary key auto_increment,"+
                    "dnombre varchar(10) not null UNIQUE,"+
                    "localidad varchar(10) not null)");

            statement.execute("CREATE TABLE IF NOT EXISTS empleados"+
                    "(dni varchar(9) not null primary key,"+
                    "nombre varchar(10) not null,"+
                    "estudios varchar(10) not null,"+
                    "dir varchar(10) not null,"+
                    "fecha_alt date not null,"+
                    "salario int not null,"+
                    "comision int not null,"+
                    "nu_dept int not null,"+
                    "foreign key (nu_dept) references departamentos(nu_dept)"+
                    " on delete cascade"+
                    " on update cascade)");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
