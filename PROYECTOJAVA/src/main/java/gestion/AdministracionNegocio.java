/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import operaciones.Compra;
import operaciones.Factura;
import operaciones.Venta;
import operaciones.Alquiler;
import operaciones.Devolucion;
import operaciones.Mantenimiento;
import java.time.LocalDate;
import java.util.*;
import personal.Cliente;
import personal.Trabajador;
import personal.Vendedor;
import personal.Proveedor;

/**
 *
 * @author administrador
 */
public class AdministracionNegocio {
    private final int maxTrabajadores = 9;
    private ArrayList<Vehiculo> inventarioVehiculos;
    private ArrayList<Proveedor> listaProveedores;
    private Map<String, Vendedor> listaVendedores;
    private Trabajador[] listaTrabajadores;
    private ArrayList<Venta> listaVentas;
    private ArrayList<Compra> listaCompras;
    private TreeMap<LocalDate, Alquiler> listaAlquileres;
    private ArrayList<Devolucion> listaDevoluciones;
    private ArrayList<Mantenimiento> listaMantenimientos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Factura> listaFacturas;

    private final String USERNAME = "lucia";
    private final String PASSWORD = "java2024";

    public AdministracionNegocio() {
        this.listaTrabajadores = new Trabajador[maxTrabajadores];
        this.inventarioVehiculos = new ArrayList<>();
        this.listaProveedores = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaFacturas = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
        this.listaCompras = new ArrayList<>();
        this.listaAlquileres = new TreeMap<>();
        this.listaDevoluciones = new ArrayList<>();
        this.listaMantenimientos = new ArrayList<>();
        this.listaVendedores = new HashMap<>();
    }

