public class Main {
    public static void main(String[] args) {
        IProveedor empresaA = new EmpresaA();
        IProveedor empresaB = new EmpresaB();
        IProveedor empresaC = new EmpresaC();

        CatalogoSofas catalogoSofas = new CatalogoSofas();
        catalogoSofas.addProveedor(empresaA);
        catalogoSofas.addProveedor(empresaC);

        CatalogoMesas catalogoMesas = new CatalogoMesas();
        catalogoMesas.addProveedor(empresaB);
        catalogoMesas.addProveedor(empresaC);

        SistemaEmpresa miSistema = new SistemaEmpresa();
        miSistema.addCatalogo(catalogoSofas);
        miSistema.addCatalogo(catalogoMesas);

        System.out.println("--- BUSCANDO SOFÁS DE 3 PLAZAS (Une A y C) ---");
        for (Producto p : catalogoSofas.buscarPorPlazas(3)) {
            System.out.println(p);
        }

        System.out.println("\n--- REGLA A: Ordenado por Precio Ascendente (Solo en stock) ---");
        for (Producto p : miSistema.buscarYOrdenarPorPrecioAsc()) {
            System.out.println(p);
        }

        System.out.println("\n--- REGLA B: Agrupado y Ordenado por Stock Descendente ---");
        for (Producto p : miSistema.buscarYOrdenarPorUnidadesDesc()) {
            System.out.println(p);
        }
    }
}