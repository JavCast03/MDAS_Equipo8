package abstractfactory;

public class Main {
    public static void main(String[] args) {
        // Implementar un programa principal (main) en el mismo paquete que muestre el funcionamiento [cite: 49]
        
        System.out.println("--- PEDIDO PARA CONSUMIR EN RESTAURANTE ---");
        PedidoFactory restauranteFactory = new RestauranteFactory();
        
        PlatoMenu menuRestaurante = restauranteFactory.crearPlatoMenu("Sopa", "Filete", "patatas", "Tarta", 15.0);
        menuRestaurante.mostrarDetalles();
        System.out.println("Precio: €" + menuRestaurante.calcularPrecio());

        PlatoTemporada tempRestaurante = restauranteFactory.crearPlatoTemporada("Gazpacho", 8.0);
        tempRestaurante.mostrarDetalles();
        System.out.println("Precio: €" + tempRestaurante.calcularPrecio());


        System.out.println("\n--- PEDIDO PARA LLEVAR ---");
        PedidoFactory llevarFactory = new LlevarFactory();
        
        // Fíjate que le paso un postre ("Tarta"), pero la fábrica lo ignorará en su creación
        PlatoMenu menuLlevar = llevarFactory.crearPlatoMenu("Sopa", "Filete", "ensalada", "Tarta", 15.0);
        menuLlevar.mostrarDetalles();
        System.out.println("Precio con 2% extra: €" + menuLlevar.calcularPrecio());

        PlatoTemporada tempLlevar = llevarFactory.crearPlatoTemporada("Gazpacho", 8.0);
        tempLlevar.mostrarDetalles();
        System.out.println("Precio con 2% extra: €" + tempLlevar.calcularPrecio());
    }
}