    public void ejecutar() {
        if (autenticarUsuario()) {
            int opcion;
            Scanner teclado = new Scanner(System.in);
            do {
                menuEntrada();
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                    case 0:
                        System.out.println("PROGRAMA FINALIZADO");
                        break;
                    case 1:
                        realizarTransacciones(teclado);
                        break;
                    case 2:
                        gestionarTrabajadores(teclado);
                        break;
                    case 3:
                        gestionarClientes(teclado);
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");
                }
            } while (opcion != 0);
        }
    }

    private boolean autenticarUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario:");
        String username = teclado.nextLine();
        System.out.println("Introduce la contraseña:");
        String password = teclado.nextLine();

        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    private void menuEntrada() {
        System.out.println("----------------------------------");
        System.out.println("|    ELIGE UNA OPCION            |");
        System.out.println("|    0) Finalizar programa       |");
        System.out.println("|    1) Realizar transacciones   |");
        System.out.println("|    2) Gestionar trabajadores   |");
        System.out.println("|    3) Gestionar clientes       |");
        System.out.println("----------------------------------");
        System.out.print("OPCION: ");
    }

    private void realizarTransacciones(Scanner teclado) {
        int opcion;
        do {
            menuTransacciones();
            opcion = teclado.nextInt();
            teclado.nextLine();
            realizarTransaccion(opcion, teclado);
        } while (opcion != 0);
    }

    private void menuTransacciones() {
        System.out.println("-------------------------------------------------");
        System.out.println("ELIGE UNA OPCION");
        System.out.println("0) Atras");
        System.out.println("1) Registrar Compra");
        System.out.println("2) Registrar Venta");
        System.out.println("3) Registrar Alquiler");
        System.out.println("4) Registrar Devolución");
        System.out.println("5) Registrar Mantenimiento");
        System.out.println("6) Lista de proveedores");
        System.out.println("7) Ver inventario de vehículos");
        System.out.println("8) Mostrar compras mensuales");
        System.out.println("9) Mostrar ventas mensuales");
        System.out.println("10) Mostrar alquileres mensuales");
        System.out.println("11) Mostrar devoluciones mensuales");
        System.out.println("12) Mostrar mantenimientos mensuales");
        System.out.println("13) Balance");
        System.out.println("14) Descartar proveedor");
        System.out.println("15) Mostrar facturas");
        System.out.println("16) Vaciar archivo de facturas");
        System.out.println("-------------------------------------------------");
    }

    private void realizarTransaccion(int opcion, Scanner teclado) {
        switch (opcion) {
            case 0:
                break;
            case 1:
                registrarCompra(teclado);
                break;
            case 2:
                registrarVenta(teclado);
                break;
            case 3:
                registrarAlquiler(teclado);
                break;
            case 4:
                registrarDevolucion(teclado);
                break;
            case 5:
                registrarMantenimiento(teclado);
                break;
            case 6:
                enseñarListaProveedores();
                break;
            case 7:
                mostrarInventarioVehiculos();
                break;
            case 8:
                mostrarComprasMes(teclado);
                break;
            case 9:
                mostrarVentasMes(teclado);
                break;
            case 10:
                mostrarAlquileresMes(teclado);
                break;
            case 11:
                mostrarDevolucionesMes(teclado);
                break;
            case 12:
                mostrarMantenimientosMes(teclado);
                break;
            case 13:
                Balance();
                break;
            case 14:
                eliminarProveedor(teclado);
                break;
            case 15:
                mostrarFacturas();
                break;
            case 16:
                vaciarArchivoFacturas();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    private void gestionarTrabajadores(Scanner teclado) {
        int opcion;
        do {
            menuTrabajadores();
            opcion = teclado.nextInt();
            teclado.nextLine();
            gestionarTrabajador(opcion);
        } while (opcion != 0);
    }

    private void menuTrabajadores() {
        System.out.println("------------------------------------------");
        System.out.println("ELIGE UNA OPCION");
        System.out.println("0) Atras");
        System.out.println("1) Añadir trabajador");
        System.out.println("2) Eliminar trabajador");
        System.out.println("3) Mostrar trabajadores");
        System.out.println("------------------------------------------");
    }

    private void gestionarTrabajador(int opcion) {
        System.out.println("ELIGE UNA OPCION");
        switch (opcion) {
            case 0:
                break;
            case 1:
                añadirTrabajador();
                break;
            case 2:
                eliminarTrabajador();
                break;
            case 3:
                mostrarTrabajadores();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    private void gestionarClientes(Scanner teclado) {
        int opcion;
        do {
            menuClientes();
            opcion = teclado.nextInt();
            teclado.nextLine();
            gestionarCliente(opcion, teclado);
        } while (opcion != 0);
    }

    private void menuClientes() {
        System.out.println("------------------------------------------");
        System.out.println("ELIGE UNA OPCION");
        System.out.println("0) Atras");
        System.out.println("1) Añadir cliente");
        System.out.println("2) Eliminar cliente");
        System.out.println("3) Mostrar clientes");
        System.out.println("------------------------------------------");
    }

    private void gestionarCliente(int opcion, Scanner teclado) {
        switch (opcion) {
            case 0:
                break;
            case 1:
                añadirCliente(teclado);
                break;
            case 2:
                eliminarCliente(teclado);
                break;
            case 3:
                mostrarClientes();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    private void registrarCompra(Scanner teclado) {
        float monto;
        String modelo;
        ColorVehiculo color;

        System.out.println("Introduce el precio:");
        monto = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("Introduce el modelo:");
        modelo = teclado.nextLine();
        System.out.println("Introduce el color (BLANCO, VERDE, AZUL, NEGRO, ROJO):");
        color = ColorVehiculo.valueOf(teclado.nextLine().toUpperCase());
        Compra compra = new Compra(monto, modelo, LocalDate.now());
        this.listaCompras.add(compra);
        System.out.println("Introduce el dni del proveedor:");
        String dnip = teclado.nextLine();

        boolean existeProveedor = false;
        for (Proveedor p : listaProveedores) {
            if (p.getDni().compareTo(dnip) == 0) {
                p.addCompra(compra);
                existeProveedor = true;
                break;
            }
        }
        if (!existeProveedor) {
            System.out.println("Proveedor no identificado. Añade sus datos:");
            System.out.println("Introduce su nombre:");
            String nombreProveedor = teclado.nextLine();
            Proveedor proveedor = new Proveedor(nombreProveedor, dnip);
            listaProveedores.add(proveedor);
        }

        System.out.println("Introduce la matrícula del vehículo:");
        String matriculav = teclado.nextLine();
        System.out.println("Introduce la cantidad de vehículos:");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        boolean encontrado = false;
        for (Vehiculo vehiculo : inventarioVehiculos) {
            if (vehiculo.getMatricula().compareTo(matriculav) == 0) {
                encontrado = true;
                vehiculo.setCantidad(vehiculo.getCantidad() + cantidad);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Vehículo no localizado. Dame los siguientes datos:");
            System.out.println("Introduce el precio:");
            monto = teclado.nextFloat();
            teclado.nextLine(); // Limpiar el buffer
            System.out.println("Introduce el color (BLANCO, VERDE, AZUL, NEGRO, ROJO):");
            color = ColorVehiculo.valueOf(teclado.nextLine().toUpperCase());

            Vehiculo vehiculo = new Vehiculo(modelo, matriculav, monto, color);
            vehiculo.setCantidad(cantidad);
            this.inventarioVehiculos.add(vehiculo);
        }
    }

    private void registrarVenta(Scanner teclado) {
        float monto = 0.0f;
        String detalle;
        System.out.println("Introduce el modelo del vehículo");
        String modeloVehiculo = teclado.nextLine();
        System.out.println("Introduzca la cantidad");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        boolean ventaPosible = false;
        Vehiculo vehiculo = null;
        for (Iterator<Vehiculo> iterator = inventarioVehiculos.iterator(); iterator.hasNext();) {
            vehiculo = iterator.next();
            if (vehiculo.getModelo().compareTo(modeloVehiculo) == 0 && vehiculo.getCantidad() >= cantidad) {
                ventaPosible = true;
                vehiculo.setCantidad(vehiculo.getCantidad() - cantidad);
                monto = cantidad * vehiculo.getPrecio();
            }
        }
        if (ventaPosible) {
            System.out.println("Introduce los detalles");
            detalle = teclado.nextLine();
            Venta venta = new Venta(monto, detalle, LocalDate.now());
            this.listaVentas.add(venta);

            System.out.println("Introduzce el dni del cliente");
            String dnic = teclado.nextLine();
            Cliente cliente = null;
            for (Iterator<Cliente> iterator = listaClientes.iterator(); iterator.hasNext();) {
                cliente = iterator.next();
                if (cliente.getDni().compareTo(dnic) == 0) {
                    cliente.addVenta(venta);
                }
            }
            if (cliente == null) {
                System.out.println("Datos no identificados. Añade el cliente:");
                System.out.println("Introduce el nombre del cliente: ");
                String nombre = teclado.nextLine();
                cliente = new Cliente(nombre, dnic);
                cliente.addVenta(venta);
                listaClientes.add(cliente);
            }
            System.out.println("Introduzca el dni del vendedor");
            String dniv = teclado.nextLine();
            Vendedor vendedor = listaVendedores.get(dniv);
            if (vendedor == null) {
                System.out.println("Datos no identificados. Añade el vendedor:");
                System.out.println("Introduzca el nombre del vendedor: ");
                String nombre = teclado.nextLine();
                System.out.println("Introduzca la fecha del contrato: ");
                System.out.println("Introduzca el día: ");
                int dia = teclado.nextInt();
                System.out.println("Introduzca el mes: ");
                int mes = teclado.nextInt();
                System.out.println("Introduzca el año: ");
                int año = teclado.nextInt();
                LocalDate fechaContrato = LocalDate.of(año, mes, dia);
                vendedor = new Vendedor(nombre, dniv, fechaContrato);
                vendedor.addVentas(1);
                this.listaVendedores.put(dniv, vendedor);
            }

            Factura factura = new Factura(venta, cliente, vehiculo);
            listaFacturas.add(factura);
        } else {
            System.out.println("No hay stock suficiente o el código del vehículo no existe");
        }
    }

    private void registrarAlquiler(Scanner teclado) {
        float monto;
        String detalle;
        System.out.println("Introduce el precio");
        monto = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("Introduce los detalles");
        detalle = teclado.nextLine();
        Alquiler alquiler = new Alquiler(monto, detalle, LocalDate.now());
        this.listaAlquileres.put(alquiler.getFecha(), alquiler);

        System.out.println("Introduce la matricula del vehículo");
        String matriculaa = teclado.nextLine();
        Vehiculo vehiculo = null;
        for (Iterator<Vehiculo> iterator = inventarioVehiculos.iterator(); iterator.hasNext();) {
            vehiculo = iterator.next();
            if (vehiculo.getMatricula().compareTo(matriculaa) == 0) {
                System.out.println("Alquiler registrado para el modelo: " + vehiculo.getModelo());
                return;
            }
        }
        System.out.println("No encontrado. Añade los siguientes datos:");
        System.out.println("Introduzca un modelo para el vehículo");
        String modelo = teclado.nextLine();
        System.out.println("Introduzca el precio");
        monto = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("Introduzca el color (BLANCO, VERDE, AZUL, NEGRO, ROJO): ");
        ColorVehiculo color = ColorVehiculo.valueOf(teclado.nextLine().toUpperCase());
        vehiculo = new Vehiculo(modelo, matriculaa, monto, color);
        this.inventarioVehiculos.add(vehiculo);
        System.out.println("Vehículo añadido y alquiler registrado");
    }

    private void registrarDevolucion(Scanner teclado) {
        float monto;
        String detalle;
        System.out.println("Introduzca el precio");
        monto = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("Introduzca los detalles");
        detalle = teclado.nextLine();
        Devolucion devolucion = new Devolucion(monto, detalle, LocalDate.now());
        this.listaDevoluciones.add(devolucion);

        System.out.println("Introduce la matricula del vehículo");
        String matriculaa = teclado.nextLine();
        Vehiculo vehiculo = null;
        for (Iterator<Vehiculo> iterator = inventarioVehiculos.iterator(); iterator.hasNext();) {
            vehiculo = iterator.next();
            if (vehiculo.getMatricula().compareTo(matriculaa) == 0) {
                System.out.println("Devolución registrada para el vehículo: " + vehiculo.getModelo());
                return;
            }
        }
    }

    private void registrarMantenimiento(Scanner teclado) {
        float monto;
        String detalle;
        System.out.println("Introduce el precio");
        monto = teclado.nextFloat();
        teclado.nextLine();
        System.out.println("Introduce los detalles");
        detalle = teclado.nextLine();
        Mantenimiento mantenimiento = new Mantenimiento(monto, detalle, LocalDate.now());
        this.listaMantenimientos.add(mantenimiento);

        System.out.println("Introduzca la matricula del vehículo");
        String matriculaa = teclado.nextLine();
        Vehiculo vehiculo = null;
        for (Iterator<Vehiculo> iterator = inventarioVehiculos.iterator(); iterator.hasNext();) {
            vehiculo = iterator.next();
            if (vehiculo.getMatricula().compareTo(matriculaa) == 0) {
                System.out.println("Mantenimiento añadido para el vehículo: " + vehiculo.getModelo());
                return;
            }
        }
        System.out.println("No se encontró el vehículo. Introduzca los siguientes datos:");
        System.out.println("Introduzca el modelo para el vehículo");
        String modelo = teclado.nextLine();
        System.out.println("Introduzca el precio");
        monto = teclado.nextFloat();
        teclado.nextLine(); // limpiar el buffer
        System.out.println("Introduzca el color (BLANCO, VERDE, AZUL, NEGRO, ROJO): ");
        ColorVehiculo color = ColorVehiculo.valueOf(teclado.nextLine().toUpperCase());
        vehiculo = new Vehiculo(modelo, matriculaa, monto, color);
        this.inventarioVehiculos.add(vehiculo);
        System.out.println("Vehículo y mantenimiento añadidos");
    }

    private void enseñarListaProveedores() {
        System.out.println("Lista de proveedores:");
        for (Proveedor proveedor : listaProveedores) {
            System.out.println(proveedor);
        }
    }

    private void mostrarInventarioVehiculos() {
        System.out.println("Inventario de vehículos:");
        for (Vehiculo vehiculo : inventarioVehiculos) {
            System.out.println(vehiculo);
        }
    }

    private void mostrarComprasMes(Scanner teclado) {
        System.out.println("Introduce el mes:");
        int mes = teclado.nextInt();
        teclado.nextLine();
        for (Compra compra : listaCompras) {
            if (compra.getFecha().getMonthValue() == mes) {
                System.out.println(compra);
            }
        }
    }

    private void mostrarVentasMes(Scanner teclado) {
        System.out.println("Introduce el mes:");
        int mes = teclado.nextInt();
        teclado.nextLine();
        for (Venta venta : listaVentas) {
            if (venta.getFecha().getMonthValue() == mes) {
                System.out.println(venta);
            }
        }
    }

    private void mostrarAlquileresMes(Scanner teclado) {
        System.out.println("Introduce el mes:");
        int mes = teclado.nextInt();
        teclado.nextLine();
        for (Map.Entry<LocalDate, Alquiler> entry : listaAlquileres.entrySet()) {
            if (entry.getKey().getMonthValue() == mes) {
                System.out.println(entry.getValue());
            }
        }
    }

    private void mostrarDevolucionesMes(Scanner teclado) {
        System.out.println("Introduce el mes:");
        int mes = teclado.nextInt();
        teclado.nextLine();
        for (Devolucion devolucion : listaDevoluciones) {
            if (devolucion.getFecha().getMonthValue() == mes) {
                System.out.println(devolucion);
            }
        }
    }

    private void mostrarMantenimientosMes(Scanner teclado) {
        System.out.println("Introduce el mes:");
        int mes = teclado.nextInt();
        teclado.nextLine();
        for (Mantenimiento mantenimiento : listaMantenimientos) {
            if (mantenimiento.getFecha().getMonthValue() == mes) {
                System.out.println(mantenimiento);
            }
        }
    }

    private void Balance() {
        double totalVentas = 0;
        double totalCompras = 0;
        for (Venta venta : listaVentas) {
            totalVentas += venta.getMonto();
        }
        for (Compra compra : listaCompras) {
            totalCompras += compra.getMonto();
        }
        double balance = totalVentas - totalCompras;
        System.out.println("Balance: " + balance);
    }

    private void eliminarProveedor(Scanner teclado) {
        System.out.println("Introduce el Dni del proveedor:");
        String dnip = teclado.nextLine();
        Proveedor proveedor = null;
        for (Iterator<Proveedor> iterator = listaProveedores.iterator(); iterator.hasNext();) {
            proveedor = iterator.next();
            if (proveedor.getDni().compareTo(dnip) == 0) {
                iterator.remove();
                System.out.println("Proveedor eliminado: " + proveedor);
                return;
            }
        }
        System.out.println("Proveedor no existente.");
    }

    private void mostrarFacturas() {
        System.out.println("Mostrando archivo de facturas:");
        for (Factura factura : listaFacturas) {
            System.out.println(factura);
        }
    }

    private void vaciarArchivoFacturas() {
        listaFacturas.clear();
        System.out.println("Archivo de facturas vaciado.");
    }

    private void añadirTrabajador() {
        int i = 0;
        for (; i < listaTrabajadores.length; i++) {
            if (listaTrabajadores[i] == null) {
                Trabajador t;
                String nombre, dni;
                LocalDate fechaContrato;
                Scanner teclado = new Scanner(System.in);
                int year, month, day;
                float salario;
                System.out.println("Introduce el dni del trabajador: ");
                dni = teclado.nextLine();
                System.out.println("Introduce el nombre: ");
                nombre = teclado.nextLine();
                System.out.println("Introduce la fecha del contrato: ");
                System.out.println("Introduce el día: ");
                day = teclado.nextInt();
                System.out.println("Introduce el mes: ");
                month = teclado.nextInt();
                System.out.println("Introduce el año: ");
                year = teclado.nextInt();
                System.out.println("Introduce el salario: ");
                salario = teclado.nextFloat();
                fechaContrato = LocalDate.of(year, month, day);
                t = new Trabajador(nombre, dni, fechaContrato, salario);
                this.listaTrabajadores[i] = t;

                i = listaTrabajadores.length + 1;
            }
        }
        if (i == listaTrabajadores.length) {
            System.out.println("Lista de trabajadores completa");
        }
    }

    private void eliminarTrabajador() {
        String dniTrabajador;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el dni del trabajador: ");
        dniTrabajador = teclado.nextLine();
        int i = 0;
        for (; i < listaTrabajadores.length; i++) {
            if (listaTrabajadores[i] != null && listaTrabajadores[i].getDni().equals(dniTrabajador)) {
                listaTrabajadores[i] = null;
                System.out.println("Trabajador con dni " + dniTrabajador + " eliminado");
                i = listaTrabajadores.length + 1;
            }
        }
    }

    private void mostrarTrabajadores() {
        for (int i = 0; i < listaTrabajadores.length; i++) {
            if (listaTrabajadores[i] != null) {
                System.out.println(listaTrabajadores[i]);
            }
        }
    }

    private void añadirCliente(Scanner teclado) {
        System.out.println("Introduce el nombre del cliente: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduce el dni del cliente: ");
        String dni = teclado.nextLine();
        Cliente cliente = new Cliente(nombre, dni);
        listaClientes.add(cliente);
        System.out.println("Cliente añadido: " + cliente);
    }

    private void eliminarCliente(Scanner teclado) {
        System.out.println("Introduce el dni del cliente: ");
        String dni = teclado.nextLine();
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getDni().equals(dni)) {
                iterator.remove();
                System.out.println("Cliente eliminado: " + cliente);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    private void mostrarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
}