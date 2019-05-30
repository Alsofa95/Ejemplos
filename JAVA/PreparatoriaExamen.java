public class Compra {

    //Constructor 

    public Compra(String dni, int cantidad) {
        this.dni = dni;
        this.cantidad = cantidad;
    }

    //M?todos 

    public getDni();

    public getCantidad();

    public setCantidad();
}

//-----------------------------------------------------------------------------------// 
public class ComprasEspectaculo {

    // Atributos 

    private final int TAMA
    ?O_INICIAL  = 10; 		  // Capacidad inicial del vector de compras. 
    private String descripcion; 								// Descripcion del espectaculo. 
    private int maximo; 												// Numero maximo de entradas que una misma persona 
    // puede adquirir para ese espectaculo. 

    private Compra[] compras; 									// Datos de las compras realizadas para ese espectaculo 
    // (ordenados de menor a mayor por DNI del comprador). 
    private int ocupados; 											// Indica las posiciones realmente ocupadas en el vector. 

    // Constructor 
    public ComprasEspectaculo(String descripcion, int maximo) {
        this.descripcion = descripcion;
        this.maximo = maximo;
        this.compras = new Compra[TAMA~NO_INICIAL
        ]; 
    this.ocupados = 0; // Inicialmente el vector no contiene datos. 
    }
//-----------------------------------------------------------------------------------// 

    public int consultarEntradas(String dni) {
        int inicio = 0;
        int fin = this.compras.lenght - 1;
        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;

            if (compras[mitad].compareTo(dni) == -1) {
                inicio = mitad + 1; //Mirar derecha 
            } else if (compras[mitad].compareTo(dni) == 1) {
                fin = mitad - 1; //Mirar izquierda 
            } else { //Encontrado 
                return compras[mitad].getCantidad();
            }
        }
        return 0;
    }

    private void redimensionar(int nuevoTama 
        ?o){ 
  	if (ocupados < nuevoTama {
            
        }?o
        
            ){ 
      Compras aux = new Compras[nuevoTama?o
            ]; 
      for (int i = 0; i < compras.lenght; i++) {
                aux[i] = compras[i];
            }
        }else 
      throw new InvalidSizeException;
    }

    public boolean a

    ?adirCompra(String dni, int cantidad) {

        int consulta = consultarEntradas(dni); //Devuelve las entradas de un cliente 
        if (cantidad <= (maximo - consulta)) { //Cumple los requisitos 
            if (consulta > 0) {
                for (int i = 0; i < compras.lenght; i++) {
                    if (compras[i].getDni.equals(dni)) {
                        compras[i].setCantidad(compras[i].getCantidad + cantidad);
                    }
                }
            } else {
                if (compras.lenght < ocupados) {

                } else {
                    redimensionar(compras.lenght * 2);
                }

            }

        } else {
            return false;
        }
        if  
 {
            
        }
    }

    public boolean a

    ?adirCompra(String dni, int cantidad) {

        int consulta = consultarEntradas(dni); //Devuelve las entradas de un cliente 
        boolean puede = false;
        if (-- -- -- -- -- -- -- -- -- ---) {
            
        }
    }

  //------------------------------------------------------------------------------------------------------// 
  //EJERCICIO 2 
    public class Cuentas {

        private static class Nodo {

            String nombre;
            double cantidad;
            Nodo sig;

            Nodo(String nombre, double cantidad, Nodo sig) {
                this.nombre = nombre;
                this.cantidad = cantidad;
                this.sig = sig;
            }
        }
        private Nodo primero;

        private void insertar(String nombre, double cantidad) {

            Nodo aux = primero;
            boolean existe = false;

            while (aux != null) {
                if (nombre.equals(aux.nombre)) {
                    aux.cantidad = aux.cantidad + cantidad;
                    existe = true;
                }
                aux = aux.sig;
            }
            if (existe == false) {
                Nodo nuevo = new Nodo(nombre, cantidad, null);
                aux.sig = nuevo;
            }
        }

        private void convertirASaldos() {
            Nodo aux = primero;
            int personas = 0;
            int dinerostotales = 0;
            while (aux != null) {
                personas++;
                dinerostotales = dinerostotales + aux.cantidad;
                aux = aux.siguiente;
            }
            double promedio = dinerostotales / personas;
            aux = primero;
            while (aux != null) {
                aux.cantidad = -promedio;
            }
        }

        public Cuentas(String nombreFichero) throws FileNotFoundException {
            Scanner sc = new Scanner(new File(nombreFichero));
            while (sc.hasNext()) {
                double cantidad = sc.nextDouble();
                String nombre = sc.next();
                insertar(nombre, cantidad);
            }
            convertirASaldos();
        }

        public void asentarPago(String pagador, String receptor, double cantidad) {
            Nodo aux = primero;
            boolean primer = false;

            while (aux != null) {
                // Saldar deudas 
                if (aux.nombre.equals(pagador)) {
                    aux.cantidad = aux.cantidad - cantidad;
                } else if (aux.nombre.equals(receptor)) {
                    aux.cantidad = aux.cantidad + cantidad;
                }

                if (aux.cantidad == 0 && primer == false) { //Primer elemento de la lista fuera 
                    primero = aux.sig;
                    primer = true;
                } else {
                    // Ultimo elemento 
                    if (aux.sig.sig == null && aux.sig.cantidad == 0) {
                        aux.sig = null 
                    } else { //Medio 
                        if (aux.sig.cantidad == 0) {
                            aux.sig = aux.sig.sig;
                        }
                    }
                }

                aux = aux.sig;
            }
        }

    }   