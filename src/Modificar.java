import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Modificar {

    static Scanner sc = new Scanner(System.in);

    public static void modificarSalarioComision(Statement statement){

        try{
            System.out.println("Introduce el dni del empleado");
            String dni = sc.nextLine();
            System.out.println("Que desea modificar, [1] salario o [2]] comision");
            int op = sc.nextInt();


            if (op == 1){
                System.out.println("Introduce el nuevo salario");
                int salario = sc.nextInt();

                statement.executeUpdate("UPDATE empleados SET salario = '"+salario+"' WHERE dni = '"+dni+"'");
            } else if (op == 2) {
                System.out.println("Introduce la nueva comision");
                int comision = sc.nextInt();

                statement.executeUpdate("UPDATE empleados SET comision = '"+comision+"' WHERE dni = '"+dni+"'");
            }else {
                System.out.println("Opcion no valida Introduce otra vez los datos");
                modificarSalarioComision(statement);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void modificarLocalidadPorNombre(Statement statement){


        try{
            System.out.println("Introduce nombre del dpto a modificar");

            String nomDpto = sc.nextLine();

            System.out.println("Introduce nueva localidad");

            String localidad = sc.nextLine();


            statement.executeUpdate("UPDATE departamentos SET localidad = '"+localidad+"' WHERE dnombre = '"+nomDpto+"'");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
