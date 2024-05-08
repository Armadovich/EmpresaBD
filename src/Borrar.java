import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Borrar {
    static Scanner sc = new Scanner(System.in);
    public static void borrarEmpleado(Statement statement){

        try{

            System.out.println("Introduce el DNI del empleado a eliminar");
            String dni = sc.nextLine();

            statement.execute("DELETE FROM empleados WHERE dni = '"+dni+"'");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch  (InputMismatchException e){
            System.out.println(e.getMessage());
            borrarEmpleado(statement);
        }
    }

    public static void borrarDepartamento(Statement statement){

        try{

            System.out.println("Introduce el Numero del departamento a eliminar");
            int numeroDep = sc.nextInt();

            statement.execute("DELETE FROM departamentos WHERE nu_dept = '"+numeroDep+"'");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch  (InputMismatchException e){
            System.out.println(e.getMessage());
            borrarDepartamento(statement);
        }
    }
}
