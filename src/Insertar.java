import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insertar {
    static Scanner sc = new Scanner(System.in);
    public static void insertarDepartamento(Statement statement) {

        try {
            System.out.println("Introduce nombre del departamento");
            String dnombre = sc.nextLine();

            System.out.println("Introduce localidad del departamento");
            String localidad = sc.nextLine();

            statement.execute("INSERT INTO departamentos (dnombre, localidad) VALUES ('" + dnombre + "', '" + localidad + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (InputMismatchException e) {
            System.out.println("Dato no valido");
            insertarDepartamento(statement);
        }
    }

    public static void insertarEmpleado(Statement statement) {


        try {
            System.out.println("Introduce dni del empleado");
            String dni = sc.nextLine();
            System.out.println("Introduce nombre del empleado");
            String nombre = sc.nextLine();
            System.out.println("Introduce estudios del empleado");
            String estudios = sc.nextLine();
            System.out.println("Introduce direccion del empleado");
            String direccion = sc.nextLine();
            System.out.println("Introduce la fecha de alta yyyy-mm-dd.");
            String fechaAlta = sc.nextLine();
            System.out.println("Introduce salario del empleado.");
            int salario = sc.nextInt();
            System.out.println("Introduce la comision del empleado.");
            int comision = sc.nextInt();
            System.out.println("Introduce el numero de departamento del empleado.");
            int departamento = sc.nextInt();

            statement.execute("INSERT INTO empleados (dni,nombre,estudios,dir,fecha_alt,salario,comision,nu_dept) VALUES ('"+dni+"', '"+nombre+"', '"+estudios+"', '"+direccion+"', '"+fechaAlta+"', '"+salario+"', '"+comision+"','"+departamento+"')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (InputMismatchException e) {
            System.out.println("Dato no valido");
            insertarEmpleado(statement);
        }
    }
}
