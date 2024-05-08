import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Statement stmt = null;
        Connection con = null;

        try{
            Class.forName("org.mariadb.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mariadb://localhost:3306/?user=root&password";

        try{
            con = DriverManager.getConnection(url);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            stmt = con.createStatement();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Crear.crearBD(stmt);

        menu(stmt);
    }

    public static void menu(Statement stmt){

        int opcion = 0;

        while(opcion != 9){
            System.out.println("-------------------MENU------------------");

            System.out.println("0. Crear BD");
            System.out.println("1. Insertar nuevo departamento");
            System.out.println("2. Insertar Empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Eliminar departamento");
            System.out.println("5. Consultar empleados por nombre de dpto");
            System.out.println("6. Consultar deptos por dni empleado");
            System.out.println("7. Modificar salario o comision");
            System.out.println("8. Modificar Depto por Nombre");
            System.out.println("9. SALIR");
            opcion = sc.nextInt();

            switch (opcion){
                case 0:
                    Crear.crearBD(stmt);
                    break;
                case 1:
                    Insertar.insertarDepartamento(stmt);
                    break;
                case 2:
                    Insertar.insertarEmpleado(stmt);
                    break;
                case 3:
                    Borrar.borrarEmpleado(stmt);
                    break;
                case 4:
                    Borrar.borrarDepartamento(stmt);
                    break;
                case 5:
                    Consultar.consultarEmpleadosNombreDpto(stmt);
                    break;
                case 6:
                    Consultar.consultarDepartamentoDniEmpleado(stmt);
                    break;
                case 7:
                    Modificar.modificarSalarioComision(stmt);
                    break;
                case 8:
                    Modificar.modificarLocalidadPorNombre(stmt);
                    break;
            }
        }




    }
}