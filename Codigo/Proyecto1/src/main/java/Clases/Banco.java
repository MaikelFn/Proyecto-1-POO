package Clases;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Representa un banco con operaciones para agregar clientes y manejar cuentas en diferentes monedas.
 */
public class Banco {
  private ArrayList<Cliente> clientes;

  /**
   * Constructor de la clase Banco.
   * Inicializa la lista de clientes.
   */
  public Banco() {
    clientes = new ArrayList<>();
  }

  /**
   * Agrega un cliente a la lista de clientes del banco.
   *
   * @param cliente El cliente a agregar.
   */
  public void agregarCliente(Cliente cliente) {
    clientes.add(cliente);
  }

  /**
   * Obtiene la lista de clientes del banco.
   *
   * @return Lista de clientes.
   */
  public ArrayList<Cliente> getClientes() {
    return clientes;
  }

  /**
   * Busca un cliente por su ID.
   *
   * @param id El ID del cliente a buscar.
   * @return El cliente si se encuentra, de lo contrario null.
   */
  public Cliente buscarClientePorID(String id) {
    for (Cliente cliente : clientes) {
      if (cliente.getIdentificacion().equalsIgnoreCase(id)) {
        return cliente;
      }
    }
    return null;
  }

  /**
   * Carga los clientes desde un archivo XML.
   *
   * @param xmlPath La ruta del archivo XML.
   */
  public void cargarClientes(String xmlPath) {
    clientes = XMLReader.leerClientesDesdeXML(xmlPath);
  }

  /**
   * Realiza un depósito en colones, convertido desde dólares.
   *
   * @param pNumeroCuenta El número de cuenta donde se deposita.
   * @param montoDolares  El monto en dólares a depositar.
   */
  public void depositarEnDolares(String pNumeroCuenta, double montoDolares) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
      Cuenta cuenta = cuentaOpt.get();
      String tipoCambioVenta = Cajero.consultarTipoCambio("venta");
      double numero = 0;
      try {
        numero = Double.parseDouble(tipoCambioVenta);
      } catch (NumberFormatException e) {
        System.out.println("Error: la cadena no es un número válido.");
      }
      double montoEnColones = montoDolares * numero;
      cuenta.realizarDeposito(montoEnColones);
      System.out.println("Depósito realizado con éxito. Monto en colones: " + montoEnColones);
    } else {
      System.out.println("Cuenta no encontrada.");
    }
  }

  /**
   * Realiza un retiro en colones, convertido desde dólares.
   *
   * @param pNumeroCuenta El número de cuenta de donde se retira.
   * @param montoDolares  El monto en dólares a retirar.
   */
  public void retirarEnDolares(String pNumeroCuenta, double montoDolares) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
      Cuenta cuenta = cuentaOpt.get();
      String tipoCambioCompra = Cajero.consultarTipoCambio("compra");
      double numero = 0;
      try {
        numero = Double.parseDouble(tipoCambioCompra);
      } catch (NumberFormatException e) {
        System.out.println("Error: la cadena no es un número válido.");
      }
      double montoEnColones = montoDolares * numero;
      cuenta.realizarRetiro(montoEnColones);
      System.out.println("Retiro realizado con éxito. Monto en colones: " + montoEnColones);
    } else {
      System.out.println("Cuenta no encontrada.");
    }
  }

  /**
   * Muestra el saldo en dólares de una cuenta.
   *
   * @param pNumeroCuenta El número de cuenta.
   */
  public void mostrarSaldoEnDolares(String pNumeroCuenta) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
      Cuenta cuenta = cuentaOpt.get();
      String tipoCambioCompra = Cajero.consultarTipoCambio("compra");
      double numero = 0;
      try {
        numero = Double.parseDouble(tipoCambioCompra);
      } catch (NumberFormatException e) {
        System.out.println("Error: la cadena no es un número válido.");
      }
      double saldoEnColones = cuenta.getSaldo();
      double saldoEnDolares = saldoEnColones / numero;
      System.out.println("El saldo en dólares es: " + saldoEnDolares);
    } else {
      System.out.println("Cuenta no encontrada.");
    }
  }

  /**
   * Busca una cuenta específica por número de cuenta.
   *
   * @param pNumeroCuenta El número de cuenta a buscar.
   * @return Un Optional que contiene la cuenta si se encuentra.
   */
  private Optional<Cuenta> buscarCuenta(String pNumeroCuenta) {
    for (Cliente cliente : getClientes()) {
      for (Cuenta cuenta : cliente.getCuentas()) {
        if (cuenta.getNumeroCuenta().equalsIgnoreCase(pNumeroCuenta)) {
          return Optional.of(cuenta);
        }
      }
    }
    return Optional.empty();
  }

  /**
   * Convierte un monto en dólares a colones.
   *
   * @param montoDolares El monto en dólares a convertir.
   * @return El monto equivalente en colones.
   */
  public double convertirDolaresAColones(double montoDolares) {
    String tasaVentaStr = Cajero.consultarTipoCambio("venta");
    double tasaVenta = tasaVentaStr != null ? Double.parseDouble(tasaVentaStr) : 540.0;
    return montoDolares * tasaVenta;
  }

  /**
   * Convierte un monto en colones a dólares.
   *
   * @param montoColones El monto en colones a convertir.
   * @return El monto equivalente en dólares.
   */
  public double convertirColonesADolares(double montoColones) {
    String tasaCompraStr = Cajero.consultarTipoCambio("compra");
    double tasaCompra = tasaCompraStr != null ? Double.parseDouble(tasaCompraStr) : 540.0;
    return montoColones / tasaCompra;
  }
}
