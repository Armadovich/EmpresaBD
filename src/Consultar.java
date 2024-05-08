import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultar {

    static Scanner sc = new Scanner(System.in);

    public static void consultarEmpleadosNombreDpto(Statement statement){

        try {
            System.out.println("Introduce el nombre del departamento");
            String nombreDpto = sc.nextLine();

            ResultSet rs = statement.executeQuery("SELECT nu_dept FROM departamentos WHERE dnombre = '" + nombreDpto + "'");

            int dept = 0;
            if (rs.next()) {
                dept = rs.getInt("nu_dept");
            }

            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados WHERE nu_dept = '" + dept + "'");

            while(resultSet.next()){
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Estudios: " + resultSet.getString("estudios"));
                System.out.println("Direccion: " + resultSet.getString("dir"));
                System.out.println("Comision: " + resultSet.getString("comision"));
                System.out.println("Salario: " + resultSet.getString("salario"));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
    public static void consultarDepartamentoDniEmpleado(Statement statement){

        try {

            System.out.println("Introduce el DNI del empleado");
            String dniEmpleado = sc.nextLine();

            ResultSet rs = statement.executeQuery("SELECT nu_dept FROM EMPLEADOS WHERE dni = '" + dniEmpleado + "'");

            int dept = 0;

            if (rs.next()) {
                dept = rs.getInt("nu_dept");
            }

            ResultSet resultSet = statement.executeQuery("SELECT dnombre, localidad FROM departamentos WHERE nu_dept = '"+dept+"'");

            if (resultSet.next()){
                System.out.println("Nombre Depto: "+ resultSet.getString("dnombre"));
                System.out.println("Localidad: "+ resultSet.getString("localidad"));
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